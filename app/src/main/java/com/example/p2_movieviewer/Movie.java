package com.example.p2_movieviewer;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Movie {
    String length;
    String name;
    String year;
    String cast;
    String url;
    String desc;
    String director;
    String rating;
    String awards;
    String genre;
    Integer resource_id;

    public Movie(String name)
    {
        this.name = name;
        this.year = "";
        this.length = "";
        this.cast = "";
        this.url = "";
        this.desc = "";
        this.director = "";
        this.rating = "";
        this.resource_id = -1;
        this.awards = "";
        this.genre = "";
    }

    public void GetImage()
    {
        try {
            String urlPath = "http://www.omdbapi.com/?t=" + name + "&apikey=bd266283";

            URL movieUrl = new URL(urlPath);
            HttpURLConnection conn = (HttpURLConnection) movieUrl.openConnection();
            conn.setRequestMethod("GET");

            InputStream stream = conn.getInputStream();

            JSONParser jsonParser = new JSONParser();
            InputStreamReader movieInfo = new InputStreamReader(stream, StandardCharsets.UTF_8);
            JSONObject jsonObject = (JSONObject) jsonParser.parse(movieInfo);

            url = setMovieField(jsonObject, url, "Poster");
            name = setMovieField(jsonObject, name, "Title");
            year = setMovieField(jsonObject, year, "Year");
            rating = setMovieField(jsonObject, rating, "imdbRating");
            desc = setMovieField(jsonObject, desc, "Plot");
            length = setMovieField(jsonObject, length, "Runtime");
            director = setMovieField(jsonObject, director, "Director");
            cast = setMovieField(jsonObject, cast, "Actors");
            awards = setMovieField(jsonObject, awards, "Awards");
            genre = setMovieField(jsonObject, genre, "Genre");

        } catch (MalformedURLException e) {

        } catch (ProtocolException e) {

        } catch (IOException e) {
            e.toString();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.toString();
        }
    }

    private String setMovieField(JSONObject movieInfo, String setValue, String fieldToGet) {
        Object value = movieInfo.get(fieldToGet);

        return value == null ? setValue : value.toString();
    }

    private Double setMovieField(JSONObject movieInfo, Double setValue, String fieldToGet) {
        Object value = movieInfo.get(fieldToGet);

        return value == null ? setValue : Double.parseDouble(value.toString());
    }
}

