package io.namjune.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
  public void crud() throws SQLException {
    User user = UserTest.TEST_USER;
    userDao.removeUser(user.getUserId());
    userDao.addUser(user);

    User dbUser = userDao.findByUserId(user.getUserId());
    assertEquals(user, dbUser);

    User updateUser = new User(user.getUserId(), "updatePW", "updateUser", "update@gmail.com");
    userDao.updateUser(updateUser);

    dbUser = userDao.findByUserId(updateUser.getUserId());
    assertEquals(updateUser, dbUser);
  }

  @Test
  public void findWhenNotExisted() throws Exception {
    User user = UserTest.TEST_USER;
    userDao.removeUser(user.getUserId());
    User dbUser = userDao.findByUserId(user.getUserId());
    assertNull(dbUser);
  }
}
