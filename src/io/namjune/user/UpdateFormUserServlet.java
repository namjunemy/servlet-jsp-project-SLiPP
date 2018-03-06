package io.namjune.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/users/updateForm")
public class UpdateFormUserServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    String userId = SessionUtils.getStringValue(session, LoginServlet.SESSION_USER_ID);
    if (userId == null) {
      response.sendRedirect("/");
      return;
    }

    System.out.println("User Id : " + userId);
    UserDao userDao = new UserDao();
    try {
      User user = userDao.findByUserId(userId);
      request.setAttribute("user", user);
      RequestDispatcher rd = request.getRequestDispatcher("/form.jsp");
      rd.forward(request, response);
    } catch (Exception e) {
    }
  }
}
