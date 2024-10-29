package tolgstoy.polymorphism;

import java.util.List;

public class NotificationService {
    private final List<Notification> notifications;

    public NotificationService(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public void notifyAll(String message) {
        for (Notification notification : notifications) {
            notification.send(message);
        }
    }

}
