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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

import static com.example.android.cvbuild.R.*;


/**
 * A simple {@link Fragment} subclass.
 */
public class Contact_f extends Fragment {


    public Contact_f() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = (View)inflater.inflate(layout.fragment_contactinfo_f, container, false);
        TextView textView = (TextView) rootView.findViewById(id.edit_con);
        ArrayList<String> temp=getProfileFromFile("contactInfo.json",getContext());
        String s="PHONE NUMBER: ";
        SpannableString t1=new SpannableString(s);
        t1.setSpan(new StyleSpan(Typeface.BOLD), 0, t1.length(), 0);
        textView.setText(t1);
        textView.append(temp.get(0));

        TextView textView1 = (TextView) rootView.findViewById(id.edit_con1);
        String s1="PHONE NUMBER: ";
        SpannableString t2=new SpannableString(s1);
        t2.setSpan(new StyleSpan(Typeface.BOLD), 0, t2.length(), 0);
        textView1.setText(t2);
        textView1.append(temp.get(1));

        TextView textView2 = (TextView) rootView.findViewById(id.edit_con2);
        String s3="ADDRESS: ";
        SpannableString t3=new SpannableString(s3);
        t3.setSpan(new StyleSpan(Typeface.BOLD), 0, t3.length(), 0);
        textView2.setText(t3);
        textView2.append(temp.get(2));

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

            jsonString.add(0,json.getString("contact"));
            jsonString.add(1,json.getString("emailId"));
           // System.out.println(json.getString("emailId"));
            jsonString.add(2,json.getString("address"));
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
