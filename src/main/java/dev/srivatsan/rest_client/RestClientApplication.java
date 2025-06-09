package dev.srivatsan.rest_client;

import dev.srivatsan.rest_client.model.ToDo;
import dev.srivatsan.rest_client.service.RestService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class RestClientApplication implements CommandLineRunner {

    private final RestService restService;

    public RestClientApplication(RestService restService) {
        this.restService = restService;
    }

    public static void main(String[] args) {
        SpringApplication.run(RestClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ToDo response = restService.getToDoByID(1);
        System.out.println("Response ::  getToDoByID - " + response);

        List<ToDo> allToDos = restService.getAllToDos();
        System.out.println("Response :: getAllToDos - " + allToDos);
    }
}
