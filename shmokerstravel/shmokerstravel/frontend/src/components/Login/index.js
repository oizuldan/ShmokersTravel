import React, { useState } from 'react';
import Modal from 'react-bootstrap/Modal';
import Button from '../Button';
import { validateEmail } from '../../helpers/validate';

import './index.css';

const Login = ({ show, handleClose, logIn }) => {
	const [email, setEmail] = useState('');
	const [password, setPassword] = useState('');
	const [error, setError] = useState([]);

	const checkUser = () => {
		if (validateEmail(email) && password.length > 0) onSuccess();
		else onError(email, password);
	};

	const onSuccess = async () => {
		const response = await fetch('http://localhost:8080/user/login', {
			method: 'POST',
			headers: { 'Content-type': 'application/json' },
			body: JSON.stringify({ password, email })
		});
		const res = await response.json();
		if (res) {
			logIn(res);
			handleClose();
		} else {
			onError('sdvsdv', 'asdf');
		}
	};

	const onError = (em, pass) => {
		const errors = [];
		if (!validateEmail(em)) errors.push('Invalid email');
		if (pass.length === 0) errors.push('Password can not be empty');
		setError(errors);
	};

	const onHide = () => {
		setError([]);
		handleClose();
	};

	return (
		<Modal show={show} onHide={onHide} className="modal">
			<Modal.Body>
				<div className="modal-title">Log In</div>
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
					<span className="input-placeholder">Password:</span>
					<input
						type="password"
						className="input-field"
						value={password}
						onChange={e => setPassword(e.target.value)}
					/>
				</div>
				<div>
					{error.map((err, index) => (
						<div className="error" key={index}>{err}</div>
					))}
				</div>
				<Button className="input-button" onClick={checkUser} text="Submit" />
				<div className="password-forgot">Forgot Password?</div>
			</Modal.Body>
		</Modal>
	);
};

export default Login;
