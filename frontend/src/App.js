import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import DriverList from './DriverList';
import DriverEdit from "./DriverEdit";
import ConfigurationList from './ConfigurationList';
import ConfigurationEdit from "./ConfigurationEdit";

/*
import StallList from './StallList';
import StallEdit from "./StallEdit";
import VehicleList from './VehicleList';
import VehicleEdit from "./VehicleEdit";
import PaymentList from './PaymentList';
import PaymentEdit from "./PaymentEdit";
*/
class App extends Component {
  render() {
    return (
        <Router>
          <Switch>
            <Route path='/' exact={true} component={Home}/>
            <Route path='/drivers' exact={true} component={DriverList}/>
            <Route path='/drivers/:id' component={DriverEdit}/>
            <Route path='/configurations' exact={true} component={ConfigurationList}/>
            <Route path='/configurations/:id' component={ConfigurationEdit}/>
            
          </Switch>
        </Router>
    )
  }
}

export default App;
