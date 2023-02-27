package com.futurice.homeassignment.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GithubApiOwner {

    @JsonProperty("login")
    private String login;

    @JsonProperty("html_url")
    private String htmlUrl;

    public GithubApiOwner() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }
}