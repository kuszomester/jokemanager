package hu.danubiusinfo.service;

import hu.danubiusinfo.model.Joke;
import hu.danubiusinfo.model.JokeAddRequest;

public interface JokeService {

    Joke getJokeById(Long id);

    Joke getRandomJoke();

    void deleteJoke(Long id);

    Long addJoke(JokeAddRequest request);

    Joke getChuckNorrisJoke();

}
