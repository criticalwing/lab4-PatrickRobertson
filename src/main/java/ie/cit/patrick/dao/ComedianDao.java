package ie.cit.patrick.dao;

import java.util.List;

import ie.cit.patrick.Comedian;
import ie.cit.patrick.ClassicJoke;

public interface ComedianDao {

	void update(Comedian comedian);
	
	void add(Comedian customer);
	
	void delete(int id);
	
	Comedian getByName(String name);
	
	List<Comedian> findAll();
	
	List<ClassicJoke> findByComedian(String name);
	
	ClassicJoke selectRandomJoke();
	
}
