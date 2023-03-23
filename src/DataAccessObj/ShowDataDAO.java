package DataAccessObj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Util.StringUtil;
import model.ShowData;

public class ShowDataDAO {

	/**
	 * Show Data Add
	 * @param con
	 * @param showData
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, ShowData showData) throws Exception {
		String sql = "insert into tvshow values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, showData.getShowID());
		pstat.setString(2, showData.getShowTitle());
		pstat.setString(3, showData.getDescription());
		pstat.setInt(4,showData.getYear());
		pstat.setInt(5,showData.getLength());
		pstat.setInt(6,showData.getSeason());
		pstat.setString(7,showData.getIMDBid());
		pstat.setDouble(8,showData.getPopularity());

		return pstat.executeUpdate();
	}
	
	/**
	 * Search Show
	 * @param con
	 * @param showData
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, ShowData showData) throws Exception {
		StringBuffer sb = new StringBuffer("select * from tvshow");
		if (StringUtil.isNotEmpty(showData.getShowTitle())) {
			sb.append(" and title like '%" + showData.getShowTitle() + "%'");
		}
		PreparedStatement pstat = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstat.executeQuery();
	}
	
	/**
	 * delete Show Data
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con, String id) throws Exception {
		String sql = "delete from tvshow where showId = ?";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, id);
		return pstat.executeUpdate();
	}
	
	/**
	 * updata show data
	 * @param con
	 * @param showData
	 * @return
	 * @throws Exception
	 */
	public int updata(Connection con, ShowData showData) throws Exception {
		String sql = "update tvshow set title = ?, description = ?, year = ?, length = ?, season = ?, IMDBid = ?, popularity = ? where showId = ?";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, showData.getShowTitle());
		pstat.setString(2, showData.getDescription());
		pstat.setInt(3, showData.getYear());
		pstat.setInt(4, showData.getLength());
		pstat.setInt(5, showData.getSeason());
		pstat.setString(6, showData.getIMDBid());
		pstat.setDouble(7, showData.getPopularity());
		pstat.setString(8, showData.getShowID());
		return pstat.executeUpdate();
	}
}
