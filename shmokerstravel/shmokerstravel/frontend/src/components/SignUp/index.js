import React, { useState } from 'react';
import Modal from 'react-bootstrap/Modal';

import Button from '../Button';
import { validateEmail } from '../../helpers/validate';

const SignUp = ({ show, handleClose, logIn }) => {
	const [email, setEmail] = useState('');
	const [firstName, setFirstName] = useState('');
	const [secondName, setSecondName] = useState('');
	const [password, setPassword] = useState('');
	const [error, setError] = useState([]);
	const [phone, setPhone] = useState('');

	const checkUser = async () => {
		if (validateEmail(email) && password.length > 0) await onSuccess();
		else onError(email, password);
	};

	const onSuccess = async () => {
		const response = await fetch('http://localhost:8080/user/create', {
			method: 'POST',
			headers: { 'Content-type': 'application/json' },
			body: JSON.stringify({ password, phone, firstName, secondName, email })
		});
		const res = await response.json();
		logIn(res);
		handleClose();
	};

	const onError = (em, pass) => {
		const errors = [];
		if (!validateEmail(em)) errors.push('Invalid email');
		if (pass.length === 0) errors.push('Password can not be empty');
		setError(errors);
	};

	return (
		<Modal show={show} onHide={handleClose} className="modal">
			<Modal.Body>
				<div className="modal-title">Sign Up</div>
				<div className="input-container">
					<span className="input-placeholder">First Name:</span>
					<input
						type="text"
						className="input-field"
						onChange={e => setFirstName(e.target.value)}
						value={firstName}
					/>
				</div>
				<div className="input-container">
					<span className="input-placeholder">Last Name:</span>
					<input
						type="text"
						className="input-field"
						onChange={e => setSecondName(e.target.value)}
						value={secondName}
					/>
				</div>
				<div className="input-container">
					<span className="input-placeholder">Email:</span>
					<input
						type="text"
						className="input-field"
						value={email}
						onChange={e => setEmail(e.target.value)}
					/>
				</div>
				<div className="input-container">
					<span className="input-placeholder">Phone:</span>
					<input
						className="input-field"
						value={phone}
						onChange={e => setPhone(e.target.value)}
					/>
				</div>
				<div className="input-container">
					<span className="input-placeholder">Password:</span>
					<input
						type="password"
						className="input-field"
						value={password}
						onChange={e => setPassword(e.target.value)}
					/>
				</div>
				<div>
					{error.map(err => (
						<div key={err} className="error">
							{err}
						</div>
					))}
				</div>
				<Button className="input-button" onClick={checkUser} text="Submit" />
			</Modal.Body>
		</Modal>
	);
};

export default SignUp;
