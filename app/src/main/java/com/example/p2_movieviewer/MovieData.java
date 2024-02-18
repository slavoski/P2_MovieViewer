package com.example.p2_movieviewer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MovieData {

    final List<Movie> moviesList;

    public List<Movie> getMoviesList() {
        return moviesList;
    }

    public int getMoviesSize() { return moviesList.size(); }

    public Movie getItem(int i) {
        if (i >= 0 && i < moviesList.size()) {
            return moviesList.get(i);
        } else return null;
    }

    public Movie getMovie(int index)
    {
        Movie result;

        if (index >= 0 && index < moviesList.size()) {
            result = moviesList.get(index);
        } else result = null;

        if(result != null)
        {
            Thread thread = new Thread(() -> {
                try  {
                    result.GetImage();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            thread.start();

            try {
                thread.join();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }

        return result;
    }

    public MovieData() {
        moviesList = new ArrayList<>();
        moviesList.add(new Movie("Avatar"));
        moviesList.add(new Movie("Titanic"));
        moviesList.add(new Movie("The Avengers"));
        moviesList.add(new Movie("The Dark Knight"));
        moviesList.add(new Movie("Star Wars: Episode I"));
        moviesList.add(new Movie("Star Wars: Episode IV - A New Hope "));
        moviesList.add(new Movie("The Dark Knight Rises"));
        moviesList.add(new Movie("Shrek 2"));
        moviesList.add(new Movie("The Dark Knight Rises"));
        moviesList.add(new Movie("E.T. the Extra-Terrestrial"));
        moviesList.add(new Movie("The Hunger Games: Catching Fire"));
        moviesList.add(new Movie("Pirates of the Caribbean: Dead Man's Chest"));
        moviesList.add(new Movie("The Lion King"));
        moviesList.add(new Movie("Toy Story 3"));
        moviesList.add(new Movie("Iron Man 3"));
        moviesList.add(new Movie("The Hunger Games"));
        moviesList.add(new Movie("Spider-Man"));
        moviesList.add(new Movie("Jurassic Park"));
        moviesList.add(new Movie("Transformers: Revenge of the Fallen"));
        moviesList.add(new Movie("Frozen"));
        moviesList.add(new Movie("Harry Potter and the Deathly Hallows: Part 2"));
        moviesList.add(new Movie("Finding Nemo"));
        moviesList.add(new Movie("Star Wars: Episode III"));
        moviesList.add(new Movie("The Lord of the Rings: The Return of the King"));
        moviesList.add(new Movie("Spider-Man 2"));
        moviesList.add(new Movie("Despicable Me 2"));
        moviesList.add(new Movie("Transformers: Dark of the Moon"));
        moviesList.add(new Movie("The Lord of the Rings: The Two Towers"));
        moviesList.add(new Movie("Spider-Man 3"));
        moviesList.add(new Movie("Alice in Wonderland"));
        moviesList.add(new Movie("Forrest Gump"));
        moviesList.add(new Movie("Independence Day"));
    }

    public void InitializeMovies()
    {
        Thread thread = new Thread(() -> {
            try  {
                for (Movie movie : moviesList) {
                    movie.GetImage();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            thread.join();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}