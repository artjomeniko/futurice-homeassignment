package com.futurice.homeassignment.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GithubApiRepository {
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("html_url")
    private String htmlUrl;

    @JsonProperty("description")
    private String description;

    @JsonProperty("owner")
    private GithubApiOwner owner;
}