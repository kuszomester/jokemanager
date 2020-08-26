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

    public ResponseEntity<? extends Object> addJoke(@ApiParam(value = "Joke object", required = true) @Valid @RequestBody JokeAddRequest body
    ) {
        Long newJokeId = jsi.addJoke(body);
        InlineResponse200 response = new InlineResponse200();
        response.setId(newJokeId);
        return new ResponseEntity<InlineResponse200>(response, HttpStatus.OK);
    }

    public ResponseEntity<? extends Object> deleteJoke(@ApiParam(value = "Joke id to delete", required = true) @PathVariable("id") Long id
    ) {
        try {
            jsi.deleteJoke(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch (EmptyResultDataAccessException ex) {
            ErrorMessage response = new ErrorMessage();
            response.setCode("JAPI-404");
            response.setMessage("Joke not found for provided id.");
            return new ResponseEntity<ErrorMessage>(response, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<ChuckNorrisJokeResponse> getChuckNorrisJoke() {
        io.chucknorris.client.Joke chuckNorrisJoke = jsi.getChuckNorrisJoke();
        ChuckNorrisJokeResponse response = new ChuckNorrisJokeResponse();
        response.setUrl(chuckNorrisJoke.getSourceUrl());
        response.setContent(chuckNorrisJoke.getValue());
        return new ResponseEntity<ChuckNorrisJokeResponse>(response, HttpStatus.OK);
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
