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
}
