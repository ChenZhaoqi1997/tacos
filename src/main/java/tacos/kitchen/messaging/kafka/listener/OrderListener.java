package tacos.kitchen.messaging.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tacos.entity.Order;

@Component
public class OrderListener {
    @KafkaListener(topics = "")
    public void handle(Order order) {
        return;
    }
}
