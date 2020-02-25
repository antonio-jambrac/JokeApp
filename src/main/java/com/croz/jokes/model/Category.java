package com.croz.jokes.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank (message = "Name is mandatory")
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Joke> jokes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Joke> getJokes() {
        return jokes;
    }

    public void setJokes(List<Joke> jokes) {
        this.jokes = jokes;
    }
}
