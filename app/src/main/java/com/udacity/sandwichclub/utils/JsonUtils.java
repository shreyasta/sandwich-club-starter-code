package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*Submitted by Shreyasta Samal */
public class JsonUtils {
    // continue adding the variables from  Sandwich.java



    public static Sandwich parseSandwichJson(String json) {
        // Initializing JSON Objects
        // Adding try and catch exception block
    try {
        // Initializing JSONObject from JSON Strings
        JSONObject sandwichNames = new JSONObject();
        // Extracting the JSONObject name  into JSONObject
        JSONObject names = sandwichNames.getJSONObject("names");
        // Getting the name from the key called mainName
        String mainName = names.getString("mainName");
        // Getting the arrayList  from the key called alsoKnownAs
        JSONArray alsoKnownAs = names.getJSONArray("alsoKnownAs");
        List<String> akaList = new ArrayList<>();
        // for each item in the list, adding the items in the arraylist
        for (int i = 0; i < alsoKnownAs.length(); i++ ){
            akaList.add(alsoKnownAs.getString(i));
        }

        // Extracing other variables in Sanwich.java in a similar way
        String placeOfOrigin = names.getString("placeOfOrigin");
        String description = names.getString("description");
        String image = names.getString("image");

        JSONArray ingredients = names.getJSONArray("ingredients");

        List<String> ingredientsList = new ArrayList<>();
        // for each item in the list, adding the items in the arraylist
        for (int i = 0; i < ingredients.length(); i++ ){
            ingredientsList.add(ingredients.getString(i));
        }

        return new Sandwich(mainName,akaList, placeOfOrigin, description, image, ingredientsList );

    }
        catch (JSONException e){
         e.printStackTrace();
        }

        return null;
    }
}
