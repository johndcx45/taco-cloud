package tacos.log;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import tacos.TacoOrder;

@Component
public class Logger {

	@JmsListener(destination =  "taco-broker.order.queue")
	public void receiveOrderSimulation(TacoOrder order) {
		System.out.println(order.toString());
	}
}
