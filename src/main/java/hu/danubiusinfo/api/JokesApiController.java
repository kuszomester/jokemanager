package hu.danubiusinfo.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.danubiusinfo.model.*;
import hu.danubiusinfo.service.JokeServiceImpl;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-08-21T16:03:39.600Z[GMT]")
@Controller
public class JokesApiController implements JokesApi {

    private static final Logger log = LoggerFactory.getLogger(JokesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private JokeServiceImpl jsi;

    @org.springframework.beans.factory.annotation.Autowired
    public JokesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addJoke(@ApiParam(value = "Joke object", required = true) @Valid @RequestBody JokeAddRequest body
    ) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteJoke(@ApiParam(value = "Joke id to delete", required = true) @PathVariable("id") Long id
    ) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ChuckNorrisJokeResponse> getChuckNorrisJoke() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ChuckNorrisJokeResponse>(objectMapper.readValue("{\n  \"createdAt\" : \"2018-03-20T09:12:28Z\",\n  \"url\" : \"https://api.chucknorris.io/jokes/-NBlNyx1TUyW_8lGoOkvOw\",\n  \"content\" : \"Chuck Norris invented cranberries by uprooting a cherry tree and throwing it into a farm pond.\n\"\n}", ChuckNorrisJokeResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ChuckNorrisJokeResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ChuckNorrisJokeResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<? extends Object> getJokeById(@ApiParam(value = "ID of joke to return", required = true) @PathVariable("id") Long id
    ) {
        try {
            Joke result = jsi.getJokeById(id);
            JokeResponse response = new JokeResponse();
            response.setId(result.getId());
            response.setContent(result.getContent());
            response.setCreatedAt(result.getCreatedAt());
            return new ResponseEntity<JokeResponse>(response, HttpStatus.OK);
        } catch (EmptyResultDataAccessException ex) {
            ErrorMessage response = new ErrorMessage();
            response.setCode("JAPI-404");
            response.setMessage("Joke not found for provided id.");
            return new ResponseEntity<ErrorMessage>(response, HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<? extends Object> getRandomJoke() {
        try {
            Joke result = jsi.getRandomJoke();
            JokeResponse response = new JokeResponse();
            response.setId(result.getId());
            response.setContent(result.getContent());
            response.setCreatedAt(result.getCreatedAt());
            return new ResponseEntity<JokeResponse>(response, HttpStatus.OK);
        } catch (EmptyResultDataAccessException ex) {
            ErrorMessage response = new ErrorMessage();
            response.setCode("JAPI-404");
            response.setMessage("No jokes found in database.");
            return new ResponseEntity<ErrorMessage>(response, HttpStatus.NOT_FOUND);
        }
    }
}
