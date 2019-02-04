import React, { Component } from "react"
import "./StarRating.css"
import { connect } from "react-redux"
import { rateCar, rateRentACarService } from "../../../store/actions/PurchasesActions"

class StarRating extends Component {


    state = {

        rentService: undefined,
        reservedCar: undefined

    }


    componentDidMount() {


    }

    HandleRating = (e) => {

        if (this.props.rentService) {
            //ovde ide user
            this.props.rateRentACarService(2, this.props.rentService.id, e.target.value);

        }
        else if (this.props.reservedCar) {

            this.props.rateCar(2, this.props.reservedCar.id, e.target.value);
        }

    }


    render() {

        var idZvezdice = "";

        if (this.props.rentService) {
            idZvezdice = this.props.rentService.id + "servis";
        }
        else if (this.props.reservedCar) {
            idZvezdice = this.props.reservedCar.id + "reservedCar";
        }


        return (

            <fieldset class="rating">
                <input onClick={this.HandleRating} type="radio" id={idZvezdice + '5'} name={idZvezdice + 'rating'} value="5" /><label className="full" for={idZvezdice + '5'} title="Odlican! - 5 zvezdica"></label>
                <input onClick={this.HandleRating} type="radio" id={idZvezdice + '4'} name={idZvezdice + 'rating'} value="4" /><label className="full" for={idZvezdice + '4'} title="Vrlo dobar - 4 zvezdica"></label>
                <input onClick={this.HandleRating} type="radio" id={idZvezdice + '3'} name={idZvezdice + 'rating'} value="3" /><label className="full" for={idZvezdice + '3'} title="Ajde da kazem dobar - 3 zvezdice"></label>
                <input onClick={this.HandleRating} type="radio" id={idZvezdice + '2'} name={idZvezdice + 'rating'} value="2" /><label className="full" for={idZvezdice + '2'} title="Onakooooo - 2 zvezdice"></label>
                <input onClick={this.HandleRating} type="radio" id={idZvezdice + '1'} name={idZvezdice + 'rating'} value="1" /><label className="full" for={idZvezdice + '1'} title="Jako lose - 1 star"></label>
            </fieldset>

        );
    }

};

const mapStateToProps = (state) => {
    return {
        rentACarRatings: state.purchases.rentACarRatings,
        carRatings: state.purchases.carRatings,
        user: state.user.user
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        rateRentACarService: (userId, idService, rating) => dispatch(rateRentACarService(userId, idService, rating)),
        rateCar: (userId, idCar, rating) => dispatch(rateCar(userId, idCar, rating))
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(StarRating);