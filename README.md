# Recommend System
## A Simplified Recommender Engine

### Step One
Read in and store information about movies and ratings of movies by different movie raters to answer simple questions about both movies and ratings.

The class Movie is a Plain Old Java Object (POJO) class for storing the data about one movie. It includes the following items:

Eight private variables to represent information about a movie including:

id - a String variable representing the IMDB ID of the movie
title - a String variable for the movie’s title
year - an integer representing the year
genres - one String of one or more genres separated by commas
director - one String of one or more directors of the movie separated by commas
country - one String of one or more countries the film was made in, separated by commas
minutes - an integer for the length of the movie
poster - a String that is a link to an image of the movie poster if one exists, or “N/A” if no poster exists


A constructor with eight parameters to initialize the private variables

Eight getter methods to return the private information such as the method getGenres that returns a String of all the genres for this movie.

A toString method for representing movie information as a String so it can easily be printed.

The class Rating is also a POJO class for storing the data about one rating of an item. It includes

Two private variables to represent information about a rating:

item - a String description of the item being rated (for this assignment you should use the IMDB ID of the movie being rated)
value - a double of the actual rating
A constructor with two parameters to initialize the private variables.

Two getter methods getItem and getValue.

A toString method to represent rating information as a String.

A compareTo method to compare this rating with another rating.

The class Rater keeps track of one rater and all their ratings. This class includes:

Two private variables:

myID - a unique String ID for this rater
myRatings - an ArrayList of Ratings
A constructor with one parameter of the ID for the rater.

A method addRating that has two parameters, a String named item and a double named rating. A new Rating is created and added to myRatings.

A method getID with no parameters to get the ID of the rater.

A method getRating that has one parameter item. This method returns the double rating of this item if it is in myRatings. Otherwise this method returns -1.

A method numRatings that returns the number of ratings this rater has.

A method getItemsRated that has no parameters. This method returns an ArrayList of Strings representing a list of all the items that have been rated.

### Step Two

Create a SecondRatings object and use the CSV filenames of movie information and ratings information from the first assignment when calling the constructor.

Print the number of movies and number of raters from the two files by calling the appropriate methods in the SecondRatings class. Test your program to make sure it is reading in all the data from the two files. For example, if you run your program on the files ratings_short.csv and ratedmovies_short.csv, you should see 5 raters and 5 movies.

- In the SecondRatings class, write a private helper method named getAverageByID that has two parameters: a String named id representing a movie ID and an integer named minimalRaters. This method returns a double representing the average movie rating for this ID if there are at least minimalRaters ratings. If there are not minimalRaters ratings, then it returns 0.0.
- In the SecondRatings class, write a public method named getAverageRatings, which has one int parameter named minimalRaters. This method should find the average rating for every movie that has been rated by at least minimalRaters raters. Store each such rating in a Rating object in which the movie ID and the average rating are used in creating the Rating object. The method getAverageRatings should return an ArrayList of all the Rating objects for movies that have at least the minimal number of raters supplying a rating. For example, if minimalRaters has the value 10, then this method returns rating information (the movie ID and its average rating) for each movie that has at least 10 ratings. You should consider calling the private getAverageByID method.
- In the SecondRatings class, write a method named getTitle that has one String parameter named id, representing the ID of a movie. This method returns the title of the movie with that ID. If the movie ID does not exist, then this method should return a String indicating the ID was not found.
- In the MovieRunnerAverage class in the printAverageRatings method, add code to print a list of movies and their average ratings, for all those movies that have at least a specified number of ratings, sorted by averages. Specifically, this method should print the list of movies, one movie per line (print its rating first, followed by its title) in sorted order by ratings, lowest rating to highest rating. 
- In the SecondRatings class, write a method getID that has one String parameter named title representing the title of a movie. This method returns the movie ID of this movie.
- In the MovieRunnerAverage class, write the void method getAverageRatingOneMovie, which has no parameters. This method should first create a SecondRatings object, reading in data from the movie and ratings data files. 
