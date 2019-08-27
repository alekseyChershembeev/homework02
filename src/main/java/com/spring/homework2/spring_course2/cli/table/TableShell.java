package com.spring.homework2.spring_course2.cli.table;

import com.spring.homework2.spring_course2.entity.Book;
import java.util.List;
import org.springframework.shell.table.AutoSizeConstraints;
import org.springframework.shell.table.SimpleHorizontalAligner;
import org.springframework.shell.table.TableBuilder;
import org.springframework.shell.table.TableModel;
import org.springframework.shell.table.TableModelBuilder;

import static org.springframework.shell.table.CellMatchers.table;

/**
 * Created by Chershembeev_AE
 * Date: 20.08.2019
 * Time: 16:43.
 */
public class TableShell {

    /**
     * Gets table from list.
     *
     * @param books the books
     * @return the table from list
     */
    //тесты
    public String getTableFromList(List<Book> books) {
        TableModelBuilder<String> modelBuilder = new TableModelBuilder<>();
        modelBuilder.addRow()
                .addValue("Book id")
                .addValue("Author(s)")
                .addValue("Title")
                .addValue("Genre");

        books.forEach(book -> modelBuilder.addRow()
                .addValue(String.valueOf(book.getBookId()))
                .addValue(book.getBookAuthor().getAuthorName())
                .addValue(book.getBookAuthor().getAuthorLastName())
                .addValue(book.getBookName() + " ")
                .addValue(book.getBookGenre().getGenreName()));
        TableModel model = modelBuilder.build();

        return new TableBuilder(model)
                .on(table())
                .addSizer(new AutoSizeConstraints())
                .addAligner(SimpleHorizontalAligner.left)
                .build()
                .render(400);

    }
}
