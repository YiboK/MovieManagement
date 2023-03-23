package DataAccessObj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Util.StringUtil;
import model.ActorData;

public class ActorDataDAO {

	/**
	 * Actor Data Add
	 * @param con
	 * @param ActorData
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, ActorData ActorData) throws Exception {
		String sql = "insert into actor values(?,?)";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, ActorData.getActorID());
		pstat.setString(2, ActorData.getActorName());
		
		return pstat.executeUpdate();
	}
	
	/**
	 * Search Actor
	 * @param con
	 * @param ActorData
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, ActorData ActorData) throws Exception {
		StringBuffer sb = new StringBuffer("select * from actor");
		if (StringUtil.isNotEmpty(ActorData.getActorID())) {
			sb.append(" and personid like '%" + ActorData.getActorID() + "%'");
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
		String sql = "delete from actor where personid = ?";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, id);
		return pstat.executeUpdate();
	}
	
	/**
	 * update Actor data
	 * @param con
	 * @param ActorData
	 * @return
	 * @throws Exception
	 */
	public int updata(Connection con, ActorData ActorData) throws Exception {
		String sql = "update actor set name = ? where personid = ?";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, ActorData.getActorName());
		pstat.setString(2, ActorData.getActorID());
		return pstat.executeUpdate();
	}
}
