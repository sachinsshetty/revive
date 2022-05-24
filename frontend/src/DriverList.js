import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class DriverList extends Component {

    constructor(props) {
        super(props);
        this.state = {drivers: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/drivers')
            .then(response => response.json())
            .then(data => this.setState({drivers: data}));
    }

    async remove(id) {
        await fetch(`/drivers/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedDrivers = [...this.state.drivers].filter(i => i.id !== id);
            this.setState({drivers: updatedDrivers});
        });
    }

    render() {
        const {drivers} = this.state;

        const driverList = drivers.map(driver => {
            return <tr key={driver.id}>
                <td style={{whiteSpace: 'nowrap'}}>{driver.user_name}</td>
                <td>{driver.first_name}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/drivers/" + driver.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(driver.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/drivers/new">Add Drivers</Button>
                    </div>
                    <h3>Drivers</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="30%">User Name</th>
                            <th width="30%">First Name</th>
                            <th width="40%">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {driverList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}

export default DriverList;
