// 1. State interface
interface TrafficLightState {
    void change(TrafficLight light);
    String getColor();
}

// 2. Concrete States
class RedLight implements TrafficLightState {
    public void change(TrafficLight light) {
        System.out.println("Red → Green");
        light.setState(new GreenLight());
    }
    public String getColor() {
        return "Red";
    }
}

class GreenLight implements TrafficLightState {
    public void change(TrafficLight light) {
        System.out.println("Green → Yellow");
        light.setState(new YellowLight());
    }
    public String getColor() {
        return "Green";
    }
}

class YellowLight implements TrafficLightState {
    public void change(TrafficLight light) {
        System.out.println("Yellow → Red");
        light.setState(new RedLight());
    }
    public String getColor() {
        return "Yellow";
    }
}

// 3. Context class
class TrafficLight {
    private TrafficLightState state;

    public TrafficLight() {
        this.state = new RedLight(); // Default starting state
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void change() {
        state.change(this);
    }

    public void showColor() {
        System.out.println("Current Light: " + state.getColor());
    }
}

public class StatePattern {
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();

        light.showColor(); // Red
        light.change();    // Red → Green

        light.showColor(); // Green
        light.change();    // Green → Yellow

        light.showColor(); // Yellow
        light.change();    // Yellow → Red

        light.showColor(); // Red again
    }
}
