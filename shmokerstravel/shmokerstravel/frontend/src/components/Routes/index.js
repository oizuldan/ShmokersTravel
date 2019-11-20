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

const Routes = ({ show, workers, onHide }) => {
    const [columns] = useState([
        { name: "firstName", title: "First Name" },
        { name: "secondName", title: "Second Name" },
        { name: "salary", title: "Salary" }
    ]);
    const [rows, setRows] = useState(workers);

    const commitChanges = ({ changed, added, deleted }) => {
        let changedRows;
        if (added) {
            const startingAddedId = rows.length > 0 ? rows[rows.length - 1].id + 1 : 0;
            changedRows = [
                ...rows,
                ...added.map((row, index) => ({
                    id: startingAddedId + index,
                    ...row,
                })),
            ];
        }
        if (changed) {
            changedRows = rows.map(row => (changed[row.id] ? { ...row, ...changed[row.id] } : row));
        }
        if (deleted) {
            const deletedSet = new Set(deleted);
            changedRows = rows.filter(row => !deletedSet.has(row.id));
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
                        />
                        <Table />
                        <TableHeaderRow />
                        <TableEditRow />
                        <TableEditColumn showEditCommand showAddCommand showDeleteCommand/>
                    </Grid>
                </Paper>
            </Modal.Body>
        </Modal>
    );
};

export default Routes;
