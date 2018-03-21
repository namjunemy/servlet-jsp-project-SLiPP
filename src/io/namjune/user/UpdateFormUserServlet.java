package io.namjune.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/users/updateForm")
public class UpdateFormUserServlet extends HttpServlet {
  static final Logger logger = LoggerFactory.getLogger(UpdateFormUserServlet.class);

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    String userId = SessionUtils.getStringValue(session, LoginServlet.SESSION_USER_ID);
    if (userId == null) {
      response.sendRedirect("/");
      return;
    }

    logger.debug("User Id : {}", userId);
    UserDao userDao = new UserDao();
    User user = userDao.findByUserId(userId);
    request.setAttribute("isUpdate", true);
    request.setAttribute("user", user);
    RequestDispatcher rd = request.getRequestDispatcher("/form.jsp");
    rd.forward(request, response);
  }
}
