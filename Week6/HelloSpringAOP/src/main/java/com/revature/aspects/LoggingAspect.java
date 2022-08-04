package com.revature.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component //once again making a class a Spring Bean
@Aspect //This Class is an ASPECT. We will handle all of our Logging functionality here.
//It's so much cleaner in the long run to put all of our log stuff in one place, which is the point of SpringAOP.
public class LoggingAspect {

	
	
}
