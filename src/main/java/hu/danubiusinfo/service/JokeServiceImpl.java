package hu.danubiusinfo.service;

import hu.danubiusinfo.model.Joke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.threeten.bp.DateTimeUtils;
import org.threeten.bp.ZoneOffset;

@Service
public class JokeServiceImpl implements JokeService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Joke getJokeById(Long id) throws EmptyResultDataAccessException {
        String sql = "SELECT * FROM jokes WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new Joke(
                        rs.getLong("id"),
                        rs.getString("content"),
                        DateTimeUtils.toInstant(rs.getTimestamp("createdAt")).atOffset(ZoneOffset.ofHours(1))
                ));
    }

    @Override
    public Joke getRandomJoke() throws EmptyResultDataAccessException {
        String sql = "SELECT * FROM jokes ORDER BY rand() LIMIT 1";

        return jdbcTemplate.queryForObject(sql, new Object[]{}, (rs, rowNum) ->
                new Joke(
                        rs.getLong("id"),
                        rs.getString("content"),
                        DateTimeUtils.toInstant(rs.getTimestamp("createdAt")).atOffset(ZoneOffset.ofHours(1))
                ));
    }

}
