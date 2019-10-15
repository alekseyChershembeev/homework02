package com.spring.homework2.spring_course2.rest;

import com.spring.homework2.spring_course2.entity.Book;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Chershembeev_AE
 * Date: 17.09.2019
 * Time: 16:51.
 */

@Data
@NoArgsConstructor
public class BookDTO {

    private String id;
    private String authors;
    private String title;
    private String genre;
    private List<CommentDTO> comments;


}
