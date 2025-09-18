import java.util.ArrayList;
import java.util.List;

// Component
interface FileSystem {
    void showDetails();
}

// Leaf
class File implements FileSystem {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}

// Composite
class Folder implements FileSystem {
    private String name;
    private List<FileSystem> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystem component) {
        children.add(component);
    }

    public void remove(FileSystem component) {
        children.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Folder: " + name);
        for (FileSystem fs : children) {
            fs.showDetails();
        }
    }
}

// Client
public class CompositePattern {
    public static void main(String[] args) {
        // Leaf nodes
        File file1 = new File("resume.pdf");
        File file2 = new File("song.mp3");
        File file3 = new File("photo.jpg");

        // Composite nodes
        Folder documents = new Folder("Documents");
        Folder music = new Folder("Music");
        Folder pictures = new Folder("Pictures");

        // Add files to folders
        documents.add(file1);
        music.add(file2);
        pictures.add(file3);

        // Root folder
        Folder root = new Folder("Root");
        root.add(documents);
        root.add(music);
        root.add(pictures);

        // Display structure
        root.showDetails();
    }
}
