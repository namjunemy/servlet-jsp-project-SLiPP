package io.namjune.user;

public class JavaBean {
  private String userName;
  private String password;
  private Integer id;

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

  public Integer getId() {
    return id;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
