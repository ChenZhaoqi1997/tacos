package tacos.messaging.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tacos.entity.Order;
import tacos.messaging.jms.OrderMessagingService;

@Service
public class KafkaOrderMessagingService implements OrderMessagingService {
    private KafkaTemplate<String, Order> kafka;

    @Autowired
    public KafkaOrderMessagingService(KafkaTemplate<String, Order> kafka) {
        this.kafka = kafka;
    }

    @Override
    public void sendOrder(Order order) {
        kafka.send("", order);
    }
}
