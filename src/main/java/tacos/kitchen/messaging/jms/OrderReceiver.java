package tacos.kitchen.messaging.jms;

import tacos.entity.Order;

public interface OrderReceiver {
    Order receiveOrder();
}
