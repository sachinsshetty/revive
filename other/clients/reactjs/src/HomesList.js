import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class HomesList extends Component {

    constructor(props) {
        super(props);
        this.state = {homes: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/api/homes')
            .then(response => response.json())
            .then(data => this.setState({homes: data}));
    }

    async remove(id) {
        await fetch(`/api/homes/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedHomes = [...this.state.homes].filter(i => i.id !== id);
            this.setState({homes: updatedHomes});
        });
    }

    render() {

  
        const {homes} = this.state;

        const homesList = homes.map(homes => {
            return <tr key={homes.id}>
                <td style={{whiteSpace: 'nowrap'}}>{homes.address}</td>
                <td>{homes.rent_price}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/api/homes/" + homes.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(homes.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
           

                    <div className="float-right">
                        <Button color="success" tag={Link} to="/api/homes/new">Add Home</Button>
                    </div>
                    <h3>Homes</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="30%">Address</th>
                            <th width="30%">Rent Price</th>
                            <th width="40%">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {homesList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}

export default HomesList;
