package com.example.recyclereducerecipe.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.recyclereducerecipe.Adapter.MakeRecipeAdapter;
import com.example.recyclereducerecipe.R;
import com.example.recyclereducerecipe.model.Recipe;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeCreateEditView extends AppCompatActivity {

    private ArrayList<String> ingredientsList = new ArrayList<String>();

    private String delimiter = ";";
    private String fileName = "save.sav";

    @BindView(R.id.recyclerIngredientList)
    RecyclerView ingredientListView;

    @BindView(R.id.ingredientText)
    EditText thisIngredient;

    @BindView(R.id.recipeSingleName)
    EditText singleRecipeName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_create_edit_view);

        ButterKnife.bind(this);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, RecyclerView.VERTICAL);
        ingredientListView.setLayoutManager(new LinearLayoutManager(this));
        ingredientListView.setAdapter(new MakeRecipeAdapter(ingredientsList));
        ingredientListView.addItemDecoration(itemDecoration);

        thisIngredient.setText("");

    }

    public void addIngredient(View view){
        ingredientsList.add(thisIngredient.getText().toString().trim());
        refreshView();
    }

    public void finalizeRecipe(View view) throws IOException {
        Recipe recipe = new Recipe(singleRecipeName.getText().toString(),ingredientsList);
        writeToInternal(recipe);
        finish();
    }

    private void writeToInternal(Recipe recipe) throws IOException {
        FileOutputStream fileOS = openFileOutput(fileName, Context.MODE_APPEND);
        String recipeString = recipe.getRecipeName()+delimiter;

        for (int i=0; i<recipe.getRecipeIngredients().size();i++){
            recipeString = recipeString+recipe.getRecipeIngredients().get(i)+delimiter;
        }
        recipeString=recipeString+"\n";

        byte[] recipeStringBytes = recipeString.getBytes();
        fileOS.write(recipeStringBytes);
        fileOS.close();
    }


    private void refreshView(){

        MakeRecipeAdapter recycleAdaptor = new MakeRecipeAdapter(ingredientsList);
        ingredientListView.setAdapter(null);
        ingredientListView.setAdapter(recycleAdaptor);
        recycleAdaptor.notifyDataSetChanged();

    }


}
