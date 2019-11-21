import React from 'react'
import "./index.css";
import ph from '../cards/photos.js'
const Cards = ()=>{
    return(
    <div className='student-cards'>
        
        <div className = 'info-student'>
            <h5>Aisultan Kassenov</h5>
            <img className='student-photos' src={ph[0]} alt="ais"/>
            <p>aisultan.kassenov @nu.edu.kz</p>
        </div>
        <div className = 'info-student'>
            <h5>Nartay Zhanybekov</h5>
            <img className='student-photos' src={ph[1]} alt="nortyi"/>
            <p>nartay.zhanybekov @nu.edu.kz</p>
        </div>
        <div className = 'info-student'>
            <h5>Nursultan Akhmetzhanov</h5>
            <img className='student-photos' src={ph[2]} alt="nurs"/>
            <p>nursultan.akhmetzhanov @nu.edu.kz</p>
        </div>
        <div className = 'info-student'>
            <h5>Alinur Amangazy</h5>
            <img className='student-photos' src={ph[3]} alt="alik"/>
            <p>alinur.amangazy @nu.edu.kz</p>
        </div>
        <div className = 'info-student'>
            <h5>Aldiyar Sharapiden</h5>
            <img className='student-photos' src={ph[4]} alt="shara"/>
            <p>aldiyar.sharapiden @nu.edu.kz</p>
        </div>
        <div className = 'info-student'>
            <h5>Dias Zhassanbay</h5>
            <img className='student-photos' src={ph[5]} alt="dias"/>
            <p>dias.zhassanbay @nu.edu.kz</p>
        </div>
    </div>
    )
}

export default Cards;