import React from 'react';
import { Switch, Route } from 'react-router-dom';
import SingUp from '../pages/SingUp';

const Routes = () => (
  <Switch>
    <Route path="/" component={SingUp} />
  </Switch>
);

export default Routes;
