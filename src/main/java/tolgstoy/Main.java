package tolgstoy;

import tolgstoy.commandpattern.*;
import tolgstoy.enumusage.*;
import tolgstoy.guardclause.*;
import tolgstoy.lambdaexpression.*;
import tolgstoy.polymorphism.*;
import tolgstoy.strategypattern.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StrategyPattern();
        EnumUsage();
        Polymorphism();
        LambdaExpression();
        CommandPattern();
        GuardClause();
    }

    private static void StrategyPattern() {
        CreditCardPayment creditCardPayment = new CreditCardPayment();
        PaypalPayment paypalPayment = new PaypalPayment();
        List<PaymentStrategy> paymentStrategies = new ArrayList<>();
        paymentStrategies.add(creditCardPayment);
        paymentStrategies.add(paypalPayment);
        PaymentService ps = new PaymentService(paymentStrategies);
        ps.processPayment("CreditCardPayment", 5);
    }

    private static void EnumUsage() {
        OrderService orderService = new OrderService();
        orderService.processOrder(OrderStatus.NEW);
    }

    private static void Polymorphism() {
        EmailNotification emailNotification = new EmailNotification();
        SmsNotification smsNotification = new SmsNotification();
        List<Notification> notifications = new ArrayList<>();
        notifications.add(emailNotification);
        notifications.add(smsNotification);
        NotificationService notificationService = new NotificationService(notifications);
        notificationService.notifyAll("test");
    }

    private static void LambdaExpression() {
        DiscountService discountService = new DiscountService();
        System.out.println(discountService.applyDiscount("SUMMER_SALE", 5));
    }

    private static void CommandPattern() {
        FileSystemReceiver fs = new UnixFileSystemReceiver();
        Command openFileCommand = new OpenFileCommand(fs);
        openFileCommand.execute();
        CloseFileCommand closeFileCommand = new CloseFileCommand(fs);
        closeFileCommand.execute();
    }

    private static void GuardClause() {
        User user = new User();
        user.setName("test name");
        user.setEmail("test email");
        UserService userService = new UserService();
        userService.registerUser(user);
    }
}