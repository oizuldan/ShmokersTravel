import React from 'react';
import { format } from 'date-fns';

import Button from '../../Button';

import './index.css';

const ResultInfo = ({ res }) => {
	return (
		<div className="result-info">
			<div className="result-train">
				<div className="result-text">
					{res.departureTrainStationName} - {res.arrivalTrainStationName}
				</div>
				<div className="result-text">Train # {res.id}</div>
			</div>
			<div className="result-time">
				<div className="result-time-c">
					<div className="result-text">
						{format(res.departureDateTime, 'HH:mm')},{' '}
						{res.departureTrainStationName}
					</div>
					<div className="result-time-mm">
						{format(res.departureDateTime, 'MMMM dd')}
					</div>
				</div>
				<hr />
				<div className="result-time-c">
					<div className="result-text">
						{format(res.arrivalDateTime, 'HH:mm')},{' '}
						{res.arrivalTrainStationName}
					</div>
					<div className="result-time-mm">
						{format(res.arrivalDateTime, 'MMMM dd')}
					</div>
				</div>
			</div>
			<div className="result-seat">
				<div className="result-text">
					Available seats: <span className="seats-number">{res.avlbSeats}</span>
				</div>
				<div className="result-text">
					Price: <span className="seat-price">{res.price}tg</span>
				</div>
				<Button className="buy-button" text="Buy" type="additional" />
			</div>
		</div>
	);
};

export default ResultInfo;
