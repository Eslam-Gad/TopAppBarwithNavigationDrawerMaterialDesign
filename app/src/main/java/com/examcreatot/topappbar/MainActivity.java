package com.examcreatot.topappbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private MaterialToolbar topToolbar;
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topToolbar = findViewById(R.id.topAppBar);
        drawerLayout = findViewById(R.id.drawerlayout);

        NavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);


        // for animating navigation icon
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this , drawerLayout , topToolbar,
                R.string.navigation_drawer_open , R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        topToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT , true);
            }
        });


        topToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.favorite:
                        print_msg("favorite icon clicked !!");
                        break;
                    case R.id.search:
                        print_msg("search icon clicked !!");
                        break;
                    case R.id.more:
                        print_msg("more icon clicked !!");
                        break;
                }
                return false;
            }
        });

    }


    private void print_msg(String msg){
        Toast.makeText(MainActivity.this, msg , Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.home:
                print_msg("Home clicked !!");
                Log.d("hometag" , "ok home");
                break;
            case R.id.fav:
                print_msg("favorite clicked !!");
                Log.d("hometag" , "ok home");
                break;
            case R.id.sear:
                print_msg("search clicked !!");
                break;
            case R.id.Profile:
                print_msg("Profile clicked !!");
                break;
            case R.id.Settings:
                print_msg("Settings clicked !!");
                break;
            case R.id.trash:
                print_msg("trash clicked !!");
                break;
        }

        return true;
    }

}
