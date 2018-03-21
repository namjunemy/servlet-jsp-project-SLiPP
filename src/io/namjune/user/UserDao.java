package io.namjune.user;

import java.util.List;

import core.jdbc.JdbcTemplate;
import core.jdbc.RowMapper;

public class UserDao {
  public void addUser(User user) {
    JdbcTemplate template = new JdbcTemplate();
    String sql = "insert into USERS values(?, ?, ?, ?)";
    template.executeUpdate(sql, user.getUserId(), user.getPassword(), user.getName(), user.getEmail());
  }

  public User findByUserId(String userId) {
    RowMapper<User> rm = rs ->
      new User(
          rs.getString("userId"),
          rs.getString("password"),
          rs.getString("name"),
          rs.getString("email"));

    JdbcTemplate template = new JdbcTemplate();
    String sql = "select * from USERS where userId = ?";
    return template.executeQuery(sql, rm, userId);
  }

  public void removeUser(String userId) {
    JdbcTemplate template = new JdbcTemplate();
    String sql = "delete from USERS where userId = ?";
    template.executeUpdate(sql, userId);
  }

  public void updateUser(User user) {
    JdbcTemplate template = new JdbcTemplate();
    String sql = "update USERS set password = ?, name = ?, email = ? where userId = ?";
    template.executeUpdate(sql, user.getPassword(), user.getName(), user.getEmail(), user.getUserId());
  }

  public List<User> findUsers() {
    RowMapper<User> rm = rs ->
      new User(
          rs.getString("userId"),
          rs.getString("password"),
          rs.getString("name"),
          rs.getString("email"));

    JdbcTemplate template = new JdbcTemplate();
    String sql = "select * from USERS";
    return template.list(sql, rm);
  }
}
