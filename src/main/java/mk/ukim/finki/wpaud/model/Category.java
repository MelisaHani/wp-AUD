package mk.ukim.finki.wpaud.model;

import lombok.Data;

@Data
public class Category {

    Long id;
    private String name;
    private String description;

    public Category(String name, String description) {
        this.id = (long) (Math.random() * 1000);
        this.name = name;
        this.description = description;
    }
}
