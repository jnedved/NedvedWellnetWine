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
import me.jakenedved.wellnetwine.model.Producers;

@WebServlet(name = "register", value = "/register")
public class ProducersServlet extends HttpServlet {

  private ProducersDao producersDao = new ProducersDao();

  public ProducersServlet() {
    super();
  }

  //This servlet forwards the user when there's a GET request
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RequestDispatcher dispatcher = request.getRequestDispatcher("registerproducers.jsp");
    dispatcher.forward(request, response);
  }

  //register the producer with a POST request from the sign up form
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String producersID = request.getParameter("id");
    String producersName = request.getParameter("name");
    String producersEmail = request.getParameter("email");
    String producersRegion = request.getParameter("region");

    Producers producers = new Producers();
    producers.setProducersID(producersID);
    producers.setProducersName(producersName);
    producers.setProducersEmail(producersEmail);
    producers.setProducersRegion(producersRegion);

    try {
      producersDao.registerProducer(producers);
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    RequestDispatcher dispatcher = request.getRequestDispatcher("producersdetails.jsp");
    dispatcher.forward(request, response);
  }
}
