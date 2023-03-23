package DataAccessObj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Util.StringUtil;
import model.ActMData;

public class ActMDataDAO {
	
	/**
	 * Actor Data Add
	 * @param con
	 * @param ActorData
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, ActMData actMData) throws Exception {
		String sql = "insert into actm values(?,?,?)";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, actMData.getPersonID());
		pstat.setString(2, actMData.getMovieID());
		pstat.setString(3, actMData.getCnameM());
		
		return pstat.executeUpdate();
	}
	
	/**
	 * Search Actor
	 * @param con
	 * @param ActorData
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, ActMData actMData) throws Exception {
		StringBuffer sb = new StringBuffer("select * from actm");
		if (StringUtil.isNotEmpty(actMData.getPersonID())) {
			sb.append(" and PersonID like '%" + actMData.getPersonID() + "%'");
		}
		PreparedStatement pstat = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstat.executeQuery();
	}
	
	/**
	 * delete Actor Data
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con, String id) throws Exception {
		String sql = "delete from actm where PersonID = ?";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, id);
		return pstat.executeUpdate();
	}
	
	public int updata(Connection con, ActMData actMData) throws Exception {
		String sql = "update actm set cnameM = ? where PersonID = ?";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, actMData.getCnameM());
		pstat.setString(2, actMData.getPersonID());
		return pstat.executeUpdate();
	}
}
