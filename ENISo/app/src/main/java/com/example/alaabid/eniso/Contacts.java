package com.example.alaabid.eniso;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.alaabid.eniso.EventSchedulerPackage.EventAdapter;
import com.example.alaabid.eniso.EventSchedulerPackage.EventDialog;
import com.example.alaabid.eniso.EventSchedulerPackage.EventModel;
import com.example.alaabid.eniso.EventSchedulerPackage.MySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contacts extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar=null;
    String nom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle extras = getIntent().getExtras();
        nom = extras.getString("nom");


        //***********************************************************
        //*******************CODE HERE*******************************
        //*******************inside of onCreate()********************







        //**********************END CODE***************************
        //***********************************************************

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = headerView.findViewById(R.id.navUsrName);
        navUsername.setText(nom);
        navigationView.setNavigationItemSelectedListener(this);
    }


    //***************************CODE HERE *************************************
    //************************outside of onCreate()*****************************
    //**************************************************************************


















    //******************************END CODE******************************************
    //*********************************************************************************


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    /*@Override
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
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){


            case R.id.nav_home:
                Intent h= new Intent(getApplicationContext(),Home.class);
                h.putExtra("nom", nom);
                startActivityForResult(h, 1);
                break;
            case R.id.nav_Documents:
                Intent i= new Intent(getApplicationContext(),Documents.class);
                i.putExtra("nom", nom);
                startActivityForResult(i, 1);
                break;
            case R.id.nav_contact:
                Intent g= new Intent(getApplicationContext(),Contacts.class);
                g.putExtra("nom", nom);
                startActivityForResult(g, 1);
                break;
            case R.id.nav_Timetable:
                Intent s= new Intent(getApplicationContext(),Emploi.class);
                s.putExtra("nom", nom);
                startActivityForResult(s, 1);
                break;
            case R.id.nav_Profil:
                Intent t= new Intent(getApplicationContext(),Profil.class);
                t.putExtra("nom", nom);
                startActivityForResult(t, 1);
                break;
            case R.id.nav_scheduler:
                Intent x= new Intent(getApplicationContext(),Event.class);
                x.putExtra("nom", nom);
                startActivityForResult(x, 1);
                break;

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}