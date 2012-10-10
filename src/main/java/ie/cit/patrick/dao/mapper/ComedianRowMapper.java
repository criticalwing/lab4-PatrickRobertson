package ie.cit.patrick.dao.mapper;

import ie.cit.patrick.Comedian;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ComedianRowMapper implements RowMapper<Comedian>{

	@Override
	public Comedian mapRow(ResultSet rs, int i) throws SQLException {
		
		Comedian comedian = new Comedian(rs.getInt("id"), rs.getInt("Age"), rs.getString("Name"),
				rs.getString("City"), rs.getString("Country"));
		
		return comedian;
	}
	
	

}
