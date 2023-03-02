# Github Api User Repos App

## Project description:
This app takes a Github login name and receives the corresponding Gi repositories with the data of the chosen repositories.
## Stack
* Java 19
* Spring Boot 3.0.3
* Maven
* Jar packaging
* Thymeleaf (as Frontend)

## How to run:
* Download and install Java 19 on your computer
* Clone the project repo from git to your computer
* Open the project with an IDE, preferably with IntelliJ
* In IntelliJ select File > Project Structure choose SDK > Oracle OpenJDK version 19.0.1
* Navigate to the class ProcessGitHubApiDataApplication and run the service.
* Go to a browser and use link: http://localhost:8080/
* Enter someone's Github owner's login name. 
* Click on one of the shown repos. You will receive some data about this repo.
* If there are no repos, the corresponding text will be shown.