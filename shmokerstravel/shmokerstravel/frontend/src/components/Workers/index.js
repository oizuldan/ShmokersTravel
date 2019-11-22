import React, {useEffect, useState} from "react";
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

import "./index.css";
import Button from "../Button";
import {format} from "date-fns";

const getRowId = row => row.employeeId;

const Workers = ({ show, onHide }) => {
  const [columns] = useState([
    {name: "employeeId", title: "ID"},
    { name: "firstName", title: "First Name" },
    { name: "secondName", title: "Second Name" },
    { name: "startedDate", title: "Started Date" },
    { name: "salary", title: "Salary" }
  ]);
  const [rows, setRows] = useState([]);
  const [editingStateColumnExtensions] = useState([
    { columnName: "firstName", editingEnabled: false },
    { columnName: "secondName", editingEnabled: false },
    { name: "startedDate", title: "Started Date" }
  ]);

  const commitChanges = async ({ changed }) => {
    let changedRows;
    if (changed) {
      console.log(changed)
      for (const [key, value] of Object.entries(changed)) {
        await fetch("http://localhost:8080/employee/update", {
          method: "POST",
          headers: { "Content-type": "application/json" },
          body: JSON.stringify({
            employeeId: key,
            salary: value
          })
        });
      }
      changedRows = rows.map((row) => {
            return changed[row.employeeId] ? {...row, ...changed[row.employeeId]} : row
        }
      );
    }
    setRows(changedRows);
  };

  useEffect(() => {
    const fetchData = async () => {
      const response = await fetch(`http://localhost:8080/getAgents`);
      const result = await response.json();
      setRows(
          result.map(res => {

            res.secondName = res.lastName;
            res.startedDate = format(new Date(res.employmentDate), "dd.MM.yyyy");
            return res;
          })
      );
    };
    fetchData();
  }, []);

  return (
    <Modal
      show={show}
      id="white-back"
      onHide={onHide}
      size="xl"
    >
      <Modal.Body>
        <div className="modal-title">Workers</div>
        <Paper>
          <Grid rows={rows} columns={columns} getRowId={getRowId}>
            <EditingState
              onCommitChanges={commitChanges}
              columnExtensions={editingStateColumnExtensions}
            />
            <Table />
            <TableHeaderRow />
            <TableEditRow />
            <TableEditColumn showEditCommand />
          </Grid>
        </Paper>
      </Modal.Body>
    </Modal>
  );
};

export default Workers;
