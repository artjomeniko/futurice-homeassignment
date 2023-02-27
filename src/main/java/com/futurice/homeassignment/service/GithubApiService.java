package com.futurice.homeassignment.service;

import com.futurice.homeassignment.repository.GithubApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class GithubApiService {

    @Autowired

    private RestTemplate restTemplate;

    public GithubApiRepository getRepository(String owner, String repo) {
        String url = "https://api.github.com/repos/" + owner + "/" + repo;
        return restTemplate.getForObject(url, GithubApiRepository.class);
    }

    public List<GithubApiRepository> getRepositoriesByOwner(String owner) {
        String url = "https://api.github.com/users/" + owner + "/repos";
        ResponseEntity<GithubApiRepository[]> response = restTemplate.getForEntity(url, GithubApiRepository[].class);
        GithubApiRepository[] repositories = response.getBody();
        return Arrays.asList(repositories);
    }
}

// Add some JavaScript interaction to enter login..

