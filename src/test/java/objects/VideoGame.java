package objects;

public class VideoGame {

    private String category;
    private String name;
    private String rating;
    private String releaseDate;
    private Integer reviewScore;

    /**
     * No args constructor for use in serialization
     *
     */
    public VideoGame() {
    }

    /**
     *
     * @param reviewScore
     * @param releaseDate
     * @param name
     * @param rating
     * @param category
     */
    public VideoGame(String category, String name, String rating, String releaseDate, Integer reviewScore) {
        super();
        this.category = category;
        this.name = name;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.reviewScore = reviewScore;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(Integer reviewScore) {
        this.reviewScore = reviewScore;
    }

}
