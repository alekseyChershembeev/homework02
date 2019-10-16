package com.spring.homework2.spring_course2.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Chershembeev_AE
 * Date: 17.09.2019
 * Time: 16:51.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private String id;
    private String authors;
    private String title;
    private String genre;
//    private String comments;


}
