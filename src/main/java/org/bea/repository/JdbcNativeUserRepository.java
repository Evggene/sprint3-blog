package org.bea.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.bea.model.User;

import java.util.List;

@Repository
public class JdbcNativeUserRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcNativeUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(
                "select id, first_name, last_name, age, active from users",
                (rs, rowNum) -> new User(
                        rs.getLong("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("age"),
                        rs.getBoolean("active")
                ));
    }

    @Override
    public User save(User user) {
        var insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("users");
        var paramSource = new BeanPropertySqlParameterSource(user);
        insert.usingGeneratedKeyColumns("id");
        var keyHolder = insert.executeAndReturnKeyHolder(paramSource);
        user.setId((Long) keyHolder.getKeys().get("id"));
        return user;
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("delete from users where id = ?", id);
    }
}
