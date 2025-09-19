import java.util.Stack;

class AirConditioner{
    int temperature;
    boolean isOn;

    AirConditioner(){
        this.temperature = 27;
        this.isOn = false;
    }

    void turnOn(){
        isOn = true;
        System.out.println("Ac is on...");
    }

    void turnOff(){
        isOn = false;
        System.out.println("Ac is off...");
    }

    void increaseTemperature(){
        this.temperature++;
        System.out.println("Temperature is " + this.temperature + "*C...");
    }

    void decreaseTemperature(){
        this.temperature--;
        System.out.println("Temperature is " + this.temperature + "*C...");
    }
}

interface Command{
    void execute();
    void undo();
}

class TurnOnAc implements Command{
    AirConditioner ac;

    public TurnOnAc(AirConditioner ac){
        this.ac = ac;
    }

    @Override
    public void execute(){
        ac.turnOn();
    }

    @Override
    public void undo() {
        ac.turnOff();
    }
}

class TurnOffAc implements Command{
    AirConditioner ac;

    public TurnOffAc(AirConditioner ac){
        this.ac = ac;
    }

    @Override
    public void execute(){
        ac.turnOff();
    }

    @Override
    public void undo(){
        ac.turnOn();
    }
}

class IncTemp implements Command{
    AirConditioner ac;

    public IncTemp(AirConditioner ac){
        this.ac = ac;
    }

    @Override
    public void execute(){
        ac.increaseTemperature();
    }

    @Override
    public void undo(){
        ac.decreaseTemperature();
    }
}

class DecTemp implements Command{
    AirConditioner ac;

    public DecTemp(AirConditioner ac){
        this.ac = ac;
    }

    @Override
    public void execute(){
        ac.decreaseTemperature();
    }

    @Override
    public void undo(){
        ac.increaseTemperature();
    }
}

class Remote{
    Command command;
    Stack<Command> history = new Stack<>();

    public Remote() {
    }

    public void setCommand(Command command){
        this.command = command;
    }

    public void pressButton(){
        System.out.println("Button Pressed...");
        this.command.execute();
        history.push(command);
    }

    public void undoCommand(){
        if(!history.isEmpty()){
            System.out.println("Undo Button Pressed...");
            Command lastCommand = history.getLast();
            history.pop();
            lastCommand.undo();
        }
    }
}
public class CommandPattern {
    public static void main(String[] args){
        AirConditioner ac = new AirConditioner();

        Command c1 = new TurnOnAc(ac);
        Command c2 = new IncTemp(ac);
        Command c3 = new IncTemp(ac);
        Command c4 = new DecTemp(ac);
        Command c5 = new TurnOffAc(ac);

        Remote remote = new Remote();

        remote.setCommand(c1);
        remote.pressButton();

        remote.setCommand(c2);
        remote.pressButton();

        remote.setCommand(c3);
        remote.pressButton();

        remote.setCommand(c4);
        remote.pressButton();
        remote.undoCommand();
        remote.undoCommand();

        remote.setCommand(c5);
        remote.pressButton();
        remote.undoCommand();

        return;
    }
}
