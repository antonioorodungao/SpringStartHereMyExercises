package org.example.model;

import lombok.Data;
import org.springframework.context.annotation.Bean;

@Data
public class Comment {
     String author;
     String text;

    public Comment(String author, String text) {
        this.author = author;
        this.text = text;
    }
}
