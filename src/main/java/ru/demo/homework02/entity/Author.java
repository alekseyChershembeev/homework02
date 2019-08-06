package ru.demo.homework02.entity;

import java.util.*;
import lombok.Data;

/**
 * Created by Chershembeev_AE
 * Date: 06.08.2019
 * Time: 11:00.
 */
@Data
public class Author {

    private Long id;
    private List<Book> books;
    private String name;
}
