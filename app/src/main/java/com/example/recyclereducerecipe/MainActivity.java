package com.example.recyclereducerecipe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    View createRecipe;
    View selectRecipe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //createRecipe = findViewById(R.id.create);
        //selectRecipe = findViewById(R.id.select);

    }

    public void CreateThisRecipe(View view){
        //TODO: go to creation view
    }

    public void GoToRecipeList(View view){
        // TODO: go to recipelist view
    }



}
