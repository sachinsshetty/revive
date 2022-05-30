import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class ConfigurationList extends Component {

    constructor(props) {
        super(props);
        this.state = {configurations: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/api/configurations')
            .then(response => response.json())
            .then(data => this.setState({configurations: data}));
    }

    async remove(id) {
        await fetch(`/api/configurations/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedConfigurations = [...this.state.configurations].filter(i => i.id !== id);
            this.setState({configurations: updatedConfigurations});
        });
    }

    render() {
        const {configurations} = this.state;

        const configurationList = configurations.map(configuration => {
            return <tr key={configuration.id}>
                <td style={{whiteSpace: 'nowrap'}}>{configuration.key}</td>
                <td>{configuration.value}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/api/configurations/" + configuration.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(configuration.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/api/configurations/new">Add Configurations</Button>
                    </div>
                    <h3>Configurations</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="30%">Key</th>
                            <th width="30%">Value</th>
                            <th width="40%">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {configurationList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}

export default ConfigurationList;
