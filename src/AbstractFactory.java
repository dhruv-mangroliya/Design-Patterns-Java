// Button interface
interface Button {
    void press();
}

// Mac and Windows Button implementations
class MacButton implements Button {
    @Override
    public void press() {
        System.out.println("mac button pressed.");
    }
}

class WinButton implements Button {
    @Override
    public void press() {
        System.out.println("windows button pressed.");
    }
}

// TextBox interface
interface TextBox {
    void showText();
}

// Mac and Windows TextBox implementations
class MacTextBox implements TextBox {
    @Override
    public void showText() {
        System.out.println("mac textbox pressed.");
    }
}

class WinTextBox implements TextBox {
    @Override
    public void showText() {
        System.out.println("windows textbox pressed.");
    }
}

// OS Factory interface
interface OSFactory {
    Button createButton();
    TextBox createTextBox();
}

// Mac and Windows Factories
class MacFactory implements OSFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public TextBox createTextBox() {
        return new MacTextBox();
    }
}

class WinFactory implements OSFactory {
    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public TextBox createTextBox() {
        return new WinTextBox();
    }
}

// Main Factory to produce OS factories
class MainFactory {
    public OSFactory createFactory(String type) {
        if (type.equalsIgnoreCase("mac")) {
            return new MacFactory();
        } else {
            return new WinFactory();
        }
    }
}

// Driver class
public class AbstractFactory {
    public static void main(String[] args) {
        MainFactory mainFactory = new MainFactory();

        OSFactory factory = mainFactory.createFactory("mac"); // try "win"
        Button button = factory.createButton();
        TextBox textBox = factory.createTextBox();

        button.press();
        textBox.showText();
    }
}
