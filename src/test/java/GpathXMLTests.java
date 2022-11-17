import config.VideoGameConfig;
import config.VideoGameEndpoints;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GpathXMLTests extends VideoGameConfig {

    @Test
    public void getFirstGameInList() {

        Response response = get(VideoGameEndpoints.ALL_VIDEO_GAMES);

        String name = response.path("List.item.name[0]");

        System.out.println(name);
    }

    @Test
    public void getAttribute() {
        Response response = get(VideoGameEndpoints.ALL_VIDEO_GAMES);

        String category = response.path("List.item[0].@category");

        System.out.println(category);
    }
}
