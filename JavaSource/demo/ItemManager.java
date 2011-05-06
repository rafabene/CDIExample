package demo;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import demo.domain.Item;
import demo.domain.ItemRepository;
import demo.domain.SpeedVerifierService;
import demo.infrastructure.qualifiers.Example;

@ManagedBean
@RequestScoped
public class ItemManager {
	
	@Inject
	@Example
	private ItemRepository itemRepository;
	
	@Inject
	private SpeedVerifierService speedVerifierService;
	
	public void execute(){
		FacesContext fc = FacesContext.getCurrentInstance();
		List<Item> items = itemRepository.getAllItems();
		for (Item item: items){
			fc.addMessage(null, 
					new FacesMessage("Item Speed: " + item.getSpeed() + "/" + item.getSpeedLimit() + 
							" - Above Speed Limit: " + speedVerifierService.isSpeedAboveLimit(item)));
		}
	}
}
