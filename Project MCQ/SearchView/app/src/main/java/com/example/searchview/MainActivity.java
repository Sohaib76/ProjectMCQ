package com.example.searchview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    ArrayAdapter<String> myAdapter;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = (ListView) findViewById(R.id.listView);

        ArrayList<String> arraylist = new ArrayList<>();
        arraylist.addAll(Arrays.asList(getResources().getStringArray(R.array.MCQs)));

        myAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arraylist);

        myListView.setAdapter(myAdapter);


        // opening new activities

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //  if conditions start

                // 0
                if (i == 0){
                    Intent intent = new Intent(MainActivity.this, Electrical.class);
                    startActivity(intent);
                }
                // 1
                if (i == 1){
                    Intent intent = new Intent(MainActivity.this, Current.class);
                    startActivity(intent);
                }
                if (i == 2){
                    Intent intent = new Intent(MainActivity.this, Charges.class);
                    startActivity(intent);
                }
                if (i == 3){
                    Intent intent = new Intent(MainActivity.this,Focal_Length.class);
                    startActivity(intent);
                }if (i == 4){
                    Intent intent = new Intent(MainActivity.this,Light.class);
                    startActivity(intent);
                }if (i == 5){
                    Intent intent = new Intent(MainActivity.this,Spring_System.class);
                    startActivity(intent);
                }if (i == 6){
                    Intent intent = new Intent(MainActivity.this,Transformer.class);
                    startActivity(intent);
                }if (i == 7){
                    Intent intent = new Intent(MainActivity.this,Waves.class);
                    startActivity(intent);
                }if (i == 8){
                    Intent intent = new Intent(MainActivity.this,Resistance.class);
                    startActivity(intent);
                }if (i == 9){
                    Intent intent = new Intent(MainActivity.this,IT.class);
                    startActivity(intent);
                }if (i == 10){
                    Intent intent = new Intent(MainActivity.this,Nuclear_Physics.class);
                    startActivity(intent);
                }if (i == 11){
                    Intent intent = new Intent(MainActivity.this,Pendulum.class);
                    startActivity(intent);
                }if (i == 12){
                    Intent intent = new Intent(MainActivity.this,Sound.class);
                    startActivity(intent);
                }if (i == 13){
                    Intent intent = new Intent(MainActivity.this,Quantities.class);
                    startActivity(intent);
                }if (i == 14){
                    Intent intent = new Intent(MainActivity.this,Volmeter.class);
                    startActivity(intent);
                }









            }
        });






    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search, menu);

        MenuItem item = menu.findItem(R.id.search_MCQ);

        SearchView mySearchView = (SearchView) item.getActionView();



        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {


            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                myAdapter.getFilter().filter(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }



}
