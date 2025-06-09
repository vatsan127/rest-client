package dev.srivatsan.rest_client.api;

import dev.srivatsan.rest_client.model.ToDo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name = "RestClient App", description = "the RestClient Api")
public interface RestClientAPI {

    @Operation(summary = "Get ToDo Item by ID", description = "Get ToDo Item by ID, the response is an JSON with ToDo Item")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful")})
    ResponseEntity<ToDo> getToDoByID(@Parameter(description = "ToDo Item ID", required = true) @PathVariable int id);

    @Operation(summary = "Get All ToDo Items", description = "Get All ToDo Items, the response is an JSON Array with ToDo Items")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful")})
    ResponseEntity<List<ToDo>> getAllToDos();

}
