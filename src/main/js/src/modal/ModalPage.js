import React, { Component } from 'react';
import { MDBContainer, MDBBtn, MDBModal, MDBModalBody, MDBModalHeader, MDBModalFooter } from 'mdbreact';
import FormsPage from "../FormsPage";

class ModalPage extends Component {

    constructor(props ) {
        super(props);

    }

    state = {
        modal: false,
        title: this.props.title,
        authors: this.props.authors,
        genre: this.props.genre,
        comment: this.props.comment
    };


    toggle = () => {
        this.setState({
            modal: !this.state.modal
        });
    };

    handleChange = (e) => {
        this.setState({ title: e.currentTarget.value })
    };

    validate = () => !!this.state.title.trim();


    render() {
        return (
            <MDBContainer>
                <MDBBtn color="info" onClick={this.toggle}>Edit</MDBBtn>
                <MDBModal isOpen={this.state.modal} toggle={this.toggle}    >
                    <MDBModalHeader toggle={this.toggle}>Edit book</MDBModalHeader>
                    <MDBModalBody>
                    <FormsPage title={this.state.title}  authors = {this.state.authors} genre ={this.state.genre} comment={this.state.comment}>

                    </FormsPage>
                    </MDBModalBody>
                    <MDBModalFooter>
                        <MDBBtn color="secondary" onClick={this.toggle}>Close</MDBBtn>
                        <MDBBtn color="primary">Save changes</MDBBtn>
                    </MDBModalFooter>
                </MDBModal>
            </MDBContainer>
        );
    }
}
export default ModalPage;