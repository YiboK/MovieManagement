package DataAccessObj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Util.StringUtil;
import model.MovieData;

/**
 * Movie Data DAO Class
 * @author 18223
 *
 */
public class MovieDataDAO {

	/**
	 * Movie Data Add
	 * @param con
	 * @param movieData
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, MovieData movieData) throws Exception {
		String sql = "insert into movie values(?,?,?,?,?,?,?)";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, movieData.getMovieID());
		pstat.setString(2, movieData.getMovieTitle());
		pstat.setString(3, movieData.getDescription());
		pstat.setInt(4,movieData.getYear());
		pstat.setInt(5,movieData.getRuntime());
		pstat.setString(6,movieData.getIMDBid());
		pstat.setDouble(7,movieData.getPopularity());

		return pstat.executeUpdate();
	}
	
	/**
	 * Search Movie
	 * @param con
	 * @param movieData
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, MovieData movieData) throws Exception {
		StringBuffer sb = new StringBuffer("select * from movie");
		if (StringUtil.isNotEmpty(movieData.getMovieTitle())) {
			sb.append(" and title like '%" + movieData.getMovieTitle() + "%'");
		}
		PreparedStatement pstat = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstat.executeQuery();
	}
	
	/**
	 * delete Movie Data
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con, String id) throws Exception {
		String sql = "delete from movie where movieId = ?";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, id);
		return pstat.executeUpdate();
	}
	
	/**
	 * updata movie data
	 * @param con
	 * @param movieData
	 * @return
	 * @throws Exception
	 */
	public int updata(Connection con, MovieData movieData) throws Exception {
		String sql = "update movie set title = ?, description = ?, year = ?, runtime = ?, IMDBid = ?, popularity = ? where movieId = ?";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, movieData.getMovieTitle());
		pstat.setString(2, movieData.getDescription());
		pstat.setInt(3, movieData.getYear());
		pstat.setInt(4, movieData.getRuntime());
		pstat.setString(5, movieData.getIMDBid());
		pstat.setDouble(6, movieData.getPopularity());
		pstat.setString(7, movieData.getMovieID());
		return pstat.executeUpdate();
	}
}
