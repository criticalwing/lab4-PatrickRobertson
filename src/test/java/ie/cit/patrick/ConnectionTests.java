package ie.cit.patrick;

import static org.junit.Assert.*;
import ie.cit.patrick.dao.ComedianDao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4. SpringJUnit4ClassRunner;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "classpath:ie/cit/patrick/application-config.xml" } )

public class ConnectionTests {


	@Autowired
	ApplicationContext context;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testTheApplicationContextConnection() {
		Comedian h = (Comedian)context.getBean("Bob");
		
		String expected = "Bob Hope";
		
		String actual = h.getName().toString();
		
		assertEquals(expected, actual);

	}
	
	public void testDatabaseConnection(){
		
		ApplicationContext context;
		ComedianDao comedianDao;
		
		context = new ClassPathXmlApplicationContext("classpath:/ie/cit/patrick/application-config.xml");
		comedianDao = (ComedianDao)context.getBean("comedianDao");		
		
		Comedian bob = comedianDao.getByName("Bob Hope");
		
		String expected = "Hi, I'm Bob Hope and I'm from Los Angeles USA! Would you believe I'm only 120 years old!";
		
		String actual = "Hi, I'm " + bob.getName() + " and I'm from " + bob.getCity() + 
				" " + bob.getCountry() + "! Would you believe I'm only " + bob.getAge() + " years old?";
		
		assertEquals(expected, actual);
		
	}
	
	
}
