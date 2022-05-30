import React, { Component } from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import { Link } from 'react-router-dom';

class Home extends Component {

    constructor(props) {
        super(props);
        this.state = {app_users: []};
        
    }

    componentDidMount() {
        fetch('/api/app_users')
            .then(response => response.json())
            .then(data => this.setState({app_users: data}));
    }


    render() {

        const {app_users} = this.state;

        const app_userList = app_users.map(app_user => {
            return <tr key={app_user.id}>
                <td style={{whiteSpace: 'nowrap'}}>{app_user.user_name}</td>
                <td>{app_user.first_name}</td>
                <td>{app_user.last_name}</td>
                <td>{app_user.status}</td>                            
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <Button color="link"><Link to="/api/app_users">Users</Link></Button>
            
                    <Button color="link"><Link to="/api/configurations">Configurations</Link></Button>


                    <h5>AppUsers</h5>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="30%">User Name</th>
                            <th width="30%">First Name</th>
                            <th width="30%">Last Name</th>
                            <th width="30%">Status</th>
                        </tr>
                        </thead>
                        <tbody>
                        {app_userList}
                        </tbody>
                    </Table>
                </Container>

            </div>
        );

      
    }


}

export default Home;
