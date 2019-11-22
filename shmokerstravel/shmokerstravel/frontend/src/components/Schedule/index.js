import React, { useState } from "react";
import Modal from "react-bootstrap/Modal";
import Paper from "@material-ui/core/Paper";
import { format } from "date-fns";
import {
  Grid,
  Table,
  TableHeaderRow
} from "@devexpress/dx-react-grid-material-ui";

const getRowId = row => row.routeId;

const ScheduleModal = ({ show, results, onHide, station }) => {
  const columns = [
    { name: "routeId", title: "Route Number" },
    { name: "route", title: "Route" },
    { name: "arrival", title: `Arrives to ${station}` },
    { name: "departure", title: `Departs from ${station}` }
  ];

  const arr = results.map(res => {
    const route = res[0] + " - " + res[1];
    const routeId = res[2];
    const arrival = res[3] ? format(res[3], "HH:mm") : "-";
    const departure = res[4] ? format(res[4], "HH:mm") : "-";
    return {
      route,
      routeId,
      arrival,
      departure
    };
  });

  return (
    <Modal show={show} id="white-back" onHide={onHide} size="xl">
      <Modal.Body>
        <div className="modal-title">Schedule</div>
        <Paper>
          <Grid rows={arr} columns={columns} getRowId={getRowId}>
            <Table />
            <TableHeaderRow />
          </Grid>
        </Paper>
      </Modal.Body>
    </Modal>
  );
};

export default ScheduleModal;
