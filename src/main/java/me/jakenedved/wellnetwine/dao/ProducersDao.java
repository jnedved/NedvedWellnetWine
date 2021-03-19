package me.jakenedved.wellnetwine.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import me.jakenedved.wellnetwine.model.Producers;

public class ProducersDao {

  int result = 0;

  //DB connection info stored in variables for easy updating
  String url = "jdbc:oracle:thin:@localhost:1521:XE";
  String user = "student1";
  String password = "pass";

  private ResultSet resultSet = null;

  //method to create the tables this site uses
  public int createTables() throws SQLException {
    Connection conn = DriverManager.getConnection(url, user, password);

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("CREATE TABLE producers (\n"
          + "   producers_id VARCHAR2(255) NOT NULL,\n"
          + "   producers_name VARCHAR2(255) NOT NULL,\n"
          + "   producers_email VARCHAR2(255) NOT NULL,\n"
          + "   producers_region VARCHAR2(255) NOT NULL,\n"
          + "   CONSTRAINT producers_id_pk PRIMARY KEY (producers_id)\n"
          + ")");
      result = preparedStatement.executeUpdate();
      System.out.println("producers Table created.");

      preparedStatement = conn.prepareStatement("CREATE TABLE bottles (\n"
          + "   bottles_id VARCHAR2(255) NOT NULL,\n"
          + "   bottles_name VARCHAR2(255) NOT NULL,\n"
          + "   bottles_producer VARCHAR2(255) NOT NULL,\n"
          + "   bottles_varietal VARCHAR2(50) NOT NULL,\n"
          + "   bottles_size VARCHAR2(50),\n"
          + "   bottles_year NUMBER(4),\n"
          + "   bottles_price NUMBER(10, 2),\n"
          + "   CONSTRAINT bottles_id_pk PRIMARY KEY (bottles_id)\n"
          + ")");

      preparedStatement.executeUpdate();
      System.out.println("bottles Table created");

      preparedStatement = conn.prepareStatement("CREATE TABLE ProducersBottles(\n"
          + "   producers_id VARCHAR(255),\n"
          + "   bottles_id VARCHAR(255),\n"
          + "   PRIMARY KEY (producers_id, bottles_id),\n"
          + "   FOREIGN KEY (producers_id) REFERENCES producers,\n"
          + "   FOREIGN KEY (bottles_id) REFERENCES bottles\n"
          + ")");

      result = preparedStatement.executeUpdate();
      System.out.println("producersbottles Table created");

      //after creating tables it calls this method
      populateTables();

    } catch (SQLException ex) {
      ex.printStackTrace();
    }

    return result;
  }

  //populates the created tables with test data
  private void populateTables() throws SQLException {
    Connection conn = DriverManager.getConnection(url, user, password);
    PreparedStatement preparedStatement = null;
    try {

      System.out.println("Populating Producers Table...");
      preparedStatement = conn.prepareStatement(
          "INSERT INTO producers VALUES (12345, 'West Cape Howe Wines', 'wine@westcapewines.com', 'Western Australia')");
      preparedStatement.executeUpdate();
      preparedStatement = conn.prepareStatement(
          "INSERT INTO producers VALUES (10923, 'Lancaster Wines', 'info@lancaster.com', 'Western Australia')");
      preparedStatement.executeUpdate();
      preparedStatement = conn.prepareStatement(
          "INSERT INTO producers VALUES (90981, 'Ghost Rock Wines', 'help@ghostrockwines.com', 'Tasmania')");
      preparedStatement.executeUpdate();
      preparedStatement = conn.prepareStatement(
          "INSERT INTO producers VALUES (08983, 'Jansz Tasmania', 'jansz@jansztasmania.com', 'Tasmania')");
      preparedStatement.executeUpdate();
      preparedStatement = conn.prepareStatement(
          "INSERT INTO producers VALUES (90872, 'Woongooroo Estate', 'estate@woongooroo.com', 'Queensland')");
      preparedStatement.executeUpdate();

      System.out.println("Populating Bottles Table...");
      preparedStatement = conn.prepareStatement(
          "INSERT INTO bottles VALUES (338098, 'Somerset White', 90872, 'White Blend', '750ml', 2019, 18.00)");
      preparedStatement.executeUpdate();
      preparedStatement = conn.prepareStatement(
          "INSERT INTO bottles VALUES (338089, 'Classic White', 90872, 'Sauvignon Blanc', '750ml', 2018, 12.00)");
      preparedStatement.executeUpdate();
      preparedStatement = conn.prepareStatement(
          "INSERT INTO bottles VALUES (337322, 'Single Vineyard Sparkling', 08983, 'Chardonnay', '750ml', 2013, 65.00)");
      preparedStatement.executeUpdate();
      preparedStatement = conn.prepareStatement(
          "INSERT INTO bottles VALUES (331932, 'Supernatural Pinot Noir', 90981, 'Pinot Noir', '750ml', 2020, 29.00)");
      preparedStatement.executeUpdate();
      preparedStatement = conn.prepareStatement(
          "INSERT INTO bottles VALUES (331834, 'Supernatural Pet Nat', 90981, 'Blend', '750ml', 2019, 25.00)");
      preparedStatement.executeUpdate();
      preparedStatement = conn.prepareStatement(
          "INSERT INTO bottles VALUES (338293, 'Lexi', 10923, 'Moscato', '750ml', 2020, 14.00)");
      preparedStatement.executeUpdate();
      preparedStatement = conn.prepareStatement(
          "INSERT INTO bottles VALUES (338244, 'Tin Shed', 10923, 'White Blend', '750ml', 2019, 16.00)");
      preparedStatement.executeUpdate();
      preparedStatement = conn.prepareStatement(
          "INSERT INTO bottles VALUES (332634, 'Windy Hill', 12345, 'Shiraz', '750ml', 2019, 22.00)");
      preparedStatement.executeUpdate();
      preparedStatement = conn.prepareStatement(
          "INSERT INTO bottles VALUES (332639, 'WCH Cab Franc', 12345, 'Cabernet Franc', '750ml', 2019, 30.00)");
      preparedStatement.executeUpdate();

      System.out.println("Populating ProducersBottles Table...");
      preparedStatement = conn
          .prepareStatement("INSERT INTO producersbottles VALUES(12345, 332634)");
      preparedStatement.executeUpdate();
      preparedStatement = conn
          .prepareStatement("INSERT INTO producersbottles VALUES(12345, 332639)");
      preparedStatement.executeUpdate();
      preparedStatement = conn
          .prepareStatement("INSERT INTO producersbottles VALUES(10923, 338244)");
      preparedStatement.executeUpdate();
      preparedStatement = conn
          .prepareStatement("INSERT INTO producersbottles VALUES(10923, 338293)");
      preparedStatement.executeUpdate();
      preparedStatement = conn
          .prepareStatement("INSERT INTO producersbottles VALUES(90981, 331834)");
      preparedStatement.executeUpdate();
      preparedStatement = conn
          .prepareStatement("INSERT INTO producersbottles VALUES(90981, 331932)");
      preparedStatement.executeUpdate();
      preparedStatement = conn
          .prepareStatement("INSERT INTO producersbottles VALUES(08983, 337322)");
      preparedStatement.executeUpdate();
      preparedStatement = conn
          .prepareStatement("INSERT INTO producersbottles VALUES(90872, 332639)");
      preparedStatement.executeUpdate();
      preparedStatement = conn
          .prepareStatement("INSERT INTO producersbottles VALUES(90872, 338098)");
      preparedStatement.executeUpdate();

    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  //method used by the sign up form to store entered information in the database
  public int registerProducer(Producers producers) throws ClassNotFoundException, SQLException {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    int producersTable = createTables();
    System.out.println(producersTable);

    try (Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement preparedStatement = connection.prepareStatement(
            "INSERT INTO student1.producers(producers_id, producers_name, producers_email, producers_region) VALUES(?, ?, ?, ?)")) {
      preparedStatement.setString(1, producers.getProducersID());
      preparedStatement.setString(2, producers.getProducersName());
      preparedStatement.setString(3, producers.getProducersEmail());
      preparedStatement.setString(4, producers.getProducersRegion());

      result = preparedStatement.executeUpdate();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }

    return result;
  }

  //method to get the contents of the producers table
  public ResultSet getProducersRS() throws SQLException {
    Connection con = DriverManager.getConnection(url, user, password);

    try {
      Statement stm = con.createStatement();
      resultSet = stm.executeQuery("SELECT * FROM PRODUCERS");

      return resultSet;
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return resultSet;
  }

  //method to get the contents of the bottles table
  public ResultSet getBottlesRS() throws SQLException {
    Connection con = DriverManager.getConnection(url, user, password);

    try {
      Statement stm = con.createStatement();
      resultSet = stm.executeQuery("SELECT * FROM BOTTLES");

      return resultSet;
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return resultSet;
  }

  //method to get the contents of the producersbottles table
  public ResultSet getProducersBottlesRS() throws SQLException {
    Connection con = DriverManager.getConnection(url, user, password);

    try {
      Statement stm = con.createStatement();
      resultSet = stm.executeQuery("SELECT * FROM PRODUCERSBOTTLES");

      return resultSet;
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return resultSet;
  }
}
