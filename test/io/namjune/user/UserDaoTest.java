package io.namjune.user;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class UserDaoTest {
  private UserDao userDao;

  @Before
  public void setup() {
    userDao = new UserDao();
  }

  @Test
  public void connection() {
    Connection con = userDao.getConnection();
    assertNotNull(con);
  }

  @Test
  public void insert() throws SQLException {
    userDao.insert(UserTest.TEST_USER);
  }
}
