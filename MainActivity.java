package com.app.bottomnavigationexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.app.bottomnavigationexample.fragment.HomeFragment;
import com.app.bottomnavigationexample.fragment.NotificationFragment;
import com.app.bottomnavigationexample.fragment.ProfileFragment;
import com.app.bottomnavigationexample.fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.bottom_navigation);

        showFragment(new HomeFragment());

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.action_home:
                        showFragment(new HomeFragment());
                        break;
                    case R.id.action_profile:
                        showFragment(new ProfileFragment());
                        break;
                    case R.id.action_notification:
                        showFragment(new NotificationFragment());
                        break;
                    case R.id.action_search:
                        showFragment(new SearchFragment());
                        break;
                }

                return true;
            }
        });

    }

    public void showFragment(Fragment fragment)
    {
        FragmentManager manager= getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment, null);
        transaction.commit();
    }

}