package org.example.services;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Comment {
    String author;
    String text;
}
