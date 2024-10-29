package tolgstoy.enumusage;

public class OrderService {
    public void processOrder(OrderStatus status) {
        status.handle();
    }
}
