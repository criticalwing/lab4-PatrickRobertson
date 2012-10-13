package ie.cit.patrick;

import java.util.List;

public class Comedian extends Person implements Performer{
	
	private List<Joke> jokes;

		
	public Comedian() {
		super();
	}

	public Comedian(int age, String name, String city, String country) {
		super(age, name, city, country);
	}
	
	public Comedian(int id, int age, String name, String city, String country) {
		super(id, age, name, city, country);
	}
	
	public Comedian(int id, int age, String name, String city, String country, List<Joke> jokes){
		super(id, age, name, city, country);
		this.jokes = jokes;	
		
	}
	

	public List<Joke> getJokes() {
		return jokes;
	}

	public void setJokes(List<Joke> jokes) {
		this.jokes = jokes;
	}
	
	public void perform() {
		for (Joke j : jokes){
			System.out.println(j.toString());
		}
	}

}
