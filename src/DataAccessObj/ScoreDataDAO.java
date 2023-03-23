package DataAccessObj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Util.StringUtil;
import model.ScoreData;

public class ScoreDataDAO {
	
	/**
	 * show Data Add
	 * @param con
	 * @param showData
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, ScoreData scoreData) throws Exception {
		String sql = "insert into imdb values(?,?,?)";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, scoreData.getIMDBid());
		pstat.setDouble(2, scoreData.getScore());
		pstat.setInt(3, scoreData.getVotes());
		
		return pstat.executeUpdate();
	}
	
	/**
	 * Search show
	 * @param con
	 * @param showData
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, ScoreData scoreData, String movieTitle) throws Exception {
		StringBuffer sb = new StringBuffer("SELECT i.`IMDBid`, m.`title`, i.`Score`, i.`Votes` FROM movie m, imdb i, hasm hm "
				+ "WHERE m.`MovieID` = hm.`MovieID` AND m.`IMDBid` = i.`IMDBid`");
		if (StringUtil.isNotEmpty(movieTitle)){  //Error!!!!
			sb.append(" AND m.`title` LIKE '%" + movieTitle + "%'");
		}
		PreparedStatement pstat = con.prepareStatement(sb.toString());
		return pstat.executeQuery();
	}
	
	public ResultSet list2(Connection con, ScoreData scoreData, String showTitle) throws Exception {
		StringBuffer sb = new StringBuffer("SELECT i.`IMDBid`, s.`title`, i.`Score`, i.`Votes` FROM tvshow s, imdb i, hast ht "
				+ "WHERE s.`ShowID` = ht.`ShowID` AND s.`IMDBid` = i.`IMDBid`");
		if (StringUtil.isNotEmpty(showTitle)) {
			sb.append(" AND s.`title` LIKE '%" + showTitle + "%'");
		}
		PreparedStatement pstat = con.prepareStatement(sb.toString());
		return pstat.executeQuery();
	}
	
	/**
	 * delete show Data
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con, String id) throws Exception {
		String sql = "delete from imdb where scoreId = ?";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, id);
		return pstat.executeUpdate();
	}
	
	/**
	 * update show data
	 * @param con
	 * @param showData
	 * @return
	 * @throws Exception
	 */
	public int updata(Connection con, ScoreData scoreData) throws Exception {
		String sql = "update imdb set score = ?, votes = ? where IMDBid = ?";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setDouble(1, scoreData.getScore());
		pstat.setInt(2, scoreData.getVotes());
		pstat.setString(3, scoreData.getIMDBid());	
		return pstat.executeUpdate();
	}
}
