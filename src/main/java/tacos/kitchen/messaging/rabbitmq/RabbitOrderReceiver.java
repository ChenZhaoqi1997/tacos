package tacos.kitchen.messaging.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import tacos.entity.Order;
import tacos.kitchen.messaging.jms.OrderReceiver;

@Component
public class RabbitOrderReceiver implements OrderReceiver {
    private RabbitTemplate rabbit;

    @Autowired
    public RabbitOrderReceiver(RabbitTemplate rabbit) {
        this.rabbit = rabbit;
    }

    @Override
    public Order receiveOrder() {
        return rabbit.receiveAndConvert("", new ParameterizedTypeReference<Order>() {});
    }
}
