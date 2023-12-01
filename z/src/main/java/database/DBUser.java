package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class DBUser {

	public User checkUSER(String taikhoan, String matkhau){
		
		String sql = "SELECT USER_NAME, PASSWORD  FROM USERS WHERE USER_NAME=? AND PASSWORD=?";
	        try(Connection c = connectionDB.connect()){

	            

	            PreparedStatement ps = c.prepareStatement(sql);
	            //'"+title+"',"+Authorid+" , 18022018, 0000, "+Isbn+"
	            ps.setString(1, taikhoan);
				ps.setString(2, matkhau);
	            ResultSet rs = ps.executeQuery();
//vttoan@hcmuaf.edu.vn
	            
	            if(rs.next()){
	                String  USER_NAME = rs.getString("USER_NAME");
	                String  PASSWORD = rs.getString("PASSWORD");
	                User b = new User(USER_NAME,PASSWORD);
	                System.out.println("ok!!!");
	                return b;
	            }
	            rs.close();
	        }catch (Exception ex){
	        	System.out.println("loi" );
	            ex.printStackTrace();
	        }
	        return null;


	}

	public static void main(String[] args) throws SQLException {
		DBUser l = new DBUser();
		User a = l.checkUSER("PERSON1", "123");
		System.out.println(a.getUserName());

	}

}
