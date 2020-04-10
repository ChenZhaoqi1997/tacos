package tacos.kitchen.messaging.rabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import tacos.entity.Order;

@Component
public class OrderListener {
    @RabbitListener(queues = "")
    public void receiveOrder(Order order) {
        return;
    }
}
