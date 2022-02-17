package tacos.messaging;

import tacos.TacoOrder;

public interface OrderMessagingService {

	void send(TacoOrder order);
}
