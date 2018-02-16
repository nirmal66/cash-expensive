package com.yourapp.developer.expensivemanager;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.yourapp.developer.expensivemanager.Fragment.AddExpensiveFragment;
import com.yourapp.developer.expensivemanager.Fragment.ChatFragment;
import com.yourapp.developer.expensivemanager.Fragment.ContactFragment;
import com.yourapp.developer.expensivemanager.Fragment.ListFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private String tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fragment(new ListFragment(), "ListFragment");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment(new AddExpensiveFragment(), "ContactFragment");

                Snackbar.make(view, "Add your Expensive :)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            String tag = getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName();
            //Toast.makeText(this,tag,Toast.LENGTH_LONG).show();
            if (tag.equals("ListFragment")) {
                finish();
            }
            else {
                if (getFragmentManager().getBackStackEntryCount() > 0) {
                    getFragmentManager().popBackStack();
                } else {
                    super.onBackPressed();
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return false;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_send) {
            fragment(new ContactFragment(), "ContactFragment");
        }
        if (id == R.id.nav_chart) {
            fragment(new ChatFragment(), "ChatFragment");
        }

        if (id == R.id.nav_home) {
            fragment(new ListFragment(), "ListFragment");
        }

      /*  if(id==R.id.nav_backup)
        {
            File fileBackup = new File(Environment
                    .getExternalStorageDirectory()
                    + "/expensivemanager.db");

            try {
                fileBackup.createNewFile();
                FileChannel src = new FileInputStream(fileBackup)
                        .getChannel();
                FileChannel dst = new FileOutputStream(
                        "/data/data/com.yourapp.developer.expensivemanager/databases/expensivemanager.db")
                        .getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(id==R.id.nav_restore)
        {
            File fileBackup = new File(Environment
                    .getExternalStorageDirectory()
                    + "/expensivemanager.db");

            try {
                fileBackup.createNewFile();
                FileChannel src = new FileInputStream(fileBackup)
                        .getChannel();
                FileChannel dst = new FileOutputStream(
                        "/data/data/com.yourapp.developer.expensivemanager/databases/expensivemanager.db")
                        .getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void fragment(Fragment fragment, String transaction) {
        tag = transaction;
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_transaction, fragment, transaction);
        fragmentTransaction.addToBackStack(transaction);
        fragmentTransaction.commit();
        Log.d("backFragment", tag);
    }

}
