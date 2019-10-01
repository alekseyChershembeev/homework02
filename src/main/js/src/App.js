
import React, {Component} from 'react';
import SimpleTable from "./SimpleTable";


class App extends Component {

  state = {
    books: []
  };


  componentDidMount() {
    fetch('http://localhost:8080/books')
        .then(res => res.json())
        .then((data) => {
          this.setState({ books: data })
        })
        .catch(console.log)
  }

  render() {
    return (
        <React.Fragment>
            <SimpleTable books ={this.state.books}> </SimpleTable>
        </React.Fragment>
    )
  }

}

export default App;