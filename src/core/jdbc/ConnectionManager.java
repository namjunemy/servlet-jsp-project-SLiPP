package core.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
  public static Connection getConnection() {
    String url = "jdbc:mysql://localhost:3306/slipp";
    String id = "njkim";
    String pw = "skawns123";

    try {
      Class.forName("com.mysql.jdbc.Driver");
      return DriverManager.getConnection(url, id, pw);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }
}
