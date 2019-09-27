package com.spring.homework2.spring_course2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Chershembeev_AE
 * Date: 30.08.2019
 * Time: 14:49.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "comments")
public class Comment {

    @Id
    private String id;
    private String comment;

    public Comment(String comment) {
        this.comment = comment;
    }
}
