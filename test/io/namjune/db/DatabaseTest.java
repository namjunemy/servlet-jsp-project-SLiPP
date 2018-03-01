package io.namjune.db;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import io.namjune.user.User;
import io.namjune.user.UserDao;
import io.namjune.user.UserTest;

public class DatabaseTest {
  private UserDao userDao = new UserDao();

  @Test
  public void addAndFindWhenExisted() throws SQLException {
    User user = UserTest.TEST_USER;
    userDao.addUser(user);

    User dbUser = userDao.findByUserId(user.getUserId());
    assertEquals(user, dbUser);
  }

  @Test
  public void addAndFindWhenNotExisted() throws SQLException {
    User dbUser = userDao.findByUserId("userId2");
    assertNull(dbUser);
  }
}
