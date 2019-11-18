import React, { useState } from 'react';

import SearchForm from '../../components/SearchForm';
import ResultTable from '../../components/ResultTable';

import './index.css';

const Main = () => {
	const [showResults, setShowResults] = useState(false);
	const [date, setDate] = useState(new Date());
	const [departure, setDeparture] = useState('');
	const [arrival, setArrival] = useState('');
	const [passengers, setPassengers] = useState(1);
	const [results, setResult] = useState([]);

	const onSearchClick = async () => {
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
						results={results}
					/>
				) : (
					<>
						<SearchForm
							setArrival={setArrival}
							setDate={setDate}
							setDeparture={setDeparture}
							setPassengers={setPassengers}
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
