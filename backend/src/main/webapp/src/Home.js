import React, { Component } from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';

class Home extends Component {
    render() {
        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <Button color="link"><Link to="/drivers">Drivers</Link></Button>
                    <Button color="link"><Link to="/vehicles">Vehicles</Link></Button>
                    <Button color="link"><Link to="/payments">Payments</Link></Button>
                    <Button color="link"><Link to="/stalls">Stalls</Link></Button>
                    <Button color="link"><Link to="/configurations">Configurations</Link></Button>
                </Container>
            </div>
        );
    }
}

export default Home;
