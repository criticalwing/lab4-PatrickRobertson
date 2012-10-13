package ie.cit.patrick.dao.impl;

import java.util.List;
import ie.cit.patrick.Comedian;
import ie.cit.patrick.dao.ComedianDao;
import ie.cit.patrick.dao.mapper.ComedianRowMapper;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
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
		try{
		jdbcTemplate.update("UPDATE comedians " +
				"SET Name = ?, City = ?, Country = ?, Age = ? " +
				"WHERE id = ?", comedian.getName(), comedian.getCity(), comedian.getCountry(), comedian.getAge(), comedian.getId());
		} catch (DataAccessException e){
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void add(Comedian comedian) {
		try{
		jdbcTemplate.update("INSERT INTO comedians (`id`, `Name`, `City`, `Country`, `Age`) VALUES (NULL, ?, ?, ?, ?)",
				comedian.getName(), comedian.getCity(), comedian.getCountry(), comedian.getAge());
		} catch (DataAccessException e){
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void deleteByName(String name) {
		try{
		jdbcTemplate.update("DELETE FROM comedians WHERE Name = ?", name);
		} catch (DataAccessException e){
			System.out.println(e.getMessage());
		}
		
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
	
}
