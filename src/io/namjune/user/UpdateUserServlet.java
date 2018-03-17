package io.namjune.user;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.commons.beanutils.BeanUtilsBean;

import io.namjune.support.MyValidatorFactory;

@WebServlet("/users/update")
public class UpdateUserServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    String sessionUserId = SessionUtils.getStringValue(session, LoginServlet.SESSION_USER_ID);

    // 세션을 가지고 있지않은 경우 보안 처리
    if (sessionUserId == null) {
      response.sendRedirect("/");
      return;
    }

    User user = new User();

    try {
      BeanUtilsBean.getInstance().populate(user, request.getParameterMap());

    } catch (IllegalAccessException | InvocationTargetException e) {
      throw new ServletException(e);
    }

    if (!user.isSameUser(sessionUserId)) {
      response.sendRedirect("/");
      return;
    }

    Validator validator = MyValidatorFactory.createValidator();
    Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
    if (constraintViolations.size() > 0) {
      request.setAttribute("isUpdate", true);
      request.setAttribute("user", user);

      Iterator<ConstraintViolation<User>> violations = constraintViolations.iterator();
      String errorMessage = "";
      while (violations.hasNext()) {
        ConstraintViolation<User> each = violations.next();
        errorMessage += each.getPropertyPath() + " : " + each.getMessage() + " ";
      }

      forwardJSP(request, response, errorMessage);
      return;
    }
    UserDao userDao = new UserDao();
    try {
      userDao.updateUser(user);
    } catch (Exception e) {
    }
    response.sendRedirect("/");
  }

  private void forwardJSP(HttpServletRequest request, HttpServletResponse response, String errorMessage)
      throws ServletException, IOException {
    request.setAttribute("errorMessage", errorMessage);
    RequestDispatcher rd = request.getRequestDispatcher("/form.jsp");
    rd.forward(request, response);
  }
}
