package dev.srivatsan.rest_client.controller;

import dev.srivatsan.rest_client.api.RestClientAPI;
import dev.srivatsan.rest_client.model.ToDo;
import dev.srivatsan.rest_client.service.RestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("todo")
public class RestController1 implements RestClientAPI {

    private final RestService restService;

    public RestController1(RestService restService) {
        this.restService = restService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getToDoByID(@PathVariable int id) {
        ToDo toDoByID = restService.getToDoByID(id);
        return ResponseEntity.ok(toDoByID);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ToDo>> getAllToDos() {
        List<ToDo> toDoByID = restService.getAllToDos();
        return ResponseEntity.ok(toDoByID);
    }

}
