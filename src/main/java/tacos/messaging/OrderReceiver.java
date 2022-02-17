package tacos.messaging;

import javax.jms.JMSException;

import org.springframework.jms.support.converter.MessageConversionException;

import tacos.TacoOrder;

public interface OrderReceiver {
	TacoOrder receiveOrder() throws MessageConversionException, JMSException;
}
