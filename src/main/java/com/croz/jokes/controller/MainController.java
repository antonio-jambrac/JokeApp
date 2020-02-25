package com.croz.jokes.controller;

import com.croz.jokes.model.Joke;
import com.croz.jokes.repository.CategoryRepository;
import com.croz.jokes.repository.JokeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class MainController {

    private JokeRepository jokeRepository;
    private CategoryRepository categoryRepository;

    public MainController (JokeRepository jokeRepository, CategoryRepository categoryRepository) {
        this.jokeRepository = jokeRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/")
    public String showJokes (Model model) {
        model.addAttribute("joke", jokeRepository.findAll());
        return "index";
    }

    @GetMapping("new")
    public String newJoke (Model model) {
        model.addAttribute("joke", new Joke());
        model.addAttribute("categories", categoryRepository.findAll());
        return "newJoke";
    }

    @PostMapping("addJoke")
    public String addJoke (@Valid Joke joke, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("categories", categoryRepository.findAll());
            return "newJoke";
        }
        jokeRepository.save(joke);
        return "redirect:/";
    }

    @PostMapping("addLike/{id}")
    public String addLike (@PathVariable("id") int id) {
        Optional<Joke> joke = jokeRepository.findById(id);
        if(joke.isPresent()) {
            Joke newJoke = joke.get();
            newJoke.setLikes(newJoke.getLikes() + 1);
            jokeRepository.save(newJoke);
        }
        return "redirect:/";
    }

    @PostMapping("addDislike/{id}")
    public String addDislike (@PathVariable("id") int id) {
        Optional<Joke> joke = jokeRepository.findById(id);
        if(joke.isPresent()) {
            Joke newJoke=joke.get();
            newJoke.setDislikes(newJoke.getDislikes() + 1);
            jokeRepository.save(newJoke);
        }
        return "redirect:/";
    }
}
