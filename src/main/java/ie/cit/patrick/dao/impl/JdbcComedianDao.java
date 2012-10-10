package ie.cit.patrick.dao.impl;

import java.util.List;

import ie.cit.patrick.ClassicJoke;
import ie.cit.patrick.Comedian;
import ie.cit.patrick.dao.ComedianDao;
import ie.cit.patrick.dao.mapper.ComedianRowMapper;
import ie.cit.patrick.dao.mapper.JokeRowMapper;

import javax.sql.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcComedianDao implements ComedianDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcComedianDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
	}

	@Override
	public void update(Comedian comedian) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Comedian comedian) {

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Comedian getByName(String name) {
		
		try {
			return jdbcTemplate.queryForObject(
				"SELECT * FROM comedians WHERE Name = ?", 
				new ComedianRowMapper(), name);
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Comedian> findAll() {
		
		try {
			return jdbcTemplate.query("SELECT * FROM comedians", new ComedianRowMapper());
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}

	}
	
	public List<ClassicJoke> findByComedian(String name){

		try {
					return jdbcTemplate.query("SELECT * FROM jokes WHERE comedian = ?", new JokeRowMapper(), name);
			}
		catch (EmptyResultDataAccessException e) {
					return null;
			}		

		
	}
	
	public ClassicJoke selectRandomJoke(){
		
		try {
			List<ClassicJoke> jokes = jdbcTemplate.query("SELECT * FROM jokes", new JokeRowMapper());
			double y = Math.random()*jokes.size();
			return jokes.get((int) y);
	}
		catch (EmptyResultDataAccessException e) {
			return null;
	}	
}

}
