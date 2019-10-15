import React, {Component} from 'react'
import {Formik, Form, Field, ErrorMessage} from 'formik';
import LibraryDataService from "../service/LibraryDataService";


class LibraryComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            id: this.props.match.params.id,
            title: '',
            authors: '',
            genre: '',
            comments: ''
        };
        this.onSubmit = this.onSubmit.bind(this);
        this.validate = this.validate.bind(this);

    }

    componentDidMount() {

        console.log(this.state.id);

        // eslint-disable-next-line
        if (this.state.id == -1) {
            return
        }

        LibraryDataService.retrieveBook(this.state.id)
            .then(response => this.setState({
                title: response.data.title,
                authors: response.data.authors,
                genre: response.data.genre,
                comments: response.data.comments,
            }))
    }

    onSubmit(values) {

        let book = {
            id: this.state.id,
            title: values.title,
            authors: values.authors,
            genre: values.genre,
            comments: values.comments,
        };

        if (this.state.id === -1) {
            LibraryDataService.createBook(book)
                .then(() => this.props.history.push('/books'))
        } else {
            LibraryDataService.updateBook(this.state.id, book)
                .then(() => this.props.history.push('/books'))
        }

        console.log(values);
    }


    render() {

        let {id, title, authors, genre, comments} = this.state;

        return (
            <div>
                <h3>Book</h3>
                <div className="container">
                    <Formik
                        initialValues={{id, title, authors, genre, comments}}
                        onSubmit={this.onSubmit}
                        validateOnChange={false}
                        validateOnBlur={false}
                        validate={this.validate}
                        enableReinitialize={true}
                    >
                        {
                            (props) => (
                                <Form>
                                    <ErrorMessage name="title" component="div"
                                                  className="alert alert-warning"/>
                                    <fieldset className="form-group">
                                        <label>Id</label>
                                        <Field className="form-control" type="text" name="id" disabled/>
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>title</label>
                                        <Field className="form-control" type="text" name="title"/>
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>authors</label>
                                        <Field className="form-control" type="text" name="authors"/>
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>genre</label>
                                        <Field className="form-control" type="text" name="genre"/>
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>comments</label>
                                        <Field className="form-control" type="text" name="comments"/>
                                    </fieldset>
                                    <button className="btn btn-success" type="submit">Save</button>
                                </Form>
                            )
                        }
                    </Formik>

                </div>
            </div>
        )
    }

    validate(values) {
        let errors = {};

        if (!values.title) {
            errors.title = 'Enter a title'
        } else if (values.title.length < 5) {
            errors.title = 'Enter atleast 5 Characters in title'
        }

        return errors
    }
}


export default LibraryComponent