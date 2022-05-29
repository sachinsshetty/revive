import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

class ConfigurationEdit extends Component {

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
            const configuration = await (await fetch(`/configurations/${this.props.match.params.id}`)).json();
            this.setState({item: configuration});
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

    await fetch('/configurations' + (item.id ? '/' + item.id : ''), {
        method: (item.id) ? 'PUT' : 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(item),
    });
    this.props.history.push('/configurations');
}

    render() {
        const {item} = this.state;
        const title = <h2>{item.id ? 'Edit Configuration' : 'Add Configuration'}</h2>;

        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="key">Key</Label>
                        <Input type="text" name="key" id="key" value={item.key || ''}
                               onChange={this.handleChange} autoComplete="key"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="value">Value</Label>
                        <Input type="text" name="value" id="value" value={item.value || ''}
                               onChange={this.handleChange} autoComplete="value"/>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Save</Button>{' '}
                        <Button color="secondary" tag={Link} to="/configurations">Cancel</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
}

export default withRouter(ConfigurationEdit);
