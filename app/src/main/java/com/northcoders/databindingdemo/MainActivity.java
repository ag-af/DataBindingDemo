package com.northcoders.databindingdemo;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.northcoders.databindingdemo.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    ListView listView;
    Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Person person = new Person("Simon", 18, "simon@northcoders.com");
        activityMainBinding.setPerson(person);

        //Finding the list
        listView = findViewById(R.id.person_list);
        //created the list
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Chris", 21, "chris@northcoders.com"));
        personList.add(new Person("Alex", 19, "alex@northcoders.com"));
        personList.add(new Person("Katherine", 12, "katherine@northcoders.com"));
        personList.add(new Person("Bela", 20, "bela@northcoders.com"));
        //adapter to display
        ListAdapter adapter = (new ArrayAdapter<>(this, R.layout.activity_main, R.id.name,personList));
        //display
        listView.setAdapter(adapter);

        switch1 = findViewById(R.id.darkModeSwitch);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode (AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });

    }
}