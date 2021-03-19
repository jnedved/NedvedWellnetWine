package me.jakenedved.wellnetwine.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import me.jakenedved.wellnetwine.dao.ProducersDao;

@WebServlet(name = "populatetables", value = "/populatetables")
public class PopulateServlet extends HttpServlet {


  public PopulateServlet() {
    super();
  }

  //This servlet calls the create tables method when there's a GET request
  //the create tables method also calls a method to populate the tables with
  //test date
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ProducersDao producersDao = new ProducersDao();
    try {
      producersDao.createTables();
      System.out.println("Tables were reconstructed if they didn't exist.");
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    //forwards to the page to show the results
    RequestDispatcher dispatcher = request.getRequestDispatcher("producersdetails.jsp");
    dispatcher.forward(request, response);
  }

}
