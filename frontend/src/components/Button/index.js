import React from 'react';

import './index.css'

const Button = ({onClick, text, className, type='primary', disabled}) => {
    return <div className={className}>
        <button className={`button ${type}`} onClick={onClick} disabled={disabled}>
            {text}
        </button>
    </div>
};

export default Button;