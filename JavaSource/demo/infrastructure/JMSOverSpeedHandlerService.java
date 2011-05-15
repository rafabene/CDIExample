package demo.infrastructure;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;

import demo.domain.Item;
import demo.domain.OverSpeedHandlerService;

@RequestScoped
public class JMSOverSpeedHandlerService implements OverSpeedHandlerService {
	
	
	public void observeEvent(@Observes Item item){
		handle(item);
	}

	@PostConstruct
	public void openJMSConnection(){
		System.out.println("Connecting to JMS");
	}

	@Override
	public void handle(Item item) {
		System.out.println("Posting " + item + " to Queue");

	}
	
	@PreDestroy
	public void closeJMSConnection(){
		System.out.println("Closing JMS connection");
	}

}
