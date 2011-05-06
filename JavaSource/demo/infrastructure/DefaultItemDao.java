package demo.infrastructure;

import java.util.ArrayList;
import java.util.List;

import demo.domain.Item;
import demo.domain.ItemRepository;
import demo.infrastructure.qualifiers.Example;

@Example
public class DefaultItemDao implements ItemRepository {

	@Override
	public List<Item> getAllItems() {
		List<Item> result = new ArrayList<Item>();
		result.add(new Item(38, 40));
		result.add(new Item(42, 40));
		result.add(new Item(38, 60));
		result.add(new Item(120, 60));
		result.add(new Item(120, 100));
		return result;
	}

}
