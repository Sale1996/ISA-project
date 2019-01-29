import React from "react"
import StarRating from "./StarRating";
import CancelReservation from "./CancelReservation"
import DeleteFromShoppingCart from "./DeleteFromShoppingCart"
import { BrowserRouter, Switch, Route } from "react-router-dom";


const CarReservation = () => {

    return (
        <div className="card">

            <div className="card-content">

                <span className="card-title red-text lighten-1"><strong>Vozilo</strong></span>
                <div className="container">
                    <div className="row ">
                        <div className="col s4">
                            <p>Zubac Komerc</p>
                        </div>
                        <BrowserRouter>
                            <div className="col s4">
                                <Route path="/userReservations" component={StarRating}></Route>
                            </div>
                        </BrowserRouter>
                        <BrowserRouter>
                            <div className="col s4">
                                <Switch>
                                    <Route exact path="/korpa" component={DeleteFromShoppingCart}></Route>
                                    <Route exact path="/userReservations" component={CancelReservation}></Route>
                                </Switch>
                            </div>
                        </BrowserRouter>
                    </div>
                    <div className="row">
                        <div className="col s4">
                            <p>BMW x5</p>
                        </div>
                        <BrowserRouter>
                            <div className="col s4">
                                <Route path="/userReservations" component={StarRating}></Route>
                            </div>
                        </BrowserRouter>
                    </div>
                    <p className="red-text lighten-3 left"> <strong>Cena: 4000 din</strong></p>
                </div>



            </div>

        </div>
    );

};

export default CarReservation;