package io.namjune.user;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Test;

import io.namjune.support.ConnectionManager;

public class ConnectionManagerTest {
  @Test
  public void connection() {
    Connection con = ConnectionManager.getConnection();
    assertNotNull(con);
  }
}
