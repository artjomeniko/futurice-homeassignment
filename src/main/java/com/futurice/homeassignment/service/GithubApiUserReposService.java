package com.futurice.homeassignment.service;

import com.futurice.homeassignment.entities.GithubApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GithubApiUserReposService {

    @Autowired
    private RestTemplate restTemplate;

    public GithubApiRepository getRepository(String owner, String repo) {
        String url = "https://api.github.com/repos/" + owner + "/" + repo;
        return restTemplate.getForObject(url, GithubApiRepository.class);
    }

    public List<GithubApiRepository> getRepositoriesByOwner(String owner) {
        String url = "https://api.github.com/users/" + owner + "/repos";
        ResponseEntity<GithubApiRepository[]> response = restTemplate.getForEntity(url, GithubApiRepository[].class);
        GithubApiRepository[] repos = response.getBody();
        return Optional.ofNullable(repos) // This Streams construction returns an empty list if repos == null, thus preventing a possible NPE.
                .stream()
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}