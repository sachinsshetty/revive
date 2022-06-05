import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class SetupList extends Component {

    constructor(props) {
        super(props);
        this.state = {setup: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/api/setup')
            .then(response => response.json())
            .then(data => this.setState({setup: data}));
    }

    async remove(id) {
        await fetch(`/api/setup/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedSetups = [...this.state.setup].filter(i => i.id !== id);
            this.setState({setup: updatedSetups});
        });
    }

    render() {

  
        const {setup} = this.state;

        const setupList = setup.map(setup => {
            return <tr key={setup.id}>
                <td style={{whiteSpace: 'nowrap'}}>{setup.type_name}</td>
                <td>{setup.option_value}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/api/setup/" + setup.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(setup.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
           

                    <div className="float-right">
                        <Button color="success" tag={Link} to="/api/setup/new">Add Setup</Button>
                    </div>
                    <h3>Setups</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="30%">Type</th>
                            <th width="30%">Option</th>
                            <th width="40%">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {setupList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}

export default SetupList;
