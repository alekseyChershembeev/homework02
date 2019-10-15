import React, {Component} from 'react';
import LibraryDataService from "../service/LibraryDataService";

class ListLibraryComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {
            books: [],
            message: null
        };
        this.refreshBooks = this.refreshBooks.bind(this);
        this.deleteBookClicked = this.deleteBookClicked(this);
        this.updateBookClicked = this.updateBookClicked.bind(this);
        this.addBookClicked = this.addBookClicked.bind(this);

    }

    componentDidMount() {
        this.refreshBooks();
    }

    refreshBooks() {
        LibraryDataService.retrieveAllBooks()//HARDCODED
            .then(
                response => {
                    console.log(response);
                    this.setState({books: response.data})
                }
            )
    }

    deleteBookClicked(id) {
        LibraryDataService.deleteBook( id)
            .then(
                response => {
                    this.setState({message: `Delete of book ${id} Successful`})
                    this.refreshBooks()
                }
            );
    }

    updateBookClicked(id) {
        console.log('update ' + id)
        this.props.history.push(`/books/${id}`)
    }

    addBookClicked() {
        this.props.history.push(`/books/-1`)
    }






    render() {
        return (
            <div className="container">
                <h3>All Books</h3>
                {this.state.message && <div class="alert alert-success">{this.state.message}</div>}
                <div className="container">
                    <table className="table">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Title</th>
                            <th>Author</th>
                            <th>Genre</th>
                            <th>Comments</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        </thead>
                        <tbody>{
                            this.state.books.map(
                                book =>
                                    <tr key={book.id}>
                                        <td>{book.id}</td>
                                        <td>{book.title}</td>
                                        <td>{book.authors}</td>
                                        <td>{book.genre}</td>
                                        <td>{book.comment}</td>
                                        <td><button className="btn btn-warning" onClick={() => this.updateBookClicked(book.id)}>Edit</button></td>
                                        <td><button className="btn btn-warning" onClick={() => this.deleteBookClicked(book.id)}>Delete</button></td>
                                    </tr>
                            )
                        }
                        <div className="row">
                            <button className="btn btn-success" onClick={this.addBookClicked}>Add</button>
                        </div>
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}

export default ListLibraryComponent