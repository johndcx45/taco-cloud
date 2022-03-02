package tacos.messaging;

import org.springframework.stereotype.Component;

@Component
public class RabbitOrderMessagingService /*implements OrderMessagingService*/ {
/*
	private RabbitTemplate rabbit;
	
	@Autowired
	public RabbitOrderMessagingService(RabbitTemplate rabbit) {
		this.rabbit = rabbit;
	}
	
	@Override
	public void send(TacoOrder order) {
		MessageConverter converter = rabbit.getMessageConverter();
		MessageProperties props = new MessageProperties();
		props.setHeader("X_ORDER_SOURCE", "WEB");
		Message message = converter.toMessage(order, props);
		rabbit.send("tacocloud.order", "kitchen.central", message);
	}
	*/
}
