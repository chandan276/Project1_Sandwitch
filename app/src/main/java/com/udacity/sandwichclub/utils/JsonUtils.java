package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        Sandwich sandwichObject = null;
        try {
            JSONObject sandwichJsonObject = new JSONObject(json);

            JSONObject nameObject = sandwichJsonObject.getJSONObject("name");
            String mainName = nameObject.getString("mainName");
            List<String> alsoKnownAs = new ArrayList<String>();
            JSONArray listdata = nameObject.getJSONArray("alsoKnownAs");
            if (listdata != null) {
                for (int i = 0; i < listdata.length(); i++){
                    alsoKnownAs.add(listdata.getString(i));
                }
            }

            String placeOfOrigin = sandwichJsonObject.getString("placeOfOrigin");
            String description = sandwichJsonObject.getString("description");
            String image = sandwichJsonObject.getString("image");

            List<String> ingredients = new ArrayList<String>();
            JSONArray listDataIngredients = sandwichJsonObject.getJSONArray("ingredients");
            if (listDataIngredients != null) {
                for (int i = 0; i < listDataIngredients.length(); i++){
                    ingredients.add(listDataIngredients.getString(i));
                }
            }

            sandwichObject = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sandwichObject;
    }
}
