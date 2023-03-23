package DataAccessObj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Util.StringUtil;
import model.ActTData;

public class ActTDataDAO {
	/**
	 * Actor Data Add
	 * @param con
	 * @param ActorData
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, ActTData actTData) throws Exception {
		String sql = "insert into actt values(?,?,?)";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, actTData.getPersonID());
		pstat.setString(2, actTData.getShowID());
		pstat.setString(3, actTData.getCnameT());
		
		return pstat.executeUpdate();
	}
	
	/**
	 * Search Actor
	 * @param con
	 * @param ActorData
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, ActTData actTData) throws Exception {
		StringBuffer sb = new StringBuffer("select * from actt");
		if (StringUtil.isNotEmpty(actTData.getPersonID())) {
			sb.append(" and PersonID like '%" + actTData.getPersonID() + "%'");
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
		String sql = "delete from actt where PersonID = ?";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, id);
		return pstat.executeUpdate();
	}
	
	public int updata(Connection con, ActTData actTData) throws Exception {
		String sql = "update actt set cnameT = ? where PersonID = ?";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, actTData.getCnameT());
		pstat.setString(2, actTData.getPersonID());
		return pstat.executeUpdate();
	}
}