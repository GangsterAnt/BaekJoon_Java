package codingTest.naverShopping;

import java.util.*;

 /*
    You are ordering pizza for a party. You are given an order (a list of items to buy) and a pizzeria menu (a list of all available items and their prices.)

The pizzeria offers the following discounts :
- discount 1 : buy3, the cheapest one is free
-discount 2 : buy 5 for 100
-discount 3 : for every large pizza get a free small one
-discount 4 : buy 3 large, pay for 3 medium

your goal is to minimize the total cost of the order by using at most one of the discount the pizzeria offers Precise description of ho every discount works can be found in the example section

Assume that the following declarations are given :

class Pizza {
 public String name;
 public int price_S;
 public int price_M;
 public int price_L;
}
class OrderItem {
 public String name;
 public String size;
 public int quantity;
}

The menu is constructed as an array of Pizza objects, where:
-name denotes the name of the pizza : every name appears in the menu array exactly once;
-price_S, price_M, price_L denote the prices for "Small", "Medium", "Large" version of this pizza respectively.

Similarly, the order is constructed as an array of OrderItem objects, where:
-name denotes the name of the pizza you want to order
-size specifies the size of the pizza you want to order ("Small","Medium","Large")
-Every (name, size) pair appears in the order array at most once.
Write function:
class Solution { public int solution (Pizza[] menu, OrderItem[] order); ) }

that, given a menu array of length N and an order array of length M, returns the minimum amount of money you need to pay when using one of the discounts the pizzeria offers (or not using discounts, if non of them is applicable to given order)

Example

Discount 1 : buy 3 the cheapest one is free
When your order contains at least three pizzas (not necessarily different), you can choose to not pay for a single cheapest pizza in the whole order.
 you can use this discount at most once per order and you can not split order

menu = [ Pizza(name ="greek", price_S = 7, price_M = 5, price_L =10),
Pizza(name ="texas", price_S = 8, price_M = 9, price_L = 13),
Pizza(name ="european", price_S = 5, price_M = 10 price_L = 13)]

order = [OrderItem(name = "texas", size = "Medium", quantity = 1),
OrderItem(name = "european", size = "Small", quantity = 2)]

your function should return 14, because you pay only for one texas and one european pizza; the other eupropean pizza is free.
Notice that larger pizzas can cost less than smaller pizzas.

Discount 2 :Buy 5 for 100
when your order contains at least five pizzas with the same name, you can choose five of them to cost 100 in total.
As with the previous discount, you can use this one at most once per order and you cannot split your order.

menu = [ Pizza(name ="margherita", price_S = 90, price_M = 80, price_L =100),
Pizza(name ="hawaii", price_S = 80, price_M = 90, price_L = 120),
Pizza(name ="capricciosa", price_S = 50, price_M = 70, price_L = 130),
Pizza(name ="greek", price_S = 50, price_M = 70 price_L = 130)]

order = [OrderItem(name = "greek", size = "Small", quantity = 5),
OrderItem(name = "margherita", size = "Small", quantity = 4),
OrderItem(name = "hawaii", size = "Large", quantity = 1),
OrderItem(name = "margherita", size = "Medium", quantity = 2),
OrderItem(name = "capricciosa", size = "Small", quantity = 7)]

your function should return 900, because you can choose to pay 100 for one "Medium" and four "Small" margherita, and pay the normal price for everything else.
Notice yhat you could use the discount on five greek pizzas or on five capriccioas pizzas, but it would result in a higher total cost. Similarly, you could use "Buy 3, the cheapest one is free" discount, but it would also result in a higher total cost.

Discount3 : for every large pizza get a free small one
When your order contains a "Large" and a "Small" pizza with the same name, you can get the "Small" one for free.
You can use this discount as many times as you want, provided the conditions are met and you are not using any other discount.

menu = [ Pizza(name ="margherita", price_S = 7, price_M = 8, price_L =10),
Pizza(name ="hawaii", price_S = 8, price_M = 9, price_L = 12),
Pizza(name ="capricciosa", price_S = 5, price_M = 7 price_L = 13)]

order = [OrderItem(name = "margherita", size = "Small", quantity = 3),
OrderItem(name = "capricciosa", size = "Large", quantity = 2),
OrderItem(name = "hawaii", size = "Large", quantity = 3),
OrderItem(name = "margherita", size = "Large", quantity = 1),
OrderItem(name = "hawaii", size = "Medium", quantity = 1),
OrderItem(name = "capricciosa", size = "Small", quantity = 5),
OrderItem(name = "capricciosa", size = "Medium", quantity = 1)]

your function should return 117, because you can choose not to pay for one "Small" margherita, and two "Small" capricciosa.
Notice that you still have to pay for three "Small" capricciosa because there are not enough "Large" ones to pair them with.


Discount 4 : buy 3 large, pay for 3 medium
When your order contains at least three "Large" pizzas, you can choose exactly three and pay for them as if they werer "Medium" pizzas with the same names.
You can use this discount at most once per order and you can not split order.

menu = [ Pizza(name ="boston", price_S = 7, price_M = 5, price_L =10),
Pizza(name ="hawaii", price_S = 8, price_M = 9, price_L = 12),
Pizza(name ="newyorker", price_S = 8, price_M = 9, price_L = 130),
Pizza(name ="philadelphia", price_S = 5, price_M = 10 price_L = 13)]

order = [OrderItem(name = "boston", size = "Small", quantity = 3),
OrderItem(name = "hawaii", size = "Large", quantity = 3),
OrderItem(name = "newyorker", size = "Large", quantity = 1),
OrderItem(name = "boston", size = "Large", quantity = 2),
OrderItem(name = "philadelphia", size = "Large", quantity = 2)]

your function should return 102, because you can choose to pay for one "Large" newyorker and two "Large" boston pizzas as if they were "Mediunm" ones
Notice that choosing any other three large pizzas results in a smaller discount.

Corner case : No discouints applicable

*/

public class QuestionTwo {
    class Pizza {
        public String name;
        public int price_S;
        public int price_M;
        public int price_L;
    }

    class OrderItem {
        public String name;
        public String size;
        public int quantity;
    }

    public int solution(Pizza[] menu, OrderItem[] order) {
        int naivePrice = 0;
        int discount1Price = 0;
        int discount2Price = 0;
        int discount3Price = 0;
        int discount4Price = 0;

        int result = Integer.MAX_VALUE;

        //init pizzaMap
        Map<String, Pizza> pizzaMap = new HashMap<>();
        for (Pizza pizza : menu) {
            pizzaMap.put(pizza.name, pizza);
        }

        //cal naivePrice
        for (OrderItem orderItem : order) {
            Pizza pizza = pizzaMap.get(orderItem.name);
            switch (orderItem.size) {
                case "Small":
                    naivePrice += pizza.price_S * orderItem.quantity;
                    break;
                case "Medium":
                    naivePrice += pizza.price_M * orderItem.quantity;
                    break;
                case "Large":
                    naivePrice += pizza.price_L * orderItem.quantity;
                    break;
            }
        }
        result = Math.min(result, naivePrice);

        //cal discount1Price
        //buy 3 cheapest one is free
        int totalPizzaCount = 0;
        discount1Price = naivePrice;
        for (OrderItem orderItem : order) {
            totalPizzaCount += orderItem.quantity;
        }
        if (totalPizzaCount >= 3) {
            List<Integer> priceList = new ArrayList<>();
            //init priceList
            for (OrderItem orderItem : order) {
                Pizza pizza = pizzaMap.get(orderItem.name);
                switch (orderItem.size) {
                    case "Small":
                        priceList.add(pizza.price_S);
                        break;
                    case "Medium":
                        priceList.add(pizza.price_M);
                        break;
                    case "Large":
                        priceList.add(pizza.price_L);
                        break;
                }
            }
            priceList.sort(Comparator.naturalOrder());
            discount1Price -= priceList.get(0);
        }
        result = Math.min(result, discount1Price);

        //cal discount2Price
        //buy 5 for 100
        if (naivePrice > 100) {
            boolean isDiscount2Target = false;
            discount2Price = naivePrice;
            Map<String, Integer> pizzaCountMap = new HashMap<>();
            Map<String, Map<String, Integer>> pizzaSizeMap = new HashMap<>();
            Set<Pizza> applicablePizzaSet = new HashSet<>();
            for (OrderItem orderItem : order) {
                pizzaCountMap.put(orderItem.name, pizzaCountMap.getOrDefault(orderItem.name, 0) + orderItem.quantity);

                pizzaSizeMap.putIfAbsent(orderItem.name, new HashMap<>());
                Map<String, Integer> sizeMap = pizzaSizeMap.get(orderItem.name);
                sizeMap.put(orderItem.size, orderItem.quantity);
            }

            for (String pizzaName : pizzaCountMap.keySet()) {
                if (pizzaCountMap.get(pizzaName) >= 5) {
                    isDiscount2Target = true;
                    applicablePizzaSet.add(pizzaMap.get(pizzaName));
                }
            }

            if (isDiscount2Target) {
                for (Pizza pizza : applicablePizzaSet) {
                    int maxDiscountPrice = 0;
                    String pizzaName = pizza.name;
                    Map<String, Integer> sizeMap = pizzaSizeMap.get(pizzaName);

                    List<Integer> priceList = new ArrayList<>();
                    if (sizeMap.containsKey("Small")) {
                        int count = sizeMap.get("Small");
                        for (int i = 0; i < count; ++i) {
                            priceList.add(pizza.price_S);
                        }
                    }
                    if (sizeMap.containsKey("Medium")) {
                        int count = sizeMap.get("Medium");
                        for (int i = 0; i < count; ++i) {
                            priceList.add(pizza.price_M);
                        }
                    }
                    if (sizeMap.containsKey("Large")) {
                        int count = sizeMap.get("Large");
                        for (int i = 0; i < count; ++i) {
                            priceList.add(pizza.price_L);
                        }
                    }

                    priceList.sort(Collections.reverseOrder());
                    for (int i = 0; i < 5; ++i) {
                        maxDiscountPrice += priceList.get(i);
                    }
                    discount2Price = Math.min(discount2Price, naivePrice - maxDiscountPrice + 100);
                }
            }
            result = Math.min(result, discount2Price);
        }


        //cal discount3Price
        //for every large pizza -> small is free
        discount3Price = naivePrice;
        Map<String, Integer> largePizzaCountMap = new HashMap<>();
        Map<String, Integer> smallPizzaCountMap = new HashMap<>();
        for (OrderItem orderItem : order) {
            if (orderItem.size.equals("Large")) {
                largePizzaCountMap.put(orderItem.name, largePizzaCountMap.getOrDefault(orderItem.name, 0) + orderItem.quantity);
            } else if (orderItem.size.equals("Small")) {
                smallPizzaCountMap.put(orderItem.name, smallPizzaCountMap.getOrDefault(orderItem.name, 0) + orderItem.quantity);
            }
        }

        for (String pizzaName : largePizzaCountMap.keySet()) {
            if (smallPizzaCountMap.containsKey(pizzaName)) {
                int largePizzaCount = largePizzaCountMap.get(pizzaName);
                int smallPizzaCount = smallPizzaCountMap.get(pizzaName);
                int applicablePizzaCount = Math.min(largePizzaCount, smallPizzaCount);
                discount3Price -= applicablePizzaCount * pizzaMap.get(pizzaName).price_S;
            }
        }

        result = Math.min(result, discount3Price);

        //cal discount4Price
        //buy 3 large -> pay 3 medium
        discount4Price = naivePrice;
        List<Integer> priceGapList = new ArrayList<>();
        for (OrderItem orderItem : order) {
            if (orderItem.size.equals("Large")
                    && pizzaMap.get(orderItem.name).price_L > pizzaMap.get(orderItem.name).price_M) {
                int priceGap = pizzaMap.get(orderItem.name).price_L - pizzaMap.get(orderItem.name).price_M;
                for (int i = 0; i < orderItem.quantity; ++i) {
                    priceGapList.add(priceGap);
                }
            }
        }
        priceGapList.sort(Comparator.reverseOrder());

        if (priceGapList.size() >= 3) {
            discount4Price -= priceGapList.get(0);
            discount4Price -= priceGapList.get(1);
            discount4Price -= priceGapList.get(2);
        }

        return Math.min(result, discount4Price);
    }
}
