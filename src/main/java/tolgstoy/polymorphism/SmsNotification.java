package tolgstoy.polymorphism;

public class SmsNotification implements Notification{
    @Override
    public void send(String message) {
        // SMS sending logic
        System.out.println("Sending SMS: " + message);
    }

}
