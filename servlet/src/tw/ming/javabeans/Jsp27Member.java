package tw.ming.javabeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jsp27Member {
	private String account,passwd,realname;
	private String sql1="INSERT INTO member (account,passwd,realname) VALUES (?,?,?)";
	private Connection conn;
	private PreparedStatement pstmt;
	public Jsp27Member()throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String name) {
		this.account = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public boolean newInsert() throws Exception{
		 pstmt = conn.prepareStatement(sql1);
		 pstmt.setString(1, account);
		 pstmt.setString(2, passwd);
		 pstmt.setString(3,realname);
		 int n = pstmt.executeUpdate();
		 return n>0;
	}
	
	public boolean isValidMember() throws SQLException {
		String sql = "SELECT * FROM member WHERE account=? AND passwd=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, account);
		pstmt.setString(2, passwd);
		ResultSet rs = pstmt.executeQuery();
		boolean ret = rs.next();
		if(ret) {
			realname = rs.getString("realname");
		}
		return ret;
	} 
	
}
