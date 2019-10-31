import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import ListLibraryComponent from "./components/ListLibraryComponent";
import LibraryComponent from "./components/LibraryComponent";
import ModalPage from "./components/modal/ModaPage";



class LibraryApp extends Component {
    render() {
        return (<>
                <Router>
                    <>
                        <h1>Library Application</h1>
                        <Switch>
                            <Route path="/" exact component={ListLibraryComponent} />
                            <Route path="/books" exact component={ListLibraryComponent} />
                            <Route path="/books/:id" component={LibraryComponent} />
                            <Route path="/comments/:id" component={ModalPage} />
                        </Switch>
                    </>
                </Router>
            </>
        )
    }
}

export default LibraryApp