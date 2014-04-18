import org.json.JSONObject;

public class FeedBuilder {
    private String htmlUrl;
    private String xmlUrl;
    private String title;

    public FeedBuilder(JSONObject o) {
        title = o.getString("Title");
        xmlUrl = o.getString("XmlUrl");
        htmlUrl = o.getString("HtmlUrl");
    }

    public Feed build() {
        return new Feed(title, xmlUrl, htmlUrl);
    }
}
