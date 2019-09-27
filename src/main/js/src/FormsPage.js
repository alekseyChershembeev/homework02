import React from "react";
import {MDBBtn, MDBCol, MDBRow} from "mdbreact";

class FormsPage extends React.Component {
    state = {
        title: "TitleTest",
        author: "AuthorTest",
        genre: "GenreTest",
        comments: "CommentsTest",
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
                        value={state1.title}
                        onChange={changeHandler1}
                        type="text"
                        id="defaultFormRegisterPasswordEx1"
                        className="form-control"
                        name="title"
                        placeholder="Comments"
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
                        value={this.state.author}
                        onChange={this.changeHandler}
                        type="text"
                        id="defaultFormRegisterPasswordEx1"
                        className="form-control"
                        name="author"
                        placeholder="Comments"
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
                        placeholder="Comments"
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
                    {getGenre.call(this)}
                    {getAuthor.call(this)}
                    {getComments.call(this)}

                    <MDBBtn color="primary" type="submit">
                        Apply
                    </MDBBtn>
                </form>
            </div>
        );
    }
}

export default FormsPage;