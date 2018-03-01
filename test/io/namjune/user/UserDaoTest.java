package io.namjune.user;

import static org.junit.Assert.assertEquals;
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
  public void addUser() throws SQLException {
    userDao.addUser(UserTest.TEST_USER);
  }

  @Test
  public void findByUserId() throws Exception {
    assertEquals(UserTest.TEST_USER, userDao.findByUserId("userId"));
  }
}
