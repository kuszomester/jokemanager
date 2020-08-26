package hu.danubiusinfo.service;

import hu.danubiusinfo.model.Joke;
import hu.danubiusinfo.model.JokeAddRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.threeten.bp.DateTimeUtils;
import org.threeten.bp.ZoneOffset;

import java.sql.PreparedStatement;

@Service
public class JokeServiceImpl implements JokeService {

    private static String SELECT_SINGLE_JOKE_SQL = "SELECT * FROM jokes WHERE id = ?";
    private static String SELECT_RANDOM_JOKE_SQL = "SELECT * FROM jokes ORDER BY rand() LIMIT 1";
    private static String DELETE_JOKE_SQL = "DELETE FROM jokes WHERE id = ?";
    private static String INSERT_JOKE_SQL = "INSERT INTO jokes (content, createdAt) VALUES (?, CURRENT_TIMESTAMP)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Joke getJokeById(Long id) throws EmptyResultDataAccessException {
        return jdbcTemplate.queryForObject(SELECT_SINGLE_JOKE_SQL, new Object[]{id}, (rs, rowNum) ->
                new Joke(
                        rs.getLong("id"),
                        rs.getString("content"),
                        DateTimeUtils.toInstant(rs.getTimestamp("createdAt")).atOffset(ZoneOffset.ofHours(1))
                ));
    }

    @Override
    public Joke getRandomJoke() throws EmptyResultDataAccessException {
        return jdbcTemplate.queryForObject(SELECT_RANDOM_JOKE_SQL, new Object[]{}, (rs, rowNum) ->
                new Joke(
                        rs.getLong("id"),
                        rs.getString("content"),
                        DateTimeUtils.toInstant(rs.getTimestamp("createdAt")).atOffset(ZoneOffset.ofHours(1))
                ));
    }

    @Override
    public void deleteJoke(Long id) throws EmptyResultDataAccessException{
        int rowsAffected = jdbcTemplate.update(DELETE_JOKE_SQL, id);
        if(rowsAffected == 0){
            throw new EmptyResultDataAccessException(1);
        }
    }

    @Override
    public Long addJoke(JokeAddRequest request) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(INSERT_JOKE_SQL);
            ps.setString(1, request.getContent());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().longValue();
    }

    @Override
    public Joke getChuckNorrisJoke() {
        return null;
    }

}
