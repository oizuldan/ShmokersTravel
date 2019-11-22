import React, { useEffect, useState } from "react";
import Modal from "react-bootstrap/Modal";
import Paper from "@material-ui/core/Paper";
import { EditingState } from "@devexpress/dx-react-grid";
import {
  Grid,
  Table,
  TableHeaderRow,
  TableEditRow,
  TableEditColumn
} from "@devexpress/dx-react-grid-material-ui";
import { format } from "date-fns";
import "./index.css";
import Button from "../Button";
import SearchItem from "../SearchForm/SearchItem";

const getRowId = row => row.id;

const Routes = ({ show, onHide }) => {
  const [columns] = useState([
    { name: "id", title: "Route id" },
    { name: "departureTrainStationName", title: "Departure Station" },
    { name: "arrivalTrainStationName", title: "Arrival Station" },
    { name: "departureDateTime", title: "Departure time" },
    { name: "arrivalDateTime", title: "Arrival time" }
  ]);
  const [rows, setRows] = useState([]);
  const [current, setCurrent] = useState("add");
  const [date, setDate] = useState(new Date());
  const [departure, setDeparture] = useState("");
  const [arrival, setArrival] = useState("");

  useEffect(() => {
    const fetchData = async () => {
      const response = await fetch(`http://localhost:8080/allTrips`);
      const result = await response.json();
      setRows(
        result.map(res => {
          res.departureDateTime = format(
            new Date(res.departureDateTime),
            "dd.MM hh.mm"
          );
          res.arrivalDateTime = format(
            new Date(res.arrivalDateTime),
            "dd.MM hh.mm"
          );
          return res;
        })
      );
    };
    fetchData();
  }, []);

  const commitChanges = ({ deleted }) => {
      let changedRows;
      if (deleted) {
          const deletedSet = new Set(deleted);
          deleted.forEach(async (trip) => {
              await fetch(`http://localhost:8080/deleteTrip/${Number(trip)}`, {
                  method: "DELETE",
                  headers: { "Content-type": "application/json" },
              });
          });
          changedRows = rows.filter(row => !deletedSet.has(row.id));
      }
      setRows(changedRows);
  };

  const onClick = async () => {
    await fetch("http://localhost:8080/createTrip", {
      method: "POST",
      headers: { "Content-type": "application/json" },
      body: JSON.stringify({
        departureTrainStationName: departure,
        arrivalTrainStationName: arrival,
        dateTime: date.getTime()
      })
    });
    setDeparture("");
    setArrival("");
    setDate(new Date());
  };

  return (
    <Modal show={show} onHide={onHide} size="xl">
      <Modal.Body>
        <div className="modal-title">Workers</div>
        <div
          onClick={() => setCurrent(curr => (curr === "add" ? "show" : "add"))}
          className="route-change-state"
        >
          {current === "add" ? "Show all routes" : "Add new route"}
        </div>
        {current === "add" ? (
          <div className="search-container">
            <SearchItem
              placeholder="From"
              type="text"
              onChange={e => setDeparture(e.target.value)}
            />
            <SearchItem
              placeholder="To"
              type="text"
              onChange={e => setArrival(e.target.value)}
            />
            <SearchItem
              placeholder="Departure"
              type="date"
              startDate={date}
              onChange={date => setDate(date)}
              time={true}
            />
            <Button
              className="but-wrapper"
              text="Add route"
              onClick={onClick}
              disabled={!departure.length || !arrival.length}
            />
          </div>
        ) : (
          <Paper>
            <Grid rows={rows} columns={columns} getRowId={getRowId}>
              <EditingState onCommitChanges={commitChanges} />
              <Table />
              <TableHeaderRow />
              <TableEditRow />
              <TableEditColumn showDeleteCommand />
            </Grid>
          </Paper>
        )}
      </Modal.Body>
    </Modal>
  );
};

export default Routes;
