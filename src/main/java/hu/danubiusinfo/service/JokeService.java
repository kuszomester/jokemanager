package hu.danubiusinfo.service;

import hu.danubiusinfo.model.Joke;

public interface JokeService {

    Joke getJokeById(Long id);

    Joke getRandomJoke();

}
