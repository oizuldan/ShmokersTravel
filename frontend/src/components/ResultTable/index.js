import React from 'react'

const results = [
    {
        depCity: 'Nur-Sultan',
        arrCity: 'Almaty',
        depTime: Date.now(),
        arrTime: Date.now(),
        avlbSeats: 100,
    },
    {
        depCity: 'Nur-Sultan',
        arrCity: 'Almaty',
        depTime: Date.now(),
        arrTime: Date.now(),
        avlbSeats: 100,
    }
]


const ResultTable = () => {
    return (
        <div className="result-table">
            <div className="header">
                <div>Results on </div>
            </div>
        </div>
    )
};

export default ResultTable;