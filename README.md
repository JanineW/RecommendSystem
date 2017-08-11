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
