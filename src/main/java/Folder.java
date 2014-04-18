import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    private final String title;
    private final List<Feed> feeds;

    public Folder(String title, JSONArray outline) {
        this.title = title;
        this.feeds = getFeeds(outline);
    }

    public String getTitle() {
        return title;
    }

    private List<Feed> getFeeds(JSONArray outline) {
        List<Feed> list = new ArrayList<Feed>();
        for (int i = 0; i < outline.length(); i++) {
            JSONObject o = outline.getJSONObject(i);
            list.add(new FeedBuilder(o).build());
        }
        return list;
    }

    public List getFeeds() {
        return feeds;
    }
}
