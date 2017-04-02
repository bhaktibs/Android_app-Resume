package com.example.android.cvbuild;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Profile_f extends Fragment {

    public static  String name;
    public String contact;
    public String email;
    public String address;

    public Profile_f() {
        // Required empty public constructor

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = (View)inflater.inflate(R.layout.fragment_profile_f2, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.edit_text);
        ArrayList<String> temp=getProfileFromFile("profile.json",getContext());
        textView.setText(temp.get(0));

        TextView textView1 = (TextView) rootView.findViewById(R.id.edit_text1);
        textView1.setText(temp.get(1));
        TextView textView3 = (TextView) rootView.findViewById(R.id.edit_text2);
        textView3.setMovementMethod(LinkMovementMethod.getInstance());




        return rootView;
        //return inflater.inflate(R.layout.fragment_profile_f2, container, false);
    }

    public static ArrayList<String> getProfileFromFile(String filename, Context context){
        //final ArrayList<Recipe> recipeList = new ArrayList<>();
        ArrayList<String> jsonString = new ArrayList<String>();

        try {
            // Load data
            String jsonString1;
            jsonString1 = loadJsonFromAsset(filename, context);
            JSONObject json = new JSONObject(jsonString1);
            System.out.println(json);

            jsonString.add(0,json.getString("name"));
            jsonString.add(1,json.getString("objective"));

        }
        catch (JSONException e) {
            e.printStackTrace();
        }
            // Get Recipe objects from data

        return jsonString;
    }


    private static String loadJsonFromAsset(String filename, Context context) {
        String json = null;

        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch (java.io.IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }

}
