package me.jakenedved.wellnetwine.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TablesDao {

  String url = "jdbc:oracle:thin:@localhost:1521:XE";
  String user = "student1";
  String password = "pass";

  private ResultSet resultSet = null;

  //method to drop the created tables
  public void dropTables() throws SQLException {
    Connection conn = DriverManager.getConnection(url, user, password);
    try {
      PreparedStatement preparedStatement = conn.prepareStatement("DROP TABLE PRODUCERSBOTTLES");
      preparedStatement.executeUpdate();

      preparedStatement = conn.prepareStatement("DROP TABLE PRODUCERS");
      preparedStatement.executeUpdate();

      preparedStatement = conn.prepareStatement("DROP TABLE BOTTLES");
      preparedStatement.executeUpdate();

      System.out.println("All Created Tables Have Been Dropped");

    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }


}
