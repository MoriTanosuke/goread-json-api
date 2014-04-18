public class Feed {
    private final String title;
    private final String xmlUrl;
    private final String htmlUrl;

    public Feed(String title, String xmlUrl, String htmlUrl) {
        this.title = title;
        this.xmlUrl = xmlUrl;
        this.htmlUrl = htmlUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getXmlUrl() {
        return xmlUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }
}
