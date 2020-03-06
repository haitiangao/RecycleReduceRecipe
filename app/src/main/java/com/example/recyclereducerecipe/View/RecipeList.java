package com.example.recyclereducerecipe.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.recyclereducerecipe.Adapter.RecipeListAdapter;
import com.example.recyclereducerecipe.R;
import com.example.recyclereducerecipe.model.Recipe;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeList extends AppCompatActivity {

    private String delimiter = ";";
    private String fileName = "save.sav";
    private Recipe recipe;
    private List<Recipe> recipeList= new ArrayList<Recipe>();

    @BindView(R.id.recycleRecipeList)
    RecyclerView recycleRecipeView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        ButterKnife.bind(this);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, RecyclerView.VERTICAL);
        recycleRecipeView.setLayoutManager(new LinearLayoutManager(this));
        recycleRecipeView.setAdapter(new RecipeListAdapter(recipeList));
        recycleRecipeView.addItemDecoration(itemDecoration);
        try {
            readFromInternal();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //not necessary here but here as a example
    private void writeToInternal(Recipe recipe) throws IOException{
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

    private void readFromInternal() throws IOException{
        FileReader reader = new FileReader(getFilesDir().getPath()+"/"+fileName);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String currentRecipe = null;
        while((currentRecipe = bufferedReader.readLine())!=null){
            Log.d("TAG_FIRE", "Current fruit: "+currentRecipe);
            String [] re = currentRecipe.split(delimiter);
            ArrayList<String> inLi = new ArrayList();

            for (int i =1; i<re.length; i++){
                inLi.add(re[i]);
            }
            Recipe recipe = new Recipe(re[0], inLi);
            recipeList.add(recipe);
        }
        bufferedReader.close();
        reader.close();
        refreshView();

    }


    private void refreshView(){
        RecipeListAdapter recyclerAdaptor = new RecipeListAdapter(recipeList);
        recycleRecipeView.setAdapter(null);
        recycleRecipeView.setAdapter(recyclerAdaptor);
        recyclerAdaptor.notifyDataSetChanged();
    }

}
