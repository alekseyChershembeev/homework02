import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import ModalPage from "./modal/ModalPage";

const useStyles = makeStyles(theme => ({
    root: {
        width: '100%',
        marginTop: theme.spacing(3),
        overflowX: 'auto',
    },
    table: {
        minWidth: 650,
    },
}));



export default function SimpleTable(props) {
    const books = props.books;

    const classes = useStyles();

    return (
        <Paper className={classes.root}>
            <Table className={classes.table}>
                <TableHead>
                    <TableRow>
                        <TableCell align="left">Title</TableCell>
                        <TableCell align="left">Author</TableCell>
                        <TableCell align="left">Genre</TableCell>
                        <TableCell align="left">Comments</TableCell>
                        <TableCell align="left">Edit</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {books.map(row => (
                        <TableRow key={row.id}>
                            <TableCell align="left">{row.title}</TableCell>
                            <TableCell align="left">{row.authors}</TableCell>
                            <TableCell align="left">{row.genre}</TableCell>
                            <TableCell acomponent="th" scope="row">{row.comments}</TableCell>
                            <ModalPage title={row.title} authors ={row.authors} genre ={row.genre} comments={row.comments}>

                            </ModalPage>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </Paper>
    );
}