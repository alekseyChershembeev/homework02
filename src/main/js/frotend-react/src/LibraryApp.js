import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import ListLibraryComponent from "./components/ListLibraryComponent";
import LibraryComponent from "./components/LibraryComponent";



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

                        </Switch>
                    </>
                </Router>
            </>
        )
    }
}

export default LibraryApp