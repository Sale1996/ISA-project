import React, {Component} from 'react'
import { Link } from "react-router-dom"
import UserLoggedTabs from '../layout/UserLoggedTabs';
import "./izlistavanje.css"

class HotelIzlistavanje extends Component {

    render() {
        return (
            <div>
                <UserLoggedTabs></UserLoggedTabs>
                <div className = "container center">
                    <h2 className="red-text lighten-1 center">Lista hotela</h2>
                    <div className = "post card grey lighten-2">
                        <div className = "card-content container">
                            <span className = "card-title center">Mali Poslovni Sistem</span>
                            <div className = "left-align">
                                <p>Adresa:</p>
                                <p>Opis:</p>
                                <Link to="/#">Prikaz na mapi</Link>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }

};
export default HotelIzlistavanje;
