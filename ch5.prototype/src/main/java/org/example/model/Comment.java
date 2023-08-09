package org.example.model;

import lombok.Data;

@Data
public class Comment {
     String author;
     String text;

    public Comment(String author, String text) {
        this.author = author;
        this.text = text;
    }
}
