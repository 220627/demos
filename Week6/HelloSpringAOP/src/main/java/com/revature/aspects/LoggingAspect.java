package com.revature.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component //once again making a class a Spring Bean
@Aspect //This Class is an ASPECT. We will handle all of our Logging functionality here.
//It's so much cleaner in the long run to put all of our log stuff in one place, which is the point of SpringAOP.
public class LoggingAspect {

	//A Logger object... so we can do Logging.
	private static Logger log = LogManager.getLogger();
	
	//in an Aspect, we have methods called ADVICES. Each "advice" will be responsible for logging certain things.
	
	//This advice will run some logs BEFORE any method in our models package runs.
	//this happens thanks to the within() and the name of the package you want to scan
	//"Before any method in the models package runs, execute this code"
	@Before("within(com.revature.models.*)")
	public void logModelMethods(JoinPoint jp) {//A JoinPoint is where an advice COULD be injected. In this case, models
		
		//getTarget() returns the object getting called. 
		//getSignature() returns the method signature getting called.
		log.info(jp.getTarget() + " invoked " + jp.getSignature());
		
	}
	
	
	
}
