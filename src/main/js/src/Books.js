import React from 'react'

const Books = ({ books }) => {
    return (
        <div>
            <center><h1>Contact List</h1></center>
            {books.map((books) => (
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">{books.id}</h5>

                    </div>
                </div>
            ))}
        </div>
    )
};

export default Books