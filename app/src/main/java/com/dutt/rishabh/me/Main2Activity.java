package com.dutt.rishabh.me;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

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

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

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
     */
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
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
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final DatabaseHelper dbHelper=new DatabaseHelper(getActivity());
            final TextView t1,t2,t3,t4,t5,t6,t7,t8;
            if(getArguments().getInt(ARG_SECTION_NUMBER)==1) {
                View rootView = inflater.inflate(R.layout.fragment_main2, container, false);
                t1=(TextView) rootView.findViewById(R.id.t2);
                t2=(TextView) rootView.findViewById(R.id.t4);
                t3=(TextView) rootView.findViewById(R.id.t6);
                t1.setText(Main3Activity.info[1]);
                t2.setText(Main3Activity.info[2]);
                t3.setText(Main3Activity.info[3]);
                return rootView;
            }
            if(getArguments().getInt(ARG_SECTION_NUMBER)==2){
                View view=inflater.inflate(R.layout.fragment_pg2, container,false);
                t4=(TextView) view.findViewById(R.id.txt2);
                t4.setText(Main3Activity.info[4]);
                return view;
            }
            if(getArguments().getInt(ARG_SECTION_NUMBER)==3){
                View view1=inflater.inflate(R.layout.fragment_pg3,container,false);
                t5=(TextView) view1.findViewById(R.id.x2);
                t5.setText(Main3Activity.info[5]);
                return view1;
            }
            if(getArguments().getInt(ARG_SECTION_NUMBER)==4){
                View view=inflater.inflate(R.layout.fragment_pg4,container,false);
                t6=(TextView) view.findViewById(R.id.x4);
                t6.setText(Main3Activity.info[6]);
                return view;
            }
            if(getArguments().getInt(ARG_SECTION_NUMBER)==5){
                View view=inflater.inflate(R.layout.fragment_pg5,container,false);
                t7=(TextView) view.findViewById(R.id.x6);
                t7.setText(Main3Activity.info[7]);
                return view;
            }
            if(getArguments().getInt(ARG_SECTION_NUMBER)==6){
                View view=inflater.inflate(R.layout.fragment_pg6,container,false);
                t8=(TextView) view.findViewById(R.id.x8);
                t8.setText(Main3Activity.info[8]);
                Button bt=(Button) view.findViewById(R.id.back);
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                            Intent k=new Intent(getActivity().getApplicationContext(),MainActivity.class);
                            startActivity(k);
                    }
                });
                return view;
            }
            return null;
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

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "ABOUT ME";
                case 1:
                    return "SKILLS";
                case 2:
                    return "ACHIEVEMENT";
                case 3:
                    return "EXPERIENCE";
                case 4:
                    return "WHY ANDROID?";
                case 5:
                    return "DREAM PROJECT";
            }
            return null;
        }
    }
}
