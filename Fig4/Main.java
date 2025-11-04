package Java;

interface Shipping {
    double getCost(Order order);
    String getDate(Order order);
}

class Ground implements Shipping {
    @Override
    public double getCost(Order order) {
        double totalWeight = order.getTotalWeight();
        if (order.getTotal() > 100) {
            return 0; 
        }
        return Math.max(10, totalWeight * 1.5); 
    }

    @Override
    public String getDate(Order order) {
        return "Delivered in 5-7 business days";
    }
}


class Air implements Shipping {
    @Override
    public double getCost(Order order) {
        return order.getTotalWeight() * 3.0; 
    }

    @Override
    public String getDate(Order order) {
        return "Delivered in 1-2 business days";
    }
}


class Order {
    private double total;
    private double totalWeight;
    private Shipping shipping;

    public Order(double total, double totalWeight) {
        this.total = total;
        this.totalWeight = totalWeight;
    }

    public double getTotal() {
        return total;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public double getShippingCost() {
        return shipping.getCost(this);
    }

    public String getShippingDate() {
        return shipping.getDate(this);
    }
}


public class Main {
    public static void main(String[] args) {
        Order order1 = new Order(120, 15); 
        order1.setShipping(new Ground());

        System.out.println("Ground Shipping Cost: Rs" + order1.getShippingCost());
        System.out.println(order1.getShippingDate());

        Order order2 = new Order(80, 10); 
        order2.setShipping(new Air());

        System.out.println("Air Shipping Cost: Rs" + order2.getShippingCost());
        System.out.println(order2.getShippingDate());
    }
}
