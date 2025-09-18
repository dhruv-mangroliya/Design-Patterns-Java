// Component
interface Pizza {
    int getCost();
}

// Concrete Components
class Margherita implements Pizza {
    private int cost;

    public Margherita() {
        this.cost = 100;
    }

    @Override
    public int getCost() {
        return cost;
    }
}

class Cheesy implements Pizza {
    private int cost;

    public Cheesy() {
        this.cost = 200;
    }

    @Override
    public int getCost() {
        return cost;
    }
}

// Abstract Decorator
abstract class ToppingsDecorator implements Pizza {
    protected Pizza pizza;

    public ToppingsDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public abstract int getCost();
}

// Concrete Decorators
class Mushroom extends ToppingsDecorator {
    public Mushroom(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 30;
    }
}

class Jalapeno extends ToppingsDecorator {
    public Jalapeno(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 50;
    }
}

// Client
public class DecoratorPattern {
    public static void main(String[] args) {
        Pizza p1 = new Jalapeno(new Mushroom(new Cheesy()));
        int finalCost1 = p1.getCost();
        System.out.println(finalCost1);

        Pizza p2 = new Jalapeno(new Mushroom(new Margherita()));
        int finalCost2 = p2.getCost();
        System.out.println(finalCost2);
    }
}
