import React from "react";
import {MDBCol, MDBRow} from "mdbreact";

class FormsPage extends React.Component {


    constructor(props) {
        super(props);
    }

    state = {
        title: this.props.title,
        authors: this.props.authors,
        genre: this.props.genre,
        comments: this.props.comments,
    };

    submitHandler = event => {
        event.preventDefault();
        event.target.className += " was-validated";
    };

    changeHandler = event => {
        this.setState({ [event.target.name]: event.target.value });
    };

    render() {
        const {changeHandler: changeHandler1, state: state1} = this;
        function getTitle() {


            return <MDBRow>
                <MDBCol md="12" className="mb-3">
                    <label
                        htmlFor="defaultFormRegisterPasswordEx1"
                        className="grey-text"
                    >
                        Title
                    </label>
                    <input
                        value={this.state.title}
                        onChange={changeHandler1}
                        type="text"
                        id="defaultFormRegisterPasswordEx1"
                        className="form-control"
                        name="title"
                        placeholder="Title"
                        required
                    />
                    <div className="invalid-feedback">
                        Please provide a valid title.
                    </div>
                    <div className="valid-feedback">Looks good!</div>
                </MDBCol>

            </MDBRow>;
        }
        function getAuthor() {

            return <MDBRow>
                <MDBCol md="12" className="mb-3">
                    <label
                        htmlFor="defaultFormRegisterPasswordEx1"
                        className="grey-text"
                    >
                        Author
                    </label>
                    <input
                        value={this.state.authors}
                        onChange={this.changeHandler}
                        type="text"
                        id="defaultFormRegisterPasswordEx1"
                        className="form-control"
                        name="author"
                        placeholder="Author"
                        required
                    />
                    <div className="invalid-feedback">
                        Please provide a valid author.
                    </div>
                    <div className="valid-feedback">Looks good!</div>
                </MDBCol>

            </MDBRow>;
        }
        function getGenre() {

            return <MDBRow>
                <MDBCol md="12" className="mb-3">
                    <label
                        htmlFor="defaultFormRegisterPasswordEx1"
                        className="grey-text"
                    >
                        Genre
                    </label>
                    <input
                        value={this.state.genre}
                        onChange={this.changeHandler}
                        type="text"
                        id="defaultFormRegisterPasswordEx1"
                        className="form-control"
                        name="genre"
                        placeholder="Genre"
                        required
                    />
                    <div className="invalid-feedback">
                        Please provide a valid genre.
                    </div>
                    <div className="valid-feedback">Looks good!</div>
                </MDBCol>

            </MDBRow>;
        }
        function getComments() {

            return <MDBRow>
                <MDBCol md="12" className="mb-3">
                    <label
                        htmlFor="defaultFormRegisterPasswordEx1"
                        className="grey-text"
                    >
                        Comments
                    </label>
                    <input
                        value={this.state.comments}
                        onChange={this.changeHandler}
                        type="text"
                        id="defaultFormRegisterPasswordEx1"
                        className="form-control"
                        name="comments"
                        placeholder="Comments"
                        required
                    />
                    <div className="invalid-feedback">
                        Please provide a valid comments.
                    </div>
                    <div className="valid-feedback">Looks good!</div>
                </MDBCol>

            </MDBRow>;
        }



        return (

            <div>
                <form
                    className="needs-validation"
                    onSubmit={this.submitHandler}
                    noValidate
                >

                    {getTitle.call(this)}
                    {getAuthor.call(this)}
                    {getGenre.call(this)}
                    {getComments.call(this)}


                </form>
            </div>
        );
    }
}

export default FormsPage;