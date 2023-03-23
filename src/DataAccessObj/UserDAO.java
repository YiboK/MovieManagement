package DataAccessObj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;

/**
 * User DataAccessObj class
 * @author 18223
 *
 */
public class UserDAO {
	
	/**
	 * login check
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(Connection con, User user) throws Exception{
		User resultUser = null;
		String sql="select * from t_user where userName = ? and password = ?";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, user.getUserName());
		pstat.setString(2, user.getPassword());
		ResultSet rs = pstat.executeQuery();
		if (rs.next()) {
			resultUser = new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));

		}
		return resultUser;
	}
}
