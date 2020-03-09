package com.example.recyclereducerecipe.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclereducerecipe.Adapter.ViewRecipeIngredientAdapter;
import com.example.recyclereducerecipe.model.Recipe;

import java.util.ArrayList;
import java.util.List;

import com.example.recyclereducerecipe.R;


public class DisplayIngredient extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Recipe> recipeList = new ArrayList<Recipe>();
    public static final String RECIPE_KEY ="get.recipe.info";
    private Recipe recipe;
    private static String LOG_TAG = "MainActivity";
    private TextView myTextView;
    String[] recipename = {"Burrito", "Chicken Sandwhich", "Hamburger", "Greek Salad", "Manacotti", "Pizza", "Roast_Beef"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.r_layout);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ViewRecipeIngredientAdapter(recipeList);
        mRecyclerView.setAdapter(mAdapter);

        Intent intent = getIntent();
        recipe =intent.getParcelableExtra(RECIPE_KEY);
    }


    @Override
    protected void onResume() {
        super.onResume();
        ((ViewRecipeIngredientAdapter) mAdapter).setOnItemClickListener(new ViewRecipeIngredientAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);
                String name = (recipename[position]);
                Toast.makeText(DisplayIngredient.this, name + " was clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
