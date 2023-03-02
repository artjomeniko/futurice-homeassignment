package com.futurice.homeassignment;

import com.futurice.homeassignment.controller.GithubApiUserReposController;
import com.futurice.homeassignment.entities.GithubApiOwner;
import com.futurice.homeassignment.entities.GithubApiRepository;
import com.futurice.homeassignment.service.GithubApiUserReposService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest
class GithubApiUserReposControllerTests {


    @Autowired
    private GithubApiUserReposController githubApiUserReposController;

    @MockBean
    private GithubApiUserReposService githubApiUserReposService;

    @Mock
    private Model model;

    @Test
    void testRepoWhenOwnerLoginInRepoDescriptionIsNotNullAndOwnerIsNull() {
        // Setup
        String owner = null;
        String repoName = "hack-pentagon";
        GithubApiRepository repo = new GithubApiRepository();
        GithubApiOwner ownerObject = new GithubApiOwner();
        ownerObject.setLogin("hackerman");
        repo.setOwner(ownerObject);
        when(githubApiUserReposService.getRepository(owner, repoName)).thenReturn(repo);
        Model model = mock(Model.class);

        // Execute
        githubApiUserReposController.repo(owner, repoName, model);

        // Verify
        verify(model).addAttribute(eq("owner"), eq("hackerman"));
        verify(model).addAttribute(eq("repo"), eq(repo));
        verifyNoMoreInteractions(model);
    }

    @Test
    void testRepoWhenOwnerObjectInRepoDescriptionIsNullAndOwnerIsNotNull() {
        // Setup
        String owner = "hackerman";
        String repoName = "hack-pentagon";
        GithubApiRepository repo = new GithubApiRepository();
        repo.setOwner(null);
        when(githubApiUserReposService.getRepository(owner, repoName)).thenReturn(repo);
        Model model = mock(Model.class);

        // Execute
        githubApiUserReposController.repo(owner, repoName, model);

        // Verify
        verify(model).addAttribute(eq("owner"), eq(owner));
        verify(model).addAttribute(eq("repo"), eq(repo));
        verifyNoMoreInteractions(model);
    }
}
