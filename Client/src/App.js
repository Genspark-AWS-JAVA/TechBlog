import React from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Login from "./Components/Login";
import Navbar from "./Components/Nav";
import Posts from "./Components/Posts";
import SinglePost from "./Components/SinglePost";
import CreatePost from "./Components/CreatePost";
import SearchResult from "./Components/SearchResult";
import Footer from './Components/Footer';

const App = () => {
  return (
    <Router>
      <div>
        <Navbar />
        <Switch>
          <Route exact path={"/login"} component={Login} />
          <Route exact path={"/"} component={Posts} />
          <Route exact path={"/articles/:_id"} component={SinglePost} />
          <Route exact path={"/new"} component={CreatePost} />
          <Route exact path={"/search"} component={SearchResult} />
        </Switch>
        <br />
        <br />
        <Footer />
      </div>
    </Router>
  );
};

export default App;
