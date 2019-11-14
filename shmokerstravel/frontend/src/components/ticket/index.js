import React from 'react';
import './index.css';

const Ticket = () =>{
    return (
        <div>
             <h1 className="ticket-title">Tickets</h1>
            <div className="the-main-ticket">
                    <div className="ticket-train">
                            <div className="ticket-text">
                                Ticket: <span className="ticket-number">13548</span>
                            </div>
                            <div className="ticket-text">
                                Train: <span className="train-number">9</span>
                            </div>
                            <div className="ticket-text">
                                Seat: <span className="seat-number">12</span>
                            </div>
                            <div className="ticket-text">
                                Vagon: <span className="vagon-number">5</span>
                            </div>
                            <div className="ticket-text">
                                Price: <span className="ticket-price">12000 tg</span>
                            </div>
                    </div>
                    <div className="ticket-route">
                            <div className="ticket-time">
                                <div className="ticket-time-c">
                                    <div className="ticket-text">
                                        {/* {format(res.departureDateTime, 'HH:mm')},{' '} */}
                                        12:22
                                        Almaty
                                    </div>
                                    <div className="ticket-time-mm">
                                        {/* {format(res.departureDateTime, 'MMMM dd')} */}
                                        12 august 2018
                                    </div>
                                </div>
                                <hr className="line" />
                                <div className="ticket-time-c">
                                    <div className="ticket-text">
                                        {/* {format(res.arrivalDateTime, 'HH:mm')},{' '} */}
                                        18:55
                                        Astana
                                    </div>
                                    <div className="ticket-time-mm">
                                        {/* {format(res.arrivalDateTime, 'MMMM dd')} */}
                                        13 august 2018
                                    </div>
                                </div>
                            </div>
                            <hr className="line2" />
                                <div className="ticket-owner">
                                    <div className="ticket-text">Name: <span className="text-name">Nartay   </span></div> 
                                    <div className="ticket-text">Surname: <span className="text-surname">Zhanybekov</span></div>
                                </div> 
                    </div>   
                </div>
        </div>
    )
};
export default Ticket;