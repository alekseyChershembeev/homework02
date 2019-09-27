
import React, {Component} from 'react';
import SimpleTable from "./SimpleTable";
import FormsPage from "./FormsPage";
// import FormsPage from "./FormsPage";

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
            <div>
                <FormsPage>

                </FormsPage>
            </div>

        </React.Fragment>
    )
  }

}

export default App;