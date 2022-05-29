import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import UserList from './UserList';
import UserEdit from "./UserEdit";
import ConfigurationList from './ConfigurationList';
import ConfigurationEdit from "./ConfigurationEdit";

/*
import DeviceList from './DeviceList';
import DeviceEdit from "./DeviceEdit";
*/

class App extends Component {
  render() {
    return (
        <Router>
          <Switch>
            <Route path='/' exact={true} component={Home}/>
            <Route path='/users' exact={true} component={UserList}/>
            <Route path='/users/:id' component={UserEdit}/>
            <Route path='/configurations' exact={true} component={ConfigurationList}/>
            <Route path='/configurations/:id' component={ConfigurationEdit}/>
            
          </Switch>
        </Router>
    )
  }
}

export default App;
