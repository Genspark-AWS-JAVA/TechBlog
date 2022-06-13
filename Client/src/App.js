import React from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Login from "./Components/Login";
import Navbar from "./Components/Nav";
import Posts from "./Components/Posts";
import SinglePost from "./Components/SinglePost";

const App = () => {
  return (
    <Router>
      <div>
        <Navbar />
        <Switch>
          <Route exact path={"/login"} component={Login} />
          <Route exact path={"/"} component={Posts}/>
          <Route exact path={"/_id"} component={SinglePost} />
        </Switch>
      </div>
    </Router>
  );
};

export default App;
