import React, { Component } from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import { Button, ButtonGroup, FormGroup, Form,Container, Table ,Input, Label} from 'reactstrap';
import { Link } from 'react-router-dom';

class Home extends Component {

    constructor(props) {
        super(props);
        this.state = {setup: []};
        
    }

    componentDidMount() {
        fetch('/api/setup')
            .then(response => response.json())
            .then(data => this.setState({setup: data}));
    }


    render() {

        const {setup} = this.state;

        const setupList = setup.map(setup => {
            return <tr key={setup.id}>
                <td style={{whiteSpace: 'nowrap'}}>{setup.name}</td>
                <td>{setup.option_value}</td>
                        
            </tr>
        });
    
        return (
            <div>
                <AppNavbar/>

                <br></br>    
                
                <center> <h5>Template library for Web App with Micro-Services</h5>
                </center>

                <br></br>
                <br></br>
                <center><Button color="link"><Link to="/api/setup">Available Configs</Link></Button> </center>


                <br></br>
                <br></br>
                <center><Button color="link"><Link to="/api/homes">Available Homes</Link></Button> </center>

            </div>
        );

      
    }


}

export default Home;
