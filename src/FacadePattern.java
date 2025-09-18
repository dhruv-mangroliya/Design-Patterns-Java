// Subsystem classes
class CPU {
    public void freeze() {
        System.out.println("CPU freezing...");
    }

    public void jump(long pos) {
        System.out.println("CPU jumping to " + pos);
    }

    public void execute() {
        System.out.println("CPU executing...");
    }
}

class Memory {
    public void load(long pos, String data) {
        System.out.println("Loading data '" + data + "' at position " + pos);
    }
}

class HardDrive {
    public String read(long lba, int size) {
        return "OS_BOOT_SECTOR";
    }
}

// Facade class
class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hd;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hd = new HardDrive();
    }

    public void startComputer() {
        cpu.freeze();
        String bootData = hd.read(0, 10);
        memory.load(0, bootData);
        cpu.jump(0);
        cpu.execute();
        System.out.println("Computer started successfully!");
    }
}

// Client code
public class FacadePattern {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();  // Client only calls one method
    }
}
