import React, { useState } from 'react';

import SearchForm from '../../components/SearchForm';
import ResultTable from '../../components/ResultTable';
import Train from "../../components/Train";

import './index.css';

const resultsMock = [
	{
		departureTrainStationName: 'Nur-Sultan',
		arrivalTrainStationName: 'Almaty',
		departureDateTime: new Date(),
		arrivalDateTime: new Date(),
        avlbSeats: 100,
		id: '125NM',
        price: 10000
    },
    {
		departureTrainStationName: 'Nur-Sultan',
		arrivalTrainStationName: 'Almaty',
		departureDateTime: new Date(),
		arrivalDateTime: new Date(),
        avlbSeats: 100,
		id: '125NM',
        price: 10040
    },
];

const Main = () => {
	const [showResults, setShowResults] = useState(true);
	const [date, setDate] = useState(new Date());
	const [departure, setDeparture] = useState('');
	const [arrival, setArrival] = useState('');
	const [results, setResult] = useState([]);
	const [isLoading, setIsLoading] = useState(false);

	const onSearchClick = async () => {
		setIsLoading(true);
		const response = await fetch(
			`http://localhost:8080/route?departure=${departure.trim()}&arrival=${arrival.trim()}`
		);
		const result = await response.json();
		setResult(result);
		setShowResults(true);
	};

	const onBackClick = () => {
		setShowResults(false);
		setDeparture('');
		setArrival('');
	};

	return (
		<div className="main">
			<div className="vertically-centered">
				{showResults ? (
					<ResultTable
						depCity={departure}
						arrCity={arrival}
						date={date}
						onClick={onBackClick}
						results={resultsMock}
					/>
				) : isLoading ? <Train/> : (
					<>
						<SearchForm
							setArrival={setArrival}
							setDate={setDate}
							setDeparture={setDeparture}
							date={date}
							onClick={onSearchClick}
							disabled={!departure.length || !arrival.length}
						/>
						<div className="promo-text">
							Plan your vacation to the most beautiful <br /> places of
							Kazakhstan
						</div>
					</>
				)}
			</div>
		</div>
	);
};

export default Main;
