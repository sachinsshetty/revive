import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class AppUserList extends Component {

    constructor(props) {
        super(props);
        this.state = {app_users: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/app_users')
            .then(response => response.json())
            .then(data => this.setState({app_users: data}));
    }

    async remove(id) {
        await fetch(`/app_users/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedAppUsers = [...this.state.app_users].filter(i => i.id !== id);
            this.setState({app_users: updatedAppUsers});
        });
    }

    render() {
        const {app_users} = this.state;

        const app_userList = app_users.map(app_user => {
            return <tr key={app_user.id}>
                <td style={{whiteSpace: 'nowrap'}}>{app_user.user_name}</td>
                <td>{app_user.first_name}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/app_users/" + app_user.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(app_user.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/app_users/new">Add AppUsers</Button>
                    </div>
                    <h3>AppUsers</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="30%">User Name</th>
                            <th width="30%">First Name</th>
                            <th width="40%">Actions</th>
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

export default AppUserList;
