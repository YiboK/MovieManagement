package Util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * database tool class
 * @author 18223
 *
 */
public class DbUtil {

	private String dbUrl = "jdbc:mysql://localhost:3306/NewIMDB";
	private String dbUserName = "root";
	private String dbPassword = "kyb20011009!";
	private String jdbcName= "com.mysql.cj.jdbc.Driver";  
	
	/**
	 * get database connection
	 * @return
	 * @throws Exception
	 */
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		return con;
	}
	
	/**
	 * close database connection
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con)throws Exception{
		if(con!=null) 
			con.close();
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("database connectioned!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("database connection failed");
		}
	}
}
