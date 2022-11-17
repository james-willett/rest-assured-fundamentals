import config.VideoGameConfig;
import config.VideoGameEndpoints;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.element.Node;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

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

    @Test
    public void getListOfXmlNodes() {
        String responseAsString = get(VideoGameEndpoints.ALL_VIDEO_GAMES).asString();

        List<Node> allResults = XmlPath.from(responseAsString).get(
                "List.item.findAll { element -> return element }"
        );

        System.out.println(allResults.get(2).get("name").toString());
    }

    @Test
    public void getListOfXmlNodesByFindAllOnAttribute() {
        String responseAsString = get(VideoGameEndpoints.ALL_VIDEO_GAMES).asString();

        List<Node> allDrivingGames = XmlPath.from(responseAsString).get(
                "List.item.findAll { game -> def category = game.@category; category == 'Driving' }"
        );

        System.out.println(allDrivingGames.get(0).get("name").toString());
    }

    @Test
    public void getSingleNode() {
        String responseAsString = get(VideoGameEndpoints.ALL_VIDEO_GAMES).asString();

        Node videoGame = XmlPath.from(responseAsString).get(
                "List.item.find { game -> def name = game.name; name == 'Tetris' }"
        );

        String videoGameName = videoGame.get("name").toString();

        System.out.println(videoGameName);
    }

    @Test
    public void getSingleElementDepthFirstSearch() {
        String responseAsString = get(VideoGameEndpoints.ALL_VIDEO_GAMES).asString();

        int reviewScore = XmlPath.from(responseAsString).getInt(
                "**.find { it.name == 'Gran Turismo 3' }.reviewScore"
        );

        System.out.println(reviewScore);
    }

    @Test
    public void getAllNodesBasedOnCondtion() {
        String responseAsString = get(VideoGameEndpoints.ALL_VIDEO_GAMES).asString();

        int reviewScore = 90;

        List<Node> allVideoGamesOverCertainScore = XmlPath.from(responseAsString).get(
                "List.item.findAll { it.reviewScore.toFloat() >= " + reviewScore + "}"
        );

        System.out.println(allVideoGamesOverCertainScore);
    }
}
