// Factory pattern = “Don’t ask how to create, just ask for what you need.”
// Client code doesn’t care about which class is instantiated.
// Add new types without modifying client code

// Product
abstract class Vehicle {
    public static Vehicle createVehicle() {
        return null; // Default, overridden by subclasses
    }
}

// Concrete Product - Bike
class Bike extends Vehicle {
    public Bike() {
        System.out.println("bike created");
    }

    public static Vehicle createVehicle() {
        return new Bike();
    }
}

// Concrete Product - Car
class Car extends Vehicle {
    public Car() {
        System.out.println("car created");
    }

    public static Vehicle createVehicle() {
        return new Car();
    }
}

// Factory
class VehicleFactory {
    public static Vehicle makeVehicle(String type) {
        if (type.equalsIgnoreCase("bike")) {
            return Bike.createVehicle();
        } else {
            return Car.createVehicle();
        }
    }
}

// Client
public class FactoryPattern {
    public static void main(String[] args) {
        Vehicle v1 = VehicleFactory.makeVehicle("bike");
        Vehicle v2 = VehicleFactory.makeVehicle("car");
    }
}
