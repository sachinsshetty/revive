import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import AppUserList from './AppUserList';
import AppUserEdit from "./AppUserEdit";
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
            <Route path='/api/app_users' exact={true} component={AppUserList}/>
            <Route path='/api/app_users/:id' component={AppUserEdit}/>
            <Route path='/api/configurations' exact={true} component={ConfigurationList}/>
            <Route path='/api/configurations/:id' component={ConfigurationEdit}/>
            
          </Switch>
        </Router>
    )
  }
}

export default App;
