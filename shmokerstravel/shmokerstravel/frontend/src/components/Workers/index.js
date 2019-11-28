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
import {format} from "date-fns";
import Button from "../Button";

const getRowId = row => row.employeeId;

const Workers = ({ show, onHide, hash }) => {
  const [columns] = useState([
    {name: "employeeId", title: "ID"},
    { name: "firstName", title: "First Name" },
    { name: "secondName", title: "Second Name" },
    { name: "startedDate", title: "Started Date" },
    { name: "salary", title: "Salary" },
    { name: "makePayment", title: "Make Payment"},
  ]);
  const [rows, setRows] = useState([]);
  const [editingStateColumnExtensions] = useState([
    { columnName: "firstName", editingEnabled: false },
    { columnName: "secondName", editingEnabled: false },
    { columnName: "startedDate", editingEnabled: false },
    { columnName: "employeeId", editingEnabled: false },
    { columnName: "makePayment", editingEnabled: false },
  ]);

  const commitChanges = async ({ changed }) => {
    let changedRows;
    if (changed) {
      for (const [key, value] of Object.entries(changed)) {
        await fetch("http://localhost:8080/employee/update", {
          method: "POST",
          headers: { "Content-type": "application/json" },
          body: JSON.stringify({
            hash,
            employeeId: key,
            salary: value.salary
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

  const makePayment = async (employee) => {
    await fetch("http://localhost:8080/payCheck", {
      method: "POST",
      headers: { "Content-type": "application/json" },
      body: JSON.stringify({
        employeeId: employee.employeeId,
        amount: employee.salary
      })
    });
    alert("Payment was succesfully done");
  };

  useEffect(() => {
    const fetchData = async () => {
      const response = await fetch(`http://localhost:8080/getAgents`);
      const result = await response.json();
      setRows(
          result.map(res => {
            res.secondName = res.lastName;
            res.startedDate = format(new Date(res.employmentDate), "dd.MM.yyyy");
            res.makePayment = <Button text={"Make Payment"} onClick={() => makePayment(res)}/>;
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
