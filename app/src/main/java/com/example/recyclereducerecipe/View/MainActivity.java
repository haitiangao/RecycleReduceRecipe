package com.example.recyclereducerecipe.View;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.recyclereducerecipe.R;


public class MainActivity extends AppCompatActivity {


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
