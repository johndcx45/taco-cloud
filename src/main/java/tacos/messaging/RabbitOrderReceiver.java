package tacos.messaging;

import org.springframework.stereotype.Component;

@Component
public class RabbitOrderReceiver {
	/*
	private RabbitTemplate rabbit;
	private MessageConverter converter;
	@Autowired
	public RabbitOrderReceiver(RabbitTemplate rabbit) {
		this.rabbit = rabbit;
		this.converter = rabbit.getMessageConverter();
	}
	public TacoOrder receiveOrder() {
		Message message = rabbit.receive("taco-broker.order.queue");
		return message != null
				? (TacoOrder) converter.fromMessage(message)
						: null;
	}
	*/
}