import React from 'react'
import "./index.css";
import ph from '../cards/photos.js'
// import { url } from 'inspector';
const Cards = ()=>{
    return(
    <div className='student-cards'>
        
        <div className = 'info-student'>
            <h5>Aisultan Kassenov</h5>
            <img className='student-photos' src={ph[0]}  />
            <p>aisultan.kassenov @nu.edu.kz</p>
        </div>
        <div className = 'info-student'>
            <h5>Nartay Zhanybekov</h5>
            <img className='student-photos' src={ph[1]}  />
            <p>nartay.zhanybekov @nu.edu.kz</p>
        </div>
        <div className = 'info-student'>
            <h5>Nursultan Akhmetzhanov</h5>
            <img className='student-photos' src={ph[2]}  />
            <p>nursultan.akhmetzhanov @nu.edu.kz</p>
        </div>
        <div className = 'info-student'>
            <h5>Alik Hui</h5>
            <img className='student-photos' src={"https://images-na.ssl-images-amazon.com/images/I/5128WAbqHBL._SX355_.jpg"}  />
            <p>alik.hui @nu.edu.kz</p>
        </div>
        <div className = 'info-student'>
            <h5>Aldiyar Sharapiden</h5>
            <img className='student-photos' src={ph[4]}  />
            <p>aldiyar.sharapiden @nu.edu.kz</p>
        </div>
        <div className = 'info-student'>
            <h5>Dias Zhassanbay</h5>
            <img className='student-photos' src={ph[5]}  />
            <p>dias.zhassanbay @nu.edu.kz</p>
        </div>
    </div>
    )
}

export default Cards;