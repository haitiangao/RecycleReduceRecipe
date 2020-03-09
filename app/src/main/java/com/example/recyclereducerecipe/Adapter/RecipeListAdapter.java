package com.example.recyclereducerecipe.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclereducerecipe.R;
import com.example.recyclereducerecipe.model.Recipe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {

    private List<Recipe> recipeList;
    private UserClickListener userClickListener;

    public RecipeListAdapter(List<Recipe> recipeList, UserClickListener userClickListener){
        this.recipeList = recipeList;
        this.userClickListener = userClickListener;

    }

    public interface UserClickListener {
        void displayUser(Recipe recipe);
    }

    @NonNull
    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_list_item_layout, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeListAdapter.RecipeViewHolder holder, int position) {
        holder.individualRecipe.setText(recipeList.get(position).getRecipeName());
        holder.itemView.setOnClickListener(view -> {
            userClickListener.displayUser(recipeList.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }



    class RecipeViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.individualRecipe)
        TextView individualRecipe;


        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
