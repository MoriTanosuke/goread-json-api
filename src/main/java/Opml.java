import java.util.ArrayList;

public class Opml extends ArrayList<Folder> {
    public Folder getFolder(String title) {
        for (Folder f : this) {
            if (f.getTitle().equals(title)) {
                return f;
            }
        }
        return null;
    }
}
