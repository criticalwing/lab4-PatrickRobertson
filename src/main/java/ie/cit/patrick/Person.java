package ie.cit.patrick;

public class Person {
	
	private int id, age;
	private String name, city, country;
	
	public Person(){
	}
	
	public Person(int age, String name, String city, String country) {

		this.age = age;
		this.name = name;
		this.city = city;
		this.country = country;
	}
	
	public Person(int id, int age, String name, String city, String country) {
		this.id = id;
		this.age = age;
		this.name = name;
		this.city = city;
		this.country = country;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", age=" + age + ", name=" + name
				+ ", city=" + city + ", country=" + country + "]";
	}
	
	
	
	

}
