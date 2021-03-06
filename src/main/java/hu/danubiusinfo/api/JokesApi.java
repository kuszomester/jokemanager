package hu.danubiusinfo.api;

import hu.danubiusinfo.model.*;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-08-21T16:03:39.600Z[GMT]")
@Api(value = "jokes", description = "the jokes API")
public interface JokesApi {

    @ApiOperation(value = "", nickname = "addJoke", notes = "Upload a new joke", response = hu.danubiusinfo.model.InlineResponse200.class, tags = {"joke",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = InlineResponse200.class),
            @ApiResponse(code = 400, message = "Empty or missing joke content", response = ErrorMessage.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorMessage.class)})
    @RequestMapping(value = "/jokes",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<? extends Object> addJoke(@ApiParam(value = "Joke object", required = true) @Valid @RequestBody JokeAddRequest body
    );


    @ApiOperation(value = "", nickname = "deleteJoke", notes = "Deletes a joke", tags = {"joke",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Joke deleted"),
            @ApiResponse(code = 400, message = "Invalid ID supplied", response = ErrorMessage.class),
            @ApiResponse(code = 404, message = "Joke not found", response = ErrorMessage.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorMessage.class)})
    @RequestMapping(value = "/jokes/{id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<? extends Object> deleteJoke(@ApiParam(value = "Joke id to delete", required = true) @PathVariable("id") Long id
    );


    @ApiOperation(value = "", nickname = "getChuckNorrisJoke", notes = "Get a random Chuch Norris joke from an external service", response = ChuckNorrisJokeResponse.class, tags = {"joke",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = ChuckNorrisJokeResponse.class),
            @ApiResponse(code = 404, message = "Joke database is empty", response = ErrorMessage.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorMessage.class),
            @ApiResponse(code = 504, message = "Chuck Norris joke API is not responding", response = ErrorMessage.class)})
    @RequestMapping(value = "/jokes/chuck-norris",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<? extends Object> getChuckNorrisJoke();


    @ApiOperation(value = "", nickname = "getJokeById", notes = "Get a joke by its id", response = JokeResponse.class, tags = {"joke",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = JokeResponse.class),
            @ApiResponse(code = 400, message = "Invalid ID supplied", response = ErrorMessage.class),
            @ApiResponse(code = 404, message = "Joke not found", response = ErrorMessage.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorMessage.class)})
    @RequestMapping(value = "/jokes/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<? extends Object> getJokeById(@ApiParam(value = "ID of joke to return", required = true) @PathVariable("id") Long id
    );


    @ApiOperation(value = "", nickname = "getRandomJoke", notes = "Get a random joke from the database", response = JokeResponse.class, tags = {"joke",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = JokeResponse.class),
            @ApiResponse(code = 404, message = "Joke database is empty", response = ErrorMessage.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorMessage.class)})
    @RequestMapping(value = "/jokes/random",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<? extends Object> getRandomJoke();

}

