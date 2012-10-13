package ie.cit.patrick.dao.impl;

import java.util.List;

import ie.cit.patrick.ClassicJoke;
import ie.cit.patrick.dao.JokeDao;
import ie.cit.patrick.dao.mapper.JokeRowMapper;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcJokeDao implements JokeDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcJokeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
	}
	
	@Override
	public void update(ClassicJoke joke) {
		try{
		jdbcTemplate.update("UPDATE jokes " +
				"SET Question = ?, Punch Line = ?, comedian = ?" +
				"WHERE id = ?", joke.getQuestion(), joke.getPunchline(), joke.getId());
		} catch (DataAccessException e){
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void add(ClassicJoke joke) {
		try{
		jdbcTemplate.update("INSERT INTO jokes ('id','Question','Punch Line')" +
				"VALUES (NULL, ?, ?, ?)", joke.getQuestion(), joke.getPunchline(), joke.getId());
		} catch (DataAccessException e){
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void deleteById(int id) {
		try{
		jdbcTemplate.update("DELETE FROM jokes WHERE id = ?", id);
		} catch (DataAccessException e){
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public List<ClassicJoke> findAll() {
		
		try {
			return jdbcTemplate.query("SELECT * FROM jokes", new JokeRowMapper());
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	@Override
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
