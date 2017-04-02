package com.example.android.cvbuild;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context mContext = this;

    public Context getContext() {
        return mContext;
    }


    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     * <p>
     * encapsulate different menu screens. Each screen will have different fragment
     */
    private ViewPager mViewPager;

    @Override
    //Oncreate is the first method used -- Bundle is class which is used to save the infomation of the state of
    //activity for any changes. it does not have its own constructor so calls the parent's constructor.SetContentView
    //is the method used to extract view info from xml file.If this method is not called then default param are set.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //set toolbar to act as a action bar from activity window
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the seven
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filename="BHAKTI_SHAH_RESUME.pdf";
                File filelocation = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), filename);
                Uri path = Uri.fromFile(filelocation);
                Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Bhakti_Shah_Resume");
                emailIntent .putExtra(Intent.EXTRA_STREAM, path);
                startActivity(Intent.createChooser(emailIntent, "Send your email in:"));

            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";



        public PlaceholderFragment() {

        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);

            switch (sectionNumber) {
                case 0:

                   return new Profile_f();

                case 1:
                    return new Contact_f();
                case 2:
                    return new Academic_f();
                case 3:
                    return new Project();
                case 4:
                    return new WorkX();
                case 5:
                    return new ExtraCir_f();
                case 6:
                    return new Reference_f();

            }

//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
////
//            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
//            return rootView;
//        }
            return fragment;
        }
    }

        /**
         * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
         * one of the sections/tabs/pages.
         */
        public class SectionsPagerAdapter extends FragmentPagerAdapter {

            public SectionsPagerAdapter(FragmentManager fm) {
                super(fm);
            }

            ///*
            @Override
            public Fragment getItem(int position) {
                // getItem is called to instantiate the fragment for the given page.
                // Return a PlaceholderFragment (defined as a static inner class below).

                return PlaceholderFragment.newInstance(position);
            }

            //*/
            @Override
            //in Build method which return no. of pages to be created.
            public int getCount() {
                // Show 7 total pages.
                return 7;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "PROFILE";
                    case 1:
                        return "CONTACT ME";
                    case 2:
                        return "ACADEMICS";
                    case 3:
                        return "PROJECTS";
                    case 4:
                        return "WORK EXPERIENCE";

                    case 5:
                        return "TECHNICAL SKILLS";
                    case 6:
                        return "REFERNCE";


                }
                return null;
            }
        }
    }


