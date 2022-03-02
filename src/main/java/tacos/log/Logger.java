package tacos.log;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import tacos.TacoOrder;

@Component
public class Logger {

	@KafkaListener(topics = "tacocloud.orders.topic")
	public void receiveOrderSimulation(TacoOrder order) {
		System.out.println(order.toString());
	}
}
