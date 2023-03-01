package com.futurice.homeassignment.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GithubApiOwner {

    @JsonProperty("login")
    private String login;

    @JsonProperty("html_url")
    private String htmlUrl;
}