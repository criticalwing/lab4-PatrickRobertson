package ie.cit.patrick.consoleapp;

import ie.cit.patrick.ClassicJoke;
import ie.cit.patrick.Comedian;
import ie.cit.patrick.dao.ComedianDao;
import ie.cit.patrick.dao.JokeDao;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComedianPerformApp {

	static ApplicationContext context;
	static ComedianDao comedianDao;
	static JokeDao jokeDao;
	
	public static void main(String[] args){
		
		context = new ClassPathXmlApplicationContext("classpath:/ie/cit/patrick/application-config.xml");
		comedianDao = (ComedianDao)context.getBean("comedianDao");
		jokeDao = (JokeDao)context.getBean("jokeDao");
		
		
		List<Comedian> comedians = comedianDao.findAll();
		
		for (Comedian x : comedians){
			
			System.out.println( "Hi, I'm " + x.getName() + " and I'm from " + x.getCity() + 
					" " + x.getCountry() + "! Would you believe I'm only " + x.getAge() + " years old?\n");
			
			List<ClassicJoke> jokes = jokeDao.findByComedian(x.getName());
			
			for(ClassicJoke y : jokes){
				
				y.tell();
				System.out.println();
			}
			// If it's the last comedian they tell one more random Joke
			
			if(comedians.indexOf(x) == comedians.size()-1){
				
				jokeDao.selectRandomJoke().tell();
				
			}
			
			
			System.out.println("#########################");
			
			
		}
		
		
		
		
		
		
		
		
		
	}
	
	
	

}
