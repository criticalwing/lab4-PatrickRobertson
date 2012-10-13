package ie.cit.patrick.dao;

import java.util.List;

import ie.cit.patrick.Comedian;

public interface ComedianDao {

	void update(Comedian comedian);
	
	void add(Comedian customer);
	
	void deleteByName(String Name);
	
	Comedian getByName(String name);
	
	List<Comedian> findAll();
	
}
