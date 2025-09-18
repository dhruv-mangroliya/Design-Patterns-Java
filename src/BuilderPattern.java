// Product
class Desktop {
    int storageSize;
    int ramSize;
    int gpuSize;
    int graphicsCardSize;

    public void showSpecs() {
        System.out.println("Storage: " + storageSize + " GB, "
                + "RAM: " + ramSize + " GB, "
                + "GPU: " + gpuSize + " GB, "
                + "Graphics Card: " + graphicsCardSize + " GB");
    }
}

// Abstract Builder
abstract class DesktopBuilder {
    protected Desktop desktop = new Desktop();

    public abstract void setStorage();
    public abstract void setRAM();
    public abstract void setGPU();
    public abstract void setGraphicsCard();

    public Desktop getDesktop() {
        return desktop;
    }
}

// Concrete Builder 1 - Normal Desktop
class NormalDesktopBuilder extends DesktopBuilder {
    @Override
    public void setStorage() {
        desktop.storageSize = 512;
    }

    @Override
    public void setRAM() {
        desktop.ramSize = 8;
    }

    @Override
    public void setGPU() {
        desktop.gpuSize = 2;
    }

    @Override
    public void setGraphicsCard() {
        desktop.graphicsCardSize = 2;
    }
}

// Concrete Builder 2 - Gaming Desktop
class GamingDesktopBuilder extends DesktopBuilder {
    @Override
    public void setStorage() {
        desktop.storageSize = 2048;
    }

    @Override
    public void setRAM() {
        desktop.ramSize = 32;
    }

    @Override
    public void setGPU() {
        desktop.gpuSize = 8;
    }

    @Override
    public void setGraphicsCard() {
        desktop.graphicsCardSize = 12;
    }
}

// Director
class Director {
    public Desktop buildDesktop(DesktopBuilder builder) {
        builder.setStorage();
        builder.setRAM();
        builder.setGPU();
        builder.setGraphicsCard();
        return builder.getDesktop();
    }
}

// Client
public class BuilderPattern {
    public static void main(String[] args) {
        Director director = new Director();

        // Normal Desktop
        DesktopBuilder normalBuilder = new NormalDesktopBuilder();
        Desktop normalPC = director.buildDesktop(normalBuilder);
        System.out.println("Normal Desktop Specs:");
        normalPC.showSpecs();

        // Gaming Desktop
        DesktopBuilder gamingBuilder = new GamingDesktopBuilder();
        Desktop gamingPC = director.buildDesktop(gamingBuilder);
        System.out.println("\nGaming Desktop Specs:");
        gamingPC.showSpecs();
    }
}
