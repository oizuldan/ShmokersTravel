import React from 'react'

import './index.css'

const ProfileSettings = ()=>{
    return (
        <div>
            <div className="profile">
                <h1 className="profile-title">Profile-Settings</h1>
                
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
            

		</div>
        )
};

export default ProfileSettings;