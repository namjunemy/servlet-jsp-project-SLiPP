package io.namjune.db;

import java.util.HashMap;
import java.util.Map;

import io.namjune.user.User;

public class Database {
  private static Map<String, User> users = new HashMap<>();

  public static void addUser(User user) {
    System.out.println("user > " + user);
    users.put(user.getUserId(), user);
  }
}
