package dev.srivatsan.rest_client.service;

import dev.srivatsan.rest_client.model.ToDo;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RestService {

    private final String JSON_PLACEHOLDER_URL = "http://jsonplaceholder.typicode.com/todos/";

    private final RestClient restClient;

    public RestService(RestClient restClient) {
        this.restClient = restClient;
    }

    public ToDo getToDoByID(int id) {
        String url = JSON_PLACEHOLDER_URL + "/" + id;
        return restClient
                .get()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(ToDo.class);
    }

    public List<ToDo> getAllToDos() {
        return restClient
                .get()
                .uri(JSON_PLACEHOLDER_URL)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(new ParameterizedTypeReference<List<ToDo>>() {
                });
    }

}

