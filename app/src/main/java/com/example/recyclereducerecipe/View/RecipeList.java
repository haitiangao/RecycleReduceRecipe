package com.example.recyclereducerecipe.View;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.recyclereducerecipe.R;
import com.example.recyclereducerecipe.model.Recipe;

public class RecipeList extends AppCompatActivity {

    private Recipe recipe;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);


    }
}
