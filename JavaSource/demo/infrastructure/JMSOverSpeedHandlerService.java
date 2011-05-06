package demo.infrastructure;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import demo.domain.Item;
import demo.domain.ItemRepository;
import demo.domain.OverSpeedHandlerService;

public class JMSOverSpeedHandlerService implements OverSpeedHandlerService {
	
	@Inject
	private ItemRepository itemRepository;
	
	@PostConstruct
	public void openJMSConnection(){
		System.out.println("Connecting to JMS");
	}

	@Override
	public void handle(Item item) {
		System.out.println(itemRepository.getClass());
		System.out.println("Posting " + item + " to Queue");

	}
	
	@PreDestroy
	public void closeJMSConnection(){
		System.out.println("Closing JMS connection");
	}

}
