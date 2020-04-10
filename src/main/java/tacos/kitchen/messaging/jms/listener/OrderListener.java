package tacos.kitchen.messaging.jms.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import tacos.entity.Order;

@Component
public class OrderListener {
    @JmsListener(destination = "")
    public void receiveOrder(Order order) {
        return;
    }
}
