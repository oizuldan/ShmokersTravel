import React, {useEffect, useState} from "react";
import Modal from "react-bootstrap/Modal";
import Paper from "@material-ui/core/Paper";
import {
    Grid,
    Table,
    TableHeaderRow,
} from "@devexpress/dx-react-grid-material-ui";

import "./index.css";
import {format} from "date-fns";

const getRowId = row => row.id;

const Payments = ({ show, onHide }) => {
    const [columns] = useState([
        {name: "userId", title: "ID"},
        { name: "paymentDate", title: "Payment Date" },
        { name: "amount", title: "Amount" },
    ]);
    const [rows, setRows] = useState([]);


    useEffect(() => {
        const fetchData = async () => {
            const response = await fetch(`http://localhost:8080/getPayChecks`);
            const result = await response.json();
            setRows(
                result.map(res => {
                    res.paymentDate = format(new Date(res.date), "dd.MM.yyyy");
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
        >
            <Modal.Body>
                <div className="modal-title">Payments</div>
                <Paper>
                    <Grid rows={rows} columns={columns} getRowId={getRowId}>
                        <Table />
                        <TableHeaderRow />
                    </Grid>
                </Paper>
            </Modal.Body>
        </Modal>
    );
};

export default Payments;
