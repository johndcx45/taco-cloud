package tacos.messaging;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

	/*
	@Bean
	public MappingJackson2MessageConverter messageConverter() {
		MappingJackson2MessageConverter messageConverter =
				new MappingJackson2MessageConverter();
		messageConverter.setTypeIdPropertyName("_typeId");

		Map<String, Class<?>> typeIdMappings = new HashMap<String, Class<?>>();
		typeIdMappings.put("order", TacoOrder.class);
		messageConverter.setTypeIdMappings(typeIdMappings);

		return messageConverter;
	}


	
	@Bean
	public Jackson2JsonMessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
		 */
}
