package org.example;

import lombok.Data;

@Data
public class Parrot {
    String name = "Antonio";

    @Override
    public String toString() {
        return "Parrot{" +
                "name='" + name + '\'' +
                '}';
    }
}
