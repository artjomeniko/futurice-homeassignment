package com.futurice.homeassignment.controller;

import com.futurice.homeassignment.repository.GithubApiRepository;
import com.futurice.homeassignment.service.GithubApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class GithubApiWebController {

    @Autowired
    private GithubApiService githubApiService;

    @GetMapping("/repos/{owner}/{repo}")
    public ResponseEntity<GithubApiRepository> getRepository(@PathVariable String owner, @PathVariable String repo) {
        GithubApiRepository repository = githubApiService.getRepository(owner, repo);
        return new ResponseEntity<>(repository, HttpStatus.OK);
    }

    @GetMapping("/repos/{owner}")
    public ResponseEntity<List<GithubApiRepository>> getRepositoriesByOwner(@PathVariable String owner) {
        List<GithubApiRepository> repositories = githubApiService.getRepositoriesByOwner(owner);
        return new ResponseEntity<>(repositories, HttpStatus.OK);
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        String ownerLogin = "kirtankoro";
        // Add model attributes
        List<GithubApiRepository> repositories = githubApiService.getRepositoriesByOwner(ownerLogin);
        modelAndView.addObject("login", ownerLogin);
        modelAndView.addObject("repositories", repositories);

        return modelAndView;
    }
}