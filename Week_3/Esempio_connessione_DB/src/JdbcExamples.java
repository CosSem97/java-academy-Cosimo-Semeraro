import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExamples {

  public static void main(String[] args) {

    JdbcExamples jdbcEx = new JdbcExamples();

    try {
      jdbcEx.simpleQuery();

      // jdbcEx.simpleQueryBis();

      // jdbcEx.insertExample();

      // jdbcEx.insertNoAutocommitExample();

      // jdbcEx.deleteExample();

    } catch (Exception e) {
      e.printStackTrace();
    }


  }

  
  
  private void simpleQuery() throws SQLException {
    
    System.out.println("Executing Query");
    
    Connection conn = getConnection("vendite");
    if (conn == null) {
      return;
    }

    // Creating statement
    Statement st = conn.createStatement();

    // Executing the query and creating the result set
    ResultSet rs = st.executeQuery("select product_name, price from products");

    // Processing the results
    while (rs.next()) {
      System.out
          .println("Product: " + rs.getString("product_name") + " costs " + rs.getFloat("price"));
    }

    // Closing the connections
    // using close() method to release system resources
    try {
      conn.close();
    } catch (SQLException ex) {
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
      System.exit(-1);
    }

  }

  
  
  private void simpleQueryBis() throws SQLException {
    System.out.println("Executing Query");

    Connection conn = getConnection("vendite");
    if (conn == null) {
      return;
    }

    // Creating statement
    Statement st = conn.createStatement();

    // Executing the query and creating the result set
    ResultSet rs = st.executeQuery("select product_name, price from products");

    // Processing the results
    while (rs.next()) {
      System.out.println("Product: " + rs.getString(1) + " costs " + rs.getFloat(2));
    }

    // Closing the connections
    // using close() method to release system resources
    try {
      conn.close();
    } catch (SQLException ex) {
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
      System.exit(-1);
    }

  }


  
  private void insertExample() throws SQLException {
    System.out.println("Executing Insert");

    Connection conn = getConnection("vendite");
    if (conn == null) {
      return;
    }

    // Creating statement
    Statement st = conn.createStatement();

    // Executing the query and creating the result set
    int result =
        st.executeUpdate("insert into products (product_name, price) Values ('MacBook 20', 2000)");
    System.out.println("Inserted " + result + " rows");

    // Closing the connections
    // using close() method to release system resources
    try {
      conn.close();
    } catch (SQLException ex) {
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
      System.exit(-1);
    }

  }

  
  
  private void insertNoAutocommitExample() throws SQLException {
    System.out.println("Executing Insert");

    Connection conn = getConnection("vendite");
    if (conn == null) {
      return;
    }

    // set Autocommit False
    conn.setAutoCommit(false);

    // Creating statement
    Statement st = conn.createStatement();
    

    // Executing the query and creating the result set
    int result =
        st.executeUpdate("insert into products (product_name, price) Values ('MacBook 20', 2000)");
    System.out.println("Inserted " + result + " rows");
    
    //do the commit
    conn.commit();

    // Closing the connections
    // using close() method to release system resources
    try {
      conn.close();
    } catch (SQLException ex) {
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
      System.exit(-1);
    }

  }
  
  
  
  private void deleteExample() throws SQLException {
    System.out.println("Executing Delete");

    Connection conn = getConnection("vendite");
    if (conn == null) {
      return;
    }

    // Creating statement
    Statement st = conn.createStatement();

    // Executing the query and creating the result set
    int result =
        st.executeUpdate("delete from products where price > 1500");
    System.out.println("Deleted " + result + " rows");

    // Closing the connections
    // using close() method to release system resources
    try {
      conn.close();
    } catch (SQLException ex) {
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
      System.exit(-1);
    }

  }

  
  
  // PLEASE: setup the correct password
  private Connection getConnection(String DBname) {

    String dbPassword = "password";

    // Establishing a connection
    Connection con = null;
    try {
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/" + DBname + "?" + "user=javauser&password=" + dbPassword);
    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
      System.exit(-1);
    }

    return con;
  }

}
