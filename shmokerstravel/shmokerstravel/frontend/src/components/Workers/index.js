import React, { useState } from "react";
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

const getRowId = row => row.id;

const Workers = ({ show, workers, onHide }) => {
  const [columns] = useState([
    { name: "firstName", title: "First Name" },
    { name: "secondName", title: "Second Name" },
    { name: "salary", title: "Salary" }
  ]);
  const [rows, setRows] = useState(workers);
  const [editingStateColumnExtensions] = useState([
    { columnName: "firstName", editingEnabled: false },
    { columnName: "secondName", editingEnabled: false }
  ]);

  const commitChanges = ({ changed }) => {
    let changedRows;
    if (changed) {
      changedRows = rows.map(row =>
        changed[row.id] ? { ...row, ...changed[row.id] } : row
      );
    }
    setRows(changedRows);
  };

  return (
    <Modal
      show={show}
      id="white-back"
      onHide={onHide}
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
