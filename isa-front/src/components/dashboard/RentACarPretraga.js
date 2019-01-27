import React, {Component} from 'react'
import UserLoggedTabs from '../layout/UserLoggedTabs';



class RentACarPretraga extends Component {

    state = {

    }

    render() {
        return (
            <div>
                <UserLoggedTabs></UserLoggedTabs>
                <div className="container">
                    
                    <form className="white" >
                        <h2 className="red-text lighten-1 center">Pretraga vozila</h2>
                        <div className="container">

                            <div className="input-field">
                                <label htmlFor="lokacija_preuzimanja">Lokacija preuzimanja</label>
                                <input type="text" id='lokacija_preuzimanja' />
                            </div>

                            <div className="input-field">
                                <label htmlFor="lokacija_ostavljanja">Lokacija ostavljanja</label>
                                <input type="text" id='lokacija_ostavljanja' />
                            </div>

                            <div className="input-field">
                                <label htmlFor="datum_preuzimanja">Datum preuzimanja</label>
                                <input type="text" id='datum_preuzimanja' className="datepicker"/>
                            </div>     

                            <div className="input-field">
                                <label htmlFor="vreme_preuzimanja">Vreme preuzimanja</label>
                                <input type="text" id='vreme_preuzimanja' />
                            </div> 
                            

                            <div className="input-field">
                                <label htmlFor="datum_ostavljanja">Datum ostavljanja</label>
                                <input type="text" id='datum_ostavljanja' className="datepicker"/>
                            </div>

                            <div className="input-field">
                                <label htmlFor="vreme_ostavljanja">Vreme ostavljanja</label>
                                <input type="text" id='vreme_ostavljanja' />
                            </div> 
 
                            <div className="input-field">
                                <label htmlFor="broj_putnika">Broj putnika</label>
                                <input type="number" id='broj_putnika' />
                            </div> 

                            <div class="input-field col s12">
                                <select className="browser-default">
                                    <option value="" disabled selected>Tip vozila</option>
                                    <option value="1">Option 1</option>
                                    <option value="2">Option 2</option>
                                    <option value="3">Option 3</option>
                                </select>
                            </div>

                            <div className="input-field">
                                <button className="btn blue lighten-1 z-depth-0">Pretraži</button>
                             </div>
                        </div>
                    </form>
                </div>
            </div>
        )
    }
};

export default RentACarPretraga;