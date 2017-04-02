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
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ScrollView;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Project extends Fragment {


    public Project() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = (View)inflater.inflate(R.layout.fragment_project, container, false);
        System.out.println(rootView.isVerticalScrollBarEnabled());
        LinearLayout ll= (LinearLayout) rootView.findViewById(R.id.lv);
        ArrayList<String> temp=getProfileFromFile("project.json",getContext());

        SpannableString t1=new SpannableString(temp.get(0));
        TextView textView = (TextView) rootView.findViewById(R.id.p1);
        t1.setSpan(new StyleSpan(Typeface.BOLD), 0, t1.length(), 0);
        textView.setText(t1);
        textView.append(temp.get(1));

        SpannableString t2=new SpannableString(temp.get(2));
        TextView textView1 = (TextView) rootView.findViewById(R.id.p2);
        t2.setSpan(new StyleSpan(Typeface.BOLD), 0, t2.length(), 0);
        textView1.setText(t2);
        textView1.append(temp.get(3));

        SpannableString t3=new SpannableString(temp.get(4));
        TextView textView2 = (TextView) rootView.findViewById(R.id.p3);
        t3.setSpan(new StyleSpan(Typeface.BOLD), 0, t3.length(), 0);
        textView2.setText(t3);
        textView2.append(temp.get(5));

        SpannableString t4=new SpannableString(temp.get(6));
        TextView textView3 = (TextView) rootView.findViewById(R.id.p4);
        t4.setSpan(new StyleSpan(Typeface.BOLD), 0, t4.length(), 0);
        textView3.setText(t4);
        textView3.append(temp.get(7));



        //System.out.println(temp.get(1));

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
            jsonString.add(0,json.getString("T1"));
            //System.out.println(json.getString("T1"));
            jsonString.add(1,json.getString("P1"));
            jsonString.add(2,json.getString("T2"));
            jsonString.add(3,json.getString("P2"));
            jsonString.add(4,json.getString("T3"));
            jsonString.add(5,json.getString("P3"));
            jsonString.add(6,json.getString("T4"));
            jsonString.add(7,json.getString("P4"));

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
