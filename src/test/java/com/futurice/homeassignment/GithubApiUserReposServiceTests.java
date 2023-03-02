package com.futurice.homeassignment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import com.futurice.homeassignment.entities.GithubApiRepository;
import com.futurice.homeassignment.service.GithubApiUserReposService;


@SpringBootTest
class GithubApiUserReposServiceTests {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private GithubApiUserReposService githubApiUserReposService;

	@Test
	void contextLoads() {
	}

	@Test
	void getRepositoriesByOwnerReturnsCorrespondingRepoNamesAndNumberOfRepos() {
		String owner = "dinosaur";
		String url = "https://api.github.com/users/" + owner + "/repos";
		String responseBody = "[{\"name\": \"repository1\"}, {\"name\": \"repository2\"}]";
		MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);
		mockServer.expect(requestTo(url)).andExpect(method(HttpMethod.GET))
				.andRespond(withSuccess(responseBody, MediaType.APPLICATION_JSON));

		// Execute
		List<GithubApiRepository> repositories = githubApiUserReposService.getRepositoriesByOwner(owner);

		// Verify
		assertThat(repositories.size()).isEqualTo(2);
		assertThat(repositories.get(0).getName()).isEqualTo("repository1");
		assertThat(repositories.get(1).getName()).isEqualTo("repository2");
		mockServer.verify();
	}

	@Test
	void getRepositoriesByOwnerReturnsEmptyListOnANullResponse() {
		// Setup
		String owner = "dinosaur";
		String url = "https://api.github.com/users/" + owner + "/repos";
		MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);
		mockServer.expect(requestTo(url)).andExpect(method(HttpMethod.GET))
				.andRespond(withSuccess("null", MediaType.APPLICATION_JSON));

		// Execute
		List<GithubApiRepository> repositories = githubApiUserReposService.getRepositoriesByOwner(owner);

		// Verify
		assertThat(repositories).isNotNull().isEmpty();
		mockServer.verify();
	}
}
