package io.namjune.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import io.namjune.user.User;
import io.namjune.user.UserTest;

public class DatabaseTest {
  @Test
  public void addAndFindWhenExisted() {
    User user = UserTest.TEST_USER;
    Database.addUser(user);

    User dbUser = Database.findByUserId(user.getUserId());
    assertEquals(user, dbUser);
  }

  @Test
  public void addAndFindWhenNotExisted() {
    User dbUser = Database.findByUserId("userId2");
    assertNull(dbUser);
  }
}
