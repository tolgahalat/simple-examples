package tolgstoy.lambdaexpression;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DiscountService {
    private Map<String, Function<Double, Double>> discountStrategies = new HashMap<>();

    public DiscountService() {
        discountStrategies.put("SUMMER_SALE", price -> price * 0.9);
        discountStrategies.put("WINTER_SALE", price -> price * 0.8);
    }

    public double applyDiscount(String discountCode, double price) {
        return discountStrategies.getOrDefault(discountCode, Function.identity()).apply(price);
    }

}
