<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="io.namjune.user.User"%>
<%@ page import="io.namjune.db.Database"%>
<%
  String userId = request.getParameter("userId");
  String password = request.getParameter("password");

  User user = Database.findByUserId(userId);
  if (user == null) {
    // 사용자가 존재하지 않는다는 것을 에러 메세지 전송
  }
  
  if (password.equals(user.getPassword())) {
    
  } else {

  }
%>