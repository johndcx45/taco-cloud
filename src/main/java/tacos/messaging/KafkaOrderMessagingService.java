package tacos.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import tacos.TacoOrder;

@Component
public class KafkaOrderMessagingService implements OrderMessagingService {

	private KafkaTemplate<Long, TacoOrder> kafkaTemplate;
	
	@Autowired
	public KafkaOrderMessagingService(KafkaTemplate<Long, TacoOrder> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	@Override
	public void send(TacoOrder order) {
		kafkaTemplate.send("tacocloud.orders.topic", order);
	}
}
