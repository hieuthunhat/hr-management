package com.hieuthunhat.hrm.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Establishes a connection to the PostgreSQL database using JDBC.
 * Provides a method to retrieve the connection and a main method to test the connection.
 * DatabaseConnection
 */
public class DatabaseConnection {
  private static final String URL = "jdbc:postgresql://localhost:5432/hrm";
  private static final String USERNAME = "postgres";
  private static final String PASSWORD = "Hieuhayho123!@#";

  public static Connection getConnection() {
    try {
      return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    } catch (SQLException e) {
      throw new RuntimeException("Failed to connect to the database", e);
    }
  }

  public static void main(String[] args) {
    try (Connection connection = getConnection()) {
      if (connection != null) {
        System.out.println("Connected to the database!");
      } else {
        System.out.println("Failed to connect to the database.");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
