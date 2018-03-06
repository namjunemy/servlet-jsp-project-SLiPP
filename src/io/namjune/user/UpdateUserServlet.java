package io.namjune.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/users/update")
public class UpdateUserServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    HttpSession session = request.getSession();
    String sessionUserId = SessionUtils.getStringValue(session, LoginServlet.SESSION_USER_ID);

    // 세션을 가지고 있지않은 경우 보안 처리
    if (sessionUserId == null) {
      response.sendRedirect("/");
      return;
    }

    // 세션에 저장된 아이디가 아닌 다른 아이디의 수정이 이루어질 경우 보안 처리
    String userId = request.getParameter("userId");
    if (!sessionUserId.equals(userId)) {
      response.sendRedirect("/");
      return;
    }

    String password = request.getParameter("password");
    String name = request.getParameter("name");
    String email = request.getParameter("email");

    User user = new User(userId, password, name, email);
    UserDao userDao = new UserDao();
    try {
      userDao.updateUser(user);
    } catch (Exception e) {
    }
    response.sendRedirect("/");
  }
}
