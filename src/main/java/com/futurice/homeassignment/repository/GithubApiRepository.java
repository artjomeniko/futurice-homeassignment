package com.futurice.homeassignment.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    public GithubApiRepository() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GithubApiOwner getOwner() {
        return owner;
    }

    public void setOwner(GithubApiOwner owner) {
        this.owner = owner;
    }
}