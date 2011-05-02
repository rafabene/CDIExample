package demo;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class MyFirstCDIBean {

	public String getHelloWorldMessage(){
		return "Hello World from a CDI Bean";
	}
}
