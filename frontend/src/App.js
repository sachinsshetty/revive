import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import DriverList from './DriverList';
import DriverEdit from "./DriverEdit";

class App extends Component {
  render() {
    return (
        <Router>
          <Switch>
            <Route path='/' exact={true} component={Home}/>
            <Route path='/drivers' exact={true} component={DriverList}/>
            <Route path='/drivers/:id' component={DriverEdit}/>
          </Switch>
        </Router>
    )
  }
}

export default App;
