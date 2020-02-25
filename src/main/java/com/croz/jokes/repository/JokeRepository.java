package com.croz.jokes.repository;

import com.croz.jokes.model.Joke;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JokeRepository extends CrudRepository<Joke, Integer> {
}
