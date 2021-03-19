package me.jakenedved.wellnetwine.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import me.jakenedved.wellnetwine.dao.TablesDao;

@WebServlet(name = "droptables", value = "/droptables")
public class TablesServlet extends HttpServlet {


  public TablesServlet() {
    super();
  }

  //This servlet calls the drop tables method when there's a GET request
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    TablesDao tablesDao = new TablesDao();
    try {
      tablesDao.dropTables();
      System.out.println("drop tables method ran after TablesServlet call");
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    //forwards to the page to show the results
    RequestDispatcher dispatcher = request.getRequestDispatcher("producersdetails.jsp");
    dispatcher.forward(request, response);
  }

}
