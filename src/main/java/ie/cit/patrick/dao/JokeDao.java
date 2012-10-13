package ie.cit.patrick.dao;

import ie.cit.patrick.ClassicJoke;
import java.util.List;

public interface JokeDao {
	
	void update(ClassicJoke joke);
	
	void add(ClassicJoke Joke);
	
	void deleteById(int id);
	
	List<ClassicJoke> findAll();
	
	List<ClassicJoke> findByComedian(String name);
	
	ClassicJoke selectRandomJoke();

}
