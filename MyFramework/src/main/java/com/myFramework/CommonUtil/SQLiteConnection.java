package com.myFramework.CommonUtil;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class SQLiteConnection {
	public static void createTableSqLite() throws IOException {
		Connection c = null;
	    Statement stmt = null;
	    
	    Files.deleteIfExists(Paths.get("test-output/SqLite/test.db"));
	    
	    try {
	       Class.forName("org.sqlite.JDBC");
	       c = DriverManager.getConnection("jdbc:sqlite:test-output/SqLite/test.db");
	       System.out.println("Opened database successfully");
	
	       stmt = c.createStatement();
	       String sql = "CREATE TABLE MYCOMPANY1 " +
	                      "(ID INT PRIMARY KEY     NOT NULL," +
	                      " NAME           TEXT    NOT NULL, " + 
	                      " YEAR            TEXT     NOT NULL, " + 
	                      " RATING         TEXT)"; 
	       stmt.executeUpdate(sql);
	       
	      
	         sql = "INSERT INTO MYCOMPANY1 (ID,NAME,YEAR,RATING) " +
	                        "VALUES (1, 'shashi', '2010', '10' );"; 
	         stmt.executeUpdate(sql);

	       
	       ResultSet rs = stmt.executeQuery( "SELECT * FROM MYCOMPANY1;" );
	         
	         while ( rs.next() ) {
	         int id = rs.getInt("ID");
	         String  name = rs.getString("NAME");
	         String year  = rs.getString("YEAR");
	         float rating = rs.getFloat("RATING");
	         
	         System.out.println( "ID = " + id );
	         System.out.println( "NAME = " + name );
	         System.out.println( "YEAR = " + year );
	         System.out.println( "RATING = " + rating);
	         System.out.println();
	         }
	       
	       stmt.close();
	       c.close();
	    } catch ( Exception e ) {
	       System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	       System.exit(0);
	    }
	    
	}

	public static void main(String args[]) throws IOException{
		createTableSqLite();
	}
}


