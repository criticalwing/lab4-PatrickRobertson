package ie.cit.patrick.dao.mapper;

import ie.cit.patrick.ClassicJoke;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class JokeRowMapper implements RowMapper<ClassicJoke>{

	@Override
	public ClassicJoke mapRow(ResultSet rs, int i) throws SQLException {
		ClassicJoke joke = new ClassicJoke(rs.getString("Question"), rs.getString("Punch Line"));
		return joke;
	}

}
