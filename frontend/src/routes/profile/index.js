import React from 'react'
import './index.css'

const Profile = ()=>{
    return(
        <div>
            <div className = "title">
                <h3>Profile
                    <br/>
                    <h6>Zhanybekov Nartay</h6>
                </h3>
                <p className = 'email'>nartay.zhanybekov@nu.edu.kz</p>
            </div>
            <ul className = 'menu'>
                <li>
                    <p>Orders</p>
                </li>
                <li>
                    <p>Service desk </p>
                </li>
                <li>
                    <p>Finance</p>
                </li>
                <li>
                    <p>Settings</p>
                </li>
                <li>
                    <p>My cards</p>
                </li>

                <li>
                    <p>Passengers</p>
                </li>
            </ul>
            <div className = 'ticket'>
                <ul className = 'products'>
                    <li className = 'product'>
                        <ul className = 'order'>
                            <li className = 'aviaticket'>Avia Ticket:</li>
                            <li className = 'aviaticket_info'>
                                <div className = 'passenger'>Zhanybekov Nartay</div>
                                <div className = 'flight_info'>
                                    <div className = 'cities'>Almaty - Astana</div>
                                    <div className = 'date'>15:40, 13 august</div>
                                </div>
                                </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
            )
}
export default Profile;