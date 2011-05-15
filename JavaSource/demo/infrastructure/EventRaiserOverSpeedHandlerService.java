package demo.infrastructure;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import demo.domain.Item;
import demo.domain.OverSpeedHandlerService;
import demo.infrastructure.qualifiers.Notifier;


@Notifier
public class EventRaiserOverSpeedHandlerService implements OverSpeedHandlerService {
	
	@Inject
	private Event<Item> event;

	@Override
	public void handle(Item item) {
		System.out.println("Invalid Item found. Notifying Event");
		event.fire(item);
	}

}
