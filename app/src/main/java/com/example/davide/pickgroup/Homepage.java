package com.example.davide.pickgroup;




import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Homepage extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;



    private android.app.Fragment fragment = null;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    private EditText txtInput;
    private ExpandableListView expListView;
    private HashMap<String, List<String>> listDataChild;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    static int[] icon = { R.drawable.profilo,R.drawable.esami,R.drawable.statistiche,R.drawable.impostazioni,R.drawable.logout};

    private TypedArray navMenuIcons;
    View view_Group;
    private static final int FILTER_ID = 0;

    private CharSequence mDrawerTitle;


    private CharSequence mTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage2);

        ListView listView = (ListView) findViewById(R.id.listv);

        String[] items = {"Italiano"};
        arrayList = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(this,R.layout.list_lingue,R.id.txtlistalingue,arrayList);
        listView.setAdapter(adapter);
        txtInput = (EditText) findViewById(R.id.etlingua);
        Button btAdd = (Button) findViewById(R.id.btnlingua);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = txtInput.getText().toString();
                arrayList.add(newItem);
                adapter.notifyDataSetChanged();
            }
        });


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.open,R.string.closse);

    NavigationView nv = (NavigationView) findViewById(R.id.menu);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case (R.id.logout):
                        Intent in = new Intent(Homepage.this,MainActivity.class);
                        Homepage.this.startActivity(in);

                   // case (R.id.profilo):


                }
                return true;
            }
        });




    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState); // Sync the toggle state after
        // onRestoreInstanceState has
        // occurred.
        mToggle.syncState();
    }


    @Override
   public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
