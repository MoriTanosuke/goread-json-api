import org.json.JSONArray;

public class FolderBuilder {
    private String title;
    private JSONArray outline;

    public FolderBuilder(String title) {
        this.title = title;
    }

    public FolderBuilder title(String title) {
        this.title = title;
        return this;
    }

    public FolderBuilder fromOutline(JSONArray outline) {
        this.outline = outline;
        return this;
    }

    public Folder build() {
        return new Folder(title, outline);
    }
}
