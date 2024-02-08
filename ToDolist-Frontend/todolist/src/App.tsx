import { Route, Switch, useHistory } from "react-router-dom";
import Header from "./Component/Header.tsx";
import ListToDo from "./Component/ListToDo.tsx";
import ToDo from "./Component/ToDo.tsx";
import Footer from "./Component/Footer.tsx";
import { useState } from "react";
import React from "react";
import { Button } from "react-bootstrap";
function App() {
  // const [showAddForm, setShowAddForm] = useState(false);
  // const history = useHistory();

  // const handleAddFormClick = () => {
  //   setShowAddForm(true);
  //   history.replace("/todo-form");
  // };
  return (
    <>
      <Header />

      {/* {showAddForm ? (
        <ToDo />
      ) : (
        <>
          <Button onClick={handleAddFormClick}>Add Todo</Button>
          <ListToDo />
        </>
      )} */}

      <Switch>
        <Route exact path="/add-todo">
          <ToDo />
        </Route>
        <Route exact path="/list-todo">
          <ListToDo />
        </Route>
        <Route exact path="/edit-todo/:id">
          <ToDo />
        </Route>
        <Route exact path="/updated-todo">
          <ListToDo />
        </Route>
      </Switch>
      <Footer />
    </>
  );
}

export default App;