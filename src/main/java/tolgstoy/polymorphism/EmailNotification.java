package tolgstoy.polymorphism;

public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        // Email sending logic
        System.out.println("Sending email: " + message);
    }
}
