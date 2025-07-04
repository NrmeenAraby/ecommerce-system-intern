package ecommerce;

import ecommerce.Shippable;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class ShippingService {
    public static void ship(List<Shippable> items){
        System.out.println("** Shipment notice **");

        Map<String, Integer> itemCount = new HashMap<>();
        Map<String, Double> weightMap = new HashMap<>();
        double totalWeight = 0;

        for(Shippable item:items){
            String name=item.getName();
            double weight=item.getWeight();

            itemCount.put(name, itemCount.getOrDefault(name, 0) + 1);
            weightMap.put(name, weight);
            totalWeight += weight;
        }
        for (String name : itemCount.keySet()) {
            System.out.println(itemCount.get(name) + "x " + name + "      " + (weightMap.get(name) * itemCount.get(name)) + "g");
        }

        totalWeight=totalWeight/1000.0;
        System.out.println("Total package weight: " + totalWeight + "kg");
    }
}
