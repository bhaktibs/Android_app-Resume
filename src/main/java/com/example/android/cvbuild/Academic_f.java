package com.example.android.cvbuild;


import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.cvbuild.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Academic_f extends Fragment {


    public Academic_f() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = (View)inflater.inflate(R.layout.fragment_academic_f2, container, false);

        ArrayList<String> temp=getProfileFromFile("academics.json",getContext());

        SpannableString t1=new SpannableString(temp.get(3));
        TextView textView = (TextView) rootView.findViewById(R.id.a1);
        t1.setSpan(new StyleSpan(Typeface.BOLD), 0, t1.length(), 0);
        textView.setText(t1);
        textView.append(System.getProperty("line.separator"));
        textView.append(temp.get(0));


        SpannableString t2=new SpannableString(temp.get(4));
        t2.setSpan(new StyleSpan(Typeface.BOLD), 0, t2.length(), 0);
        TextView textView1 = (TextView) rootView.findViewById(R.id.a2);
        textView1.setText(t2);
        textView1.append(System.getProperty("line.separator"));
        textView1.append(temp.get(1));
        //System.out.println(temp.get(1));
        //System.out.println(temp.get(4));

        TextView textView2 = (TextView) rootView.findViewById(R.id.a3);
        textView2.setText(temp.get(2));

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
            //System.out.println(json);

            jsonString.add(0,json.getString("A1"));
            jsonString.add(1,json.getString("A2"));
            // System.out.println(json.getString("emailId"));
            jsonString.add(2,json.getString("A3"));
            jsonString.add(3,json.getString("T1"));
            jsonString.add(4,json.getString("T2"));


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
