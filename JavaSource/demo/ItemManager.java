package demo;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import demo.domain.Item;
import demo.domain.ItemRepository;

@ManagedBean
@RequestScoped
public class ItemManager {
	
	@Inject
	private ItemRepository itemRepository;
	
	public void execute(){
		FacesContext fc = FacesContext.getCurrentInstance();
		List<Item> items = itemRepository.getAllItems();
		for (Item item: items){
			fc.addMessage(null, new FacesMessage("Item: " + item));
		}
	}

}
