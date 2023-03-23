package DataAccessObj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Util.StringUtil;
import model.HasTData;

public class HasTDataDAO {
	
	/**
	 * Actor Data Add
	 * @param con
	 * @param ActorData
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, HasTData hasTData) throws Exception {
		String sql = "insert into hast values(?,?)";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, hasTData.getShowID());
		pstat.setString(2, hasTData.getScoreID());
		
		return pstat.executeUpdate();
	}
	
	/**
	 * Search Actor
	 * @param con
	 * @param ActorData
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, HasTData hasTData) throws Exception {
		StringBuffer sb = new StringBuffer("select * from hast");
		if (StringUtil.isNotEmpty(hasTData.getShowID())) {
			sb.append(" and ShowID like '%" + hasTData.getShowID() + "%'");
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
		String sql = "delete from hast where ShowID = ?";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, id);
		return pstat.executeUpdate();
	}
	
	
	/**public int updata(Connection con, HasTData hasTData) throws Exception {
		String sql = "update t_hasTData set ShowID = ?, ScoreID = ?";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, hasTData.getShowID());
		pstat.setString(2, hasTData.getScoreID());
		return pstat.executeUpdate();
	}*/
}
