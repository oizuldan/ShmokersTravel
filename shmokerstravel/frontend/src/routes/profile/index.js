import React from 'react'
import Ticket from '../../components/ticket'
import ProfileSettings from "../profile-settings"
import './index.css'

const Profile = ()=>{
    return (
        <div>
            <div className="profile">
                <h1 className="profile-title">Profile<a className="profile-settings" href = "profile-settings">Profile Settings</a></h1>
                
                <div className="profile-row">
                    <div className="profile-key">First Name:</div>
                    <div className="profile-value">Nursultan</div>
                </div>
                <div className="profile-row">
                    <div className="profile-key">Last Name:</div>
                    <div className="profile-value">Nursultan</div>
                </div>
                <div className="profile-row">
                    <div className="profile-key">Email:</div>
                    <div className="profile-value">Nursultan</div>
                </div>
                <div className="profile-row">
                    <div className="profile-key">Phone:</div>
                    <div className="profile-value">Nursultan</div>
                </div>
            </div>
            <Ticket/>

		</div>
        )
};

export default Profile;