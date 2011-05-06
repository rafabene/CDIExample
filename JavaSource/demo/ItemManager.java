package demo;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import demo.domain.Item;
import demo.domain.ItemRepository;
import demo.infrastructure.qualifiers.Example;

@Named("itemManager")
@RequestScoped
public class ItemManager  {
	
	
	private final ItemRepository itemRepository;
	
	@Inject
	public ItemManager(@Example ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	public void execute(){
		FacesContext fc = FacesContext.getCurrentInstance();
		List<Item> items = itemRepository.getAllItems();
		for (Item item: items){
			fc.addMessage(null, new FacesMessage("Item: " + item));
		}
	}

}
