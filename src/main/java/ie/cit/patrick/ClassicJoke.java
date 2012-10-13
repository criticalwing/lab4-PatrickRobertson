package ie.cit.patrick;

public class ClassicJoke implements Joke{
	
	private String question, punchline;
	private int id;
	
	public ClassicJoke(){
		
	}
	
	public ClassicJoke(String question, String punchline, int id) {
		super();
		this.question = question;
		this.punchline = punchline;
		this.id = id;
	}

	public ClassicJoke(String question, String punchline) {
		super();
		this.question = question;
		this.punchline = punchline;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getPunchline() {
		return punchline;
	}

	public void setPunchline(String punchline) {
		this.punchline = punchline;
	}

	public void tell(){
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return question + "\n" + punchline;
	}

	@Override
	public String getString() {
		return toString();
	}
	
	

}
