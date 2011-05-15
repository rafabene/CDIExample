package demo;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import demo.domain.Item;
import demo.domain.ItemRepository;
import demo.domain.OverSpeedHandlerService;
import demo.domain.SpeedVerifierService;
import demo.infrastructure.qualifiers.Example;
import demo.infrastructure.qualifiers.Notifier;

@Named("itemManager")
@RequestScoped
public class ItemManager {
	
	@Inject
	@Example
	private ItemRepository itemRepository;
	
	@Inject
	private SpeedVerifierService speedVerifierService;
	
	@Inject
	@Notifier
	private OverSpeedHandlerService overSpeedHandlerService;
	
	public void execute(){
		FacesContext fc = FacesContext.getCurrentInstance();
		List<Item> items = itemRepository.getAllItems();
		for (Item item: items){
			fc.addMessage(null, 
					new FacesMessage("Item Speed: " + item.getSpeed() + "/" + item.getSpeedLimit() + 
							" - Above Speed Limit: " + speedVerifierService.isSpeedAboveLimit(item)));
			if (speedVerifierService.isSpeedAboveLimit(item)){
				overSpeedHandlerService.handle(item);
			}
		}
	}
}
