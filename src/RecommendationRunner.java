import java.util.*;

public class RecommendationRunner implements Recommender {
    private Random myRandom;
    private int toRateNum;
    private int numSimilarRaters;
    private int minimalRaters;
    private int maxRecNum;

    public RecommendationRunner() {
        myRandom = new Random();
        toRateNum = 10;
        numSimilarRaters = 20;
        minimalRaters = 5;
        maxRecNum = 20;
    }

    public ArrayList<String> getItemsToRate() {
        MovieDatabase.initialize("ratedmoviesfull.csv");
        ArrayList<String> toRate = new ArrayList<>();
        Filter f = new TrueFilter();
        ArrayList<String> allMovies = MovieDatabase.filterBy(f);
        for (int k = 0; k < toRateNum; k++) {
            int currIdx = myRandom.nextInt(MovieDatabase.size());
            String currMovieID = allMovies.get(currIdx);
            toRate.add(currMovieID);
        }

        System.out.println("Items to be rated:" + toRate);
        System.out.println("MovieDatabase size: " + MovieDatabase.size());
        System.out.println("RaterDatabase size:" + RaterDatabase.size());

        return toRate;
    }

    public void printRecommendationsFor(String webRaterID) {
        MovieDatabase.initialize("ratedmoviesfull.csv");
        FourthRatings fourth = new FourthRatings();
        ArrayList<Rating> result = fourth.getSimilarRatings(webRaterID, numSimilarRaters, minimalRaters);
        int num = result.size();
        System.out.println("Recommendation List:");
        if (num == 0) {
            System.out.println("Not Found");
        } else {
            if (num > maxRecNum) {
                num = maxRecNum;
            }
            for (int k = 0; k < num; k++) {
                Rating currRating = result.get(k);
                String currMovieID = currRating.getItem();

                System.out.println(MovieDatabase.getTitle(currMovieID) + " : " + currRating.getValue());
            }
        }
    }
}
