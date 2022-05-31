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
                <td style={{whiteSpace: 'nowrap'}}>{setup.type_name}</td>
                <td>{setup.first_name}</td>
                        
            </tr>
        });
    
        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                <br></br>    
                
                <center> <h5>Initializor library for Web App with Micro-Services</h5>
                </center>
                
                <br></br>
                <br></br>


                
                <FormGroup>
                        <Button color="primary" type="submit">Configure</Button>{' '}
                        <Button color="secondary" tag={Link} to="/">Cancel</Button>
                    </FormGroup>
                </Container>

                <br></br>
                <br></br>
                <center><Button color="link"><Link to="/api/setup">Available Configs</Link></Button> </center>

            </div>
        );

      
    }


}

export default Home;
