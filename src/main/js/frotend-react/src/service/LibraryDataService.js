import axios from 'axios'

const LIBRARY_API_URL = 'http://localhost:8080';

class LibraryDataService {

    retrieveAllBooks() {
        return axios.get(`${LIBRARY_API_URL}/books`);
    }

    deleteBook(id) {
        //console.log('executed service')
        return axios.delete(`${LIBRARY_API_URL}/books/${id}`);
    }

    retrieveBook(id) {
        return axios.get(`${LIBRARY_API_URL}/books/${id}`);
    }

    updateBook(id, book) {
        return axios.put(`${LIBRARY_API_URL}/books/${id}`, book);
    }

    updateCommentsClicked(id, book){
        return axios.put(`${LIBRARY_API_URL}/comments/${id}`, book);
    }

    createBook(book) {
        return axios.post(`${LIBRARY_API_URL}/books/`, book);
    }

}

export default new LibraryDataService()