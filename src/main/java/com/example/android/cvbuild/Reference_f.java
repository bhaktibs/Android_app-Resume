package com.example.android.cvbuild;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Reference_f extends Fragment {


    public Reference_f() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = (View)inflater.inflate(R.layout.fragment_reference_f, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.ref1);
        ArrayList<String> temp=getProfileFromFile("reference.json",getContext());
        textView.setText(temp.get(0));
        textView.append(temp.get(1));
        TextView textView1 = (TextView) rootView.findViewById(R.id.ref2);
        textView1.setText(temp.get(2));
        textView1.append(temp.get(3));

        return rootView;
    }

    public static ArrayList<String> getProfileFromFile(String filename, Context context){
        //final ArrayList<Recipe> recipeList = new ArrayList<>();
        ArrayList<String> jsonString = new ArrayList<String>();

        try {
            // Load data
            String jsonString1;
            jsonString1 = loadJsonFromAsset(filename, context);
            JSONObject json = new JSONObject(jsonString1);
            //System.out.println(json);

            jsonString.add(0,json.getString("R1"));
            jsonString.add(1,json.getString("C1"));
            jsonString.add(2,json.getString("R2"));
            jsonString.add(3,json.getString("C2"));


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
