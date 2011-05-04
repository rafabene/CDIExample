package demo.infrastructure;

import java.util.ArrayList;
import java.util.List;

import demo.domain.Item;
import demo.domain.ItemRepository;

public class AnotherItemDao implements ItemRepository {

	@Override
	public List<Item> getAllItems() {
		List<Item> result = new ArrayList<Item>();
		result.add(new Item(160, 120));
		return result;
	}

}
