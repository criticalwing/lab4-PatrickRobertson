package ie.cit.patrick;

import static org.junit.Assert.*;
import ie.cit.patrick.dao.ComedianDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4. SpringJUnit4ClassRunner;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "classpath:ie/cit/patrick/application-config.xml" } )


public class UpdateTests {
	
	@Autowired
	ApplicationContext context;
	@Autowired
	ComedianDao comedianDao;

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testFindComedian(){
		
		Comedian y = comedianDao.getByName("Bob Hope");

		assertEquals("USA", y.getCountry());
		
	}
	
	@Test
	public void testAddComedian(){
		
		Comedian x = new Comedian(10,"Tester", "Cork", "Ireland");
		comedianDao.add(x);
		
		Comedian y = comedianDao.getByName("Tester");
		
		assertEquals(x.getName(),y.getName());
		
		
	}
	
	@Test
	public void testUpdateComedian(){
		
		Comedian y = comedianDao.getByName("Tester");
		Comedian z = comedianDao.getByName("Tester");
		
		assertEquals(y,z);
		
		z.setAge(99);
		
		assertTrue(z.getAge()>y.getAge());
		
		comedianDao.update(z);
		
		Comedian a = comedianDao.getByName("Tester");
		
		assertEquals(99, a.getAge());			
	}
	
	
	@Test
	public void testRemoveComedian(){
		
		comedianDao.deleteByName("Tester");
		
		assertNull(comedianDao.getByName("Tester"));
		
		
	}
	

	
	
}
