import org.json.JSONArray;
import org.json.JSONObject;

public class GoRead {
    private JSONArray opml;
    private JSONObject json;

    public GoRead(JSONObject json) {
        this.json = json;
        opml = json.getJSONArray("Opml");
    }

    public Opml getOpml() {
        Opml list = new Opml();
        for (int i = 0; i < opml.length(); i++) {
            JSONObject entry = opml.getJSONObject(i);
            String title = entry.getString("Title");
            if (entry.has("Outline")) {
                JSONArray outline = entry.getJSONArray("Outline");
                list.add(new Folder(title, outline));
            }
        }
        return list;
    }
}
