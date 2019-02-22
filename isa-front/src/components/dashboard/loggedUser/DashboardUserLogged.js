import React, { Component } from "react"
import UserLoggedTabs from "../../layout/tabs/UserLoggedTabs";
import { BrowserRouter, Route, NavLink } from "react-router-dom"
import RentACarPretraga from "../classicUser/RentACarPretraga";
import RentACarIzlistavanje from "../classicUser/RantACarIzlistavanje";
import Vozila from "../classicUser/Vozila.js"
import Filijale from "../classicUser/Filijale.js"
import FastCarReservation from "./FastCarResevation"
import HotelPretraga from "../HotelPretraga";
import LetoviPretraga from "../LetoviPretraga";
import HotelIzlistavanje from "../HoteliIzlistavanje";
import LetoviIzlistavanje from "../LetoviIzlistavanje";
import LoggedUserHotelList from "../loggedUserHotel/LoggedUserHotelList";
import { connect } from "react-redux"
import { hideDodatoUKorpu } from "../../../store/actions/PurchasesActions";
import ReactNotification from "react-notifications-component";
import "react-notifications-component/dist/theme.css";
import LoggedUserSobeList from "../loggedUserHotel/LoggedUserSobeList";
import Cenovnici from "../Cenovnici";
import DodatneUsluge from "../DodatneUsluge";
import LoggedUserReservationForm from "../loggedUserHotel/LoggedUserReservationForm";

class DashboardUserLogged extends Component {

    state = {

    }

    constructor(props) {
        super(props);
        this.dodatoUKopruNotifikacija = this.dodatoUKopruNotifikacija.bind(this);
        this.notificationDOMRef = React.createRef();
    }

    dodatoUKopruNotifikacija() {
        this.notificationDOMRef.current.addNotification({
            title: "Rezervacija",
            message: "Uspesno dodato u korpu!",
            type: "success",
            insert: "top",
            container: "top-center",
            animationIn: ["animated", "fadeIn"],
            animationOut: ["animated", "fadeOut"],
            dismiss: { duration: 2000 },
            dismissable: { click: true }
        });
    }

    render() {

        if (this.props.dodatoUKorpu) {
            this.dodatoUKopruNotifikacija();
            this.props.hideDodatoUKorpu();
        }

        return (
            <div>
                <BrowserRouter>
                    <div>
                        <div className="container center">
                            <ReactNotification ref={this.notificationDOMRef} />
                        </div>
                        <NavLink to="/fastCarReservation"><p className="blue-text darken-3">Brza rezervacija vozila</p></NavLink>

                        <div>
                            <Route path="/" component={UserLoggedTabs}></Route>
                        </div>
                        <div>


                            <Route exact path="/vozila" component={RentACarIzlistavanje}></Route>
                            <Route path="/vozila/:serviceId" render={(props) => <Vozila userId={2} ulogovanUser={true} {...props} />}></Route>
                            <Route path="/filijale/:serviceId" component={Filijale}></Route>
                            <Route path="/fastCarReservation" render={(props) => <FastCarReservation />}></Route>

                            <Route path="/smestaj" component={LoggedUserHotelList}></Route>
                            <Route path="/letovi" component={LetoviPretraga}></Route>
                            <Route path="/listaHotela/:imeAdresa/:datumOd/:datumDo/:brojSoba/:brojGostiju" component={HotelIzlistavanje}></Route>
                            <Route path="/listaLetova" component={LetoviIzlistavanje}></Route>
                            <Route path="/listaHotelaLogged" component={LoggedUserHotelList}></Route>
                            <Route path = "/sobeLogged/:hotelId" component = {LoggedUserSobeList}></Route>
                            <Route path = "/cenovnici/:hotelId" component = {Cenovnici}></Route>
                            <Route path = "/usluge/:hotelId" component = {DodatneUsluge}></Route>
                            <Route path="/rezervacijaLogged/:hotelId/:sobaId" component={LoggedUserReservationForm}></Route>

                        </div>
                    </div>

                </BrowserRouter>
            </div>
        );
    }

}


const mapStateToProps = (state) => {

    return {
        dodatoUKorpu: state.purchases.dodatoUKorpu
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        hideDodatoUKorpu: () => dispatch(hideDodatoUKorpu())
    }
}



export default connect(mapStateToProps, mapDispatchToProps)(DashboardUserLogged);
