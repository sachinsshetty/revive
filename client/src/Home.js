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
                    <Button color="link"><Link to="/app_users">Users</Link></Button>
            
                    <Button color="link"><Link to="/configurations">Configurations</Link></Button>
                </Container>
            </div>
        );
    }
}

export default Home;
