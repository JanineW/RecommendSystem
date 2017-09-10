import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MovieRunnerWithFiltersTest {
    private MovieRunnerWithFilters mrwf;

    @Before
    public void setUp() throws Exception {
        mrwf = new MovieRunnerWithFilters();
    }

    @After
    public void tearDown() throws Exception {
        mrwf = null;
    }

    @Test
    public void printAverageRatingsTest() {
        mrwf.printAverageRatings();
        System.out.println();
    }

    @Test
    public void printAverageRatingsByYearTest() {
        mrwf.printAverageRatingsByYear();
        System.out.println();
    }

    @Test
    public void  printAverageRatingsByGenreTest() {
        mrwf.printAverageRatingsByGenre();
        System.out.println();
    }

    @Test
    public void  printAverageRatingsByMinutesTest() {
        mrwf.printAverageRatingsByMinutes();
        System.out.println();
    }

    @Test
    public void  printAverageRatingsByDirectorsTest() {
        mrwf.printAverageRatingsByDirectors();
        System.out.println();
    }

    @Test
    public void  printAverageRatingsByYearAfterAndGenreTest() {
        mrwf.printAverageRatingsByYearAfterAndGenre();
        System.out.println();
    }

    @Test
    public void  printAverageRatingsByDirectorsAndMinutesTest() {
        mrwf.printAverageRatingsByDirectorsAndMinutes();
        System.out.println();
    }

}