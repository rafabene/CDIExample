	package demo.infrastructure;

import javax.enterprise.inject.Alternative;

import demo.domain.Item;
import demo.domain.SpeedVerifierService;

@Alternative
public class TolerantSpeedVerifierService implements SpeedVerifierService {

	@Override
	public boolean isSpeedAboveLimit(Item item) {
		return item.getSpeed() > (item.getSpeedLimit() * 1.2);
	}

}
