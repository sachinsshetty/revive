import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

class VehicleEdit extends Component {

    emptyItem = {
        name: '',
        email: ''
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        if (this.props.match.params.id !== 'new') {
            const vehicle = await (await fetch(`/vehicles/${this.props.match.params.id}`)).json();
            this.setState({item: vehicle});
        }
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.item};
        item[name] = value;
        this.setState({item});
    }

async handleSubmit(event) {
    event.preventDefault();
    const {item} = this.state;

    await fetch('/vehicles' + (item.id ? '/' + item.id : ''), {
        method: (item.id) ? 'PUT' : 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(item),
    });
    this.props.history.push('/vehicles');
}

    render() {
        const {item} = this.state;
        const title = <h2>{item.id ? 'Edit Vehicle' : 'Add Vehicle'}</h2>;

        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="username">User Name</Label>
                        <Input type="text" name="user_name" id="user_name" value={item.user_name || ''}
                               onChange={this.handleChange} autoComplete="user_name"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="reg_no">Reg. No.</Label>
                        <Input type="text" name="reg_no" id="reg_no" value={item.reg_no || ''}
                               onChange={this.handleChange} autoComplete="reg_no"/>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Save</Button>{' '}
                        <Button color="secondary" tag={Link} to="/vehicles">Cancel</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
}

export default withRouter(VehicleEdit);
