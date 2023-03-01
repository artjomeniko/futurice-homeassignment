package com.futurice.homeassignment.controller;

import com.futurice.homeassignment.entities.GithubApiRepository;
import com.futurice.homeassignment.service.GithubApiUserReposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class GithubApiUserReposController {

    @Autowired
    private GithubApiUserReposService githubApiUserReposService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/repos")
    public String repos(@RequestParam("owner") String owner, Model model) {
        List<GithubApiRepository> repos = githubApiUserReposService.getRepositoriesByOwner(owner) != null
                ? githubApiUserReposService.getRepositoriesByOwner(owner)
                : List.of();
        model.addAttribute("owner", owner);
        model.addAttribute("repos", repos);
        return "repos";
    }

    @GetMapping("/repo")
    public String repo(@RequestParam("owner") String owner, @RequestParam("repo") String repo, Model model) {
        GithubApiRepository repository = githubApiUserReposService.getRepository(owner, repo);
        model.addAttribute("owner", repository.getOwner() != null && repository.getOwner().getLogin() != null
                ? repository.getOwner().getLogin()
                : owner);
        model.addAttribute("repo", repository);
        return "repo";
    }
}