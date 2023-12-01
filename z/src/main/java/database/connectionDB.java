package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.User;

public class connectionDB {
	public static Connection connect() {
        //System.out.println(path);
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            System.out.println("connection database!!!!" );
        } catch ( ClassNotFoundException | SQLException e ) {
            System.out.println("loi connection database" );
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return c;
    }
	
	
	public static void main(String[] args) {
//		connectionDB c = new connectionDB();
		connect();
		
	}
	
}
