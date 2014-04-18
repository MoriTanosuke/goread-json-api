import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class GoReadTest {

    private JSONObject js;
    private GoRead goRead;

    @Before
    public void setUp() throws IOException {
        String json = IOUtils.toString(getClass().getResourceAsStream("list-feeds.json"));
        assertNotNull("test data not found", json);
        js = new JSONObject(json);
        assertNotNull(js);

        goRead = new GoRead(js);
    }

    @Test
    public void testJsonIsParsed() throws IOException {
        List<Folder> folders = goRead.getFolders();

        assertEquals(12, folders.size());
    }

    @Test
    public void testFolderCanBeFetchedByTitle() {
        Folder nerdFolder = goRead.getFolder("Nerds");
        assertEquals(19, nerdFolder.getFeeds().size());
    }

    @Test
    public void testFoldersAreParsed() {
        List<Folder> folders = goRead.getFolders();

        Folder firstFolder = folders.get(0);
        assertEquals("Arduino", firstFolder.getTitle());
        assertEquals(1, firstFolder.getFeeds().size());

        Folder lastFolder = folders.get(folders.size() - 1);
        assertEquals("VIP", lastFolder.getTitle());
    }

    @Test
    public void testFoldersHaveFeeds() {
        List<Folder> folders = goRead.getFolders();

        Folder folder = folders.get(1);
        List<Feed> feeds = folder.getFeeds();
        assertEquals(2, feeds.size());
        assertEquals("Calvin and Hobbes Daily", feeds.get(0).getTitle());
        assertEquals("http://calvinhobbesdaily.tumblr.com/rss", feeds.get(0).getXmlUrl());
        assertEquals("http://calvinhobbesdaily.tumblr.com/", feeds.get(0).getHtmlUrl());
    }

    @Test
    public void testStoriesAreParsed() {
        List<JSONArray> stories = goRead.getStories();

        assertEquals(92, stories.size());
    }
}
