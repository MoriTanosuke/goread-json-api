import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GoRead {
    private JSONObject json;

    public GoRead(JSONObject json) {
        this.json = json;
    }

    public List<Folder> getFolders() {
        List<Folder> list = new ArrayList<Folder>();

        JSONArray opml = json.getJSONArray("Opml");
        for (int i = 0; i < opml.length(); i++) {
            JSONObject entry = opml.getJSONObject(i);
            if (entry.has("Outline")) {
                list.add(new FolderBuilder(entry.getString("Title")).fromOutline(entry.getJSONArray("Outline")).build());
            }
        }
        return list;
    }

    public Folder getFolder(String title) {
        for (Folder f : getFolders()) {
            if (f.getTitle().equals(title)) {
                return f;
            }
        }
        return null;
    }

    public List<JSONArray> getStories() {
        List<JSONArray> list = new ArrayList<JSONArray>();
        JSONObject s = json.getJSONObject("Stories");
        Iterator<String> it = s.keys();
        while (it.hasNext()) {
            String key = it.next();
            JSONArray story = s.getJSONArray(key);
            list.add(story);
        }
        return list;
    }
}
