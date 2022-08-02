package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.User;

public class Launcher {

	public static void main(String[] args) {
		
		//Create an ApplicationContext Spring Container Object. It will manage our beans!
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//we are instantiating a new ApplicationContext to hold our Spring Beans
		//in order to configure it, we need to tell it where our applicationContext.xml (or txt) is.
		
		
		//Now that we have a Spring Container^^^^ we can make some User and Account beans
		
		//we are calling our ApplicationContext and attempting to get a User bean
		User u = ac.getBean(User.class);
		
		//let's take a look at what our User bean looks like
		System.out.println(u);
		//we got a User object... but... nowhere did I create an Account object to attach to it
		//This is the power of autowiring with @Autowired. Spring did it for us :)
		
		//we can give our User Bean some values
		u.id = 1;
		u.name = "Steve";
		u.account.balance = 3000000;
		u.account.type = "Savings";
		
		//User u should have fully initialized data now
		System.out.println(u);
		
	
		System.out.println("===================================(Messing with Bean Scopes)");
		
		//recall that Beans are singletons by default - there can only be one instance of each Bean
		User u2 = ac.getBean(User.class);
		
		System.out.println(u2);
		
		//try to give the User a new value
		u2.name = "Bono";
		
		//the value will change....
		System.out.println(u2);
		
		//across ALL user objects (singleton!!!)
		System.out.println(u);
		
		//If you're reading this, we changed the User Scope to "prototype" so that there can be unique instances
		
		//BUT BEN, why is the Account data the same between both Users?
		//Account is still SiNgLeToN sCoPeD!!! so there will still only be one instance.
		
	}
	
}
