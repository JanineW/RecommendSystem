/**
 * Read in and store information about movies and ratings of movies by different movie raters
 *
 * @author Janine Wei
 * @version July, 2017
 */

import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;

public class FirstRatings {
    /**
     * This method processes every record from the CSV file whose name is filename,
     * a file of movie information, and
     * return an ArrayList of type Movie with all of the movie data from the file.
     * @param
     * @return
     */
    public ArrayList<Movie> loadMovies(String filename){
        ArrayList<Movie> list = new ArrayList<Movie>();
        FileResource fr = new FileResource(filename);
        CSVParser parser = fr.getCSVParser();
        for(CSVRecord rec: parser) {
            Movie m = new Movie(rec.get("id"), rec.get("title"), rec.get("year"), rec.get("genre"), rec.get("director"),rec.get("country"), rec.get("poster"), Integer.parseInt(rec.get("minutes")));
            list.add(m);
        }
        return list;
    }

    /**
     * Call the method loadMovies on the file ratedmoviesfull.csv
     * and store the result in an ArrayList local variable . Print the number of movies, and print each movie.
     *
     * Add code to determine how many movies include the specific genre.
     * Add code to determine how many movies are greater than 150 minutes in length.
     * Add code to determine the maximum number of movies by any director, and who the directors are that directed that many movies.
     *
     */

    public void testLoadMovies() {
//      String filename = "data/ratedmovies_short.csv";
		String filename = "data/ratedmoviesfull.csv";
        ArrayList<Movie> movieList = loadMovies(filename);
        System.out.println("--------------------------------------------------------------");
        System.out.println(filename.substring(5) + " has " + movieList.size() + " movies");
        int genreCount = 0, timeCount = 0;
        String genre = "Comedy";
        int time = 150;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(Movie m: movieList) {
//			System.out.println(m);
            if(m.getGenres().contains(genre))
                genreCount++;
            if(m.getMinutes() > time)
                timeCount++;

            if(map.containsKey(m.getDirector()))
                map.put(m.getDirector(), map.get(m.getDirector()) + 1);
            else
                map.put(m.getDirector(), 1);
        }
        System.out.println(genreCount + " movies include " + genre);
        System.out.println(timeCount + " movies are greater than " + time + " minutes");
        int maxValue = Collections.max(map.values());
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(pair.getValue().equals(maxValue))
                System.out.println(pair.getKey() + " directed the maximum number of movies, which is " + maxValue);
        }
        System.out.println("--------------------------------------------------------------");
    }

    /**
     * This method process every record from the CSV file whose name is filename, a file of raters and their ratings,
     * and return an ArrayList of type Rater with all the rater data from the file.
     * @param filename
     * @return
     */
    public ArrayList<Rater> loadRaters(String filename) {
        ArrayList<Rater> list = new ArrayList<Rater>();
        FileResource fr = new FileResource(filename);
        CSVParser parser = fr.getCSVParser();
        int index = 0;
        for(CSVRecord rec: parser) {
            if(index == 0) {
                Rater r = new EfficientRater(rec.get("rater_id"));
                r.addRating(rec.get("movie_id"), Integer.parseInt(rec.get("rating")));
                list.add(index, r);
                index++;
            }
            else if(list.get(index-1).getID().equals(rec.get("rater_id"))) {
                list.get(index-1).addRating(rec.get("movie_id"), Integer.parseInt(rec.get("rating")));
            }
            else {
                Rater r = new EfficientRater(rec.get("rater_id"));
                r.addRating(rec.get("movie_id"), Integer.parseInt(rec.get("rating")));
                list.add(index, r);
                index++;
            }
        }
        return list;
    }

    public int numRatings(Rater r) {
        return r.numRatings();
    }

    /**
     * Add code to find the number of ratings for a particular rater specified in code.
     * Add code to find the maximum number of ratings by any rater. Determine how many raters have this maximum number of ratings and who those raters are.
     * Add code to find the number of ratings a particular movie has.
     * Add code to determine how many different movies have been rated by all these raters.
     *
     */
    public void testLoadRaters() {
//      String filename = "data/ratings_short.csv";
		String filename = "data/ratings.csv";
        ArrayList<Rater> raterList = loadRaters(filename);
        System.out.println("--------------------------------------------------------------");
        System.out.println(filename.substring(5) + " has " + raterList.size() + " raters");
        String raterID = "193";
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String movieID = "1798709";
        int raterCount = 0;
        Set<String> set = new HashSet<String>();
        for(Rater r: raterList) {
//			System.out.println("Rater ID " + r.getID() + " has " + r.numRatings() + " ratings");
            ArrayList<String> ratingList = r.getItemsRated();
            for(String s: ratingList) {
//				System.out.println("Movie ID " + s + " is rated as " + r.getRating(s));
                if(!set.contains(s)) {
                    set.add(s);
                }

            }
//			System.out.println();

            if(r.getID().equals(raterID))
                System.out.println("Rater ID " + raterID + " has " + r.numRatings() + " ratings");

            map.put(r.getID(), r.numRatings());

            if(r.hasRating(movieID)) {
                raterCount++;
            }

        }
        int maxValue = Collections.max(map.values());
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(pair.getValue().equals(maxValue))
                System.out.println("Rater ID " + pair.getKey() + " has the maximum number of ratings, which is " + maxValue);
        }
        System.out.println("Movie ID " + movieID + " was rated by " + raterCount + " raters");
        System.out.println(set.size() + " movies have been rated by all " +  raterList.size() + " raters");
        System.out.println("--------------------------------------------------------------");
    }
}
