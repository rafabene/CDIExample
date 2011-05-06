package demo.infrastructure;

import javax.enterprise.inject.Alternative;

import demo.domain.Item;
import demo.domain.SpeedVerifierService;

@Alternative
public class DefaultSpeedVerifierService implements SpeedVerifierService {

	@Override
	public boolean isSpeedAboveLimit(Item item) {
		return item.getSpeed() > item.getSpeedLimit();
	}

}
