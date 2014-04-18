import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class GoReadTest {

    private JSONObject js;

    @Before
    public void setUp() throws IOException {
        String json = IOUtils.toString(getClass().getResourceAsStream("list-feeds.json"));
        assertNotNull("test data not found", json);
        js = new JSONObject(json);
        assertNotNull(js);
    }

    @Test
    public void testJsonIsParsed() throws IOException {
        List<Folder> opml = new GoRead(js).getOpml();

        assertEquals(12, opml.size());
    }

    @Test
    public void testFolderCanBeFetchedByTitle() {
        Opml opml = new GoRead(js).getOpml();
        Folder nerdFolder = opml.getFolder("Nerds");
        assertEquals(19, nerdFolder.getFeeds().size());
    }

    @Test
    public void testFoldersAreParsed() {
        List<Folder> opml = new GoRead(js).getOpml();

        Folder firstFolder = opml.get(0);
        assertEquals("Arduino", firstFolder.getTitle());
        assertEquals(1, firstFolder.getFeeds().size());

        Folder lastFolder = opml.get(opml.size() - 1);
        assertEquals("VIP", lastFolder.getTitle());
    }

    @Test
    public void testFoldersHaveFeeds() {
        List<Folder> opml = new GoRead(js).getOpml();

        Folder folder = opml.get(1);
        List<Feed> feeds = folder.getFeeds();
        assertEquals(2, feeds.size());
        assertEquals("Calvin and Hobbes Daily", feeds.get(0).getTitle());
        assertEquals("http://calvinhobbesdaily.tumblr.com/rss", feeds.get(0).getXmlUrl());
        assertEquals("http://calvinhobbesdaily.tumblr.com/", feeds.get(0).getHtmlUrl());
    }
}
