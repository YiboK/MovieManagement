package DataAccessObj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Util.StringUtil;
import model.HasMData;

public class HasMDataDAO {

	
	/**
	 * Actor Data Add
	 * @param con
	 * @param ActorData
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, HasMData hasMData) throws Exception {
		String sql = "insert into hasm values(?,?)";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, hasMData.getMovieID());
		pstat.setString(2, hasMData.getScoreID());
		
		return pstat.executeUpdate();
	}
	
	/**
	 * Search Actor
	 * @param con
	 * @param ActorData
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, HasMData hasMData) throws Exception {
		StringBuffer sb = new StringBuffer("select * from hasm");
		if (StringUtil.isNotEmpty(hasMData.getMovieID())) {
			sb.append(" and MovieID like '%" + hasMData.getMovieID() + "%'");
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
		String sql = "delete from hasm where MovieId = ?";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, id);
		return pstat.executeUpdate();
	}
	

	/**public int updata(Connection con, HasMData hasMData) throws Exception {
		String sql = "update t_hasMData set MovieID = ?, ScoreID = ?";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, hasMData.getMovieID());
		pstat.setString(2, hasMData.getScoreID());
		return pstat.executeUpdate();
	}*/
}
