package com.skillstorm.nextgen;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import com.skillstorm.nextgen.data.UserDAO;
import com.skillstorm.nextgen.pojo.User;;


public class UserDAOTest {
	
	
	@Test
	public void testFindByUserId() {
		
		UserDAO dao = new UserDAO();
		User user = dao.findByUserId(7);
		
		String actuals="Line : 17 None";
		
		if(user != null)
		{
		actuals = user.getUserName(); 
		}
		
		String expecteds = "jwilliams";
		
		System.out.println(actuals);
		 Assert.assertEquals(expecteds, actuals);
	}
	
	@Test
	public void testfindByUserName() {
		UserDAO dao = new UserDAO();
		User user = dao.findByUserName("pann");
		
		String actuals="Line : 17 None";
		
		if(user != null)
		{
		actuals = user.getFirstName(); 
		}
		
		String expecteds = "Pepper";
		
		System.out.println(actuals);
		 Assert.assertEquals(expecteds, actuals);
	}
	
	
	@Test
	public void testfindAll() {
		UserDAO dao = new UserDAO();
		List<User> users = dao.findAll();
		
		String actuals="Line : 17 None";
		
		if(users != null)
		{
		actuals = users.get(6).getFirstName().toString();
		
		String expecteds = "Pepper";
		
		
		System.out.println(users);
		System.out.println(actuals);
		 Assert.assertEquals(expecteds, actuals);
	}

}
	}
