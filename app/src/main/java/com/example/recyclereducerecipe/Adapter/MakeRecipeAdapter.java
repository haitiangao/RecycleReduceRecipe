package com.example.recyclereducerecipe.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclereducerecipe.R;
import com.example.recyclereducerecipe.model.Recipe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MakeRecipeAdapter extends RecyclerView.Adapter<MakeRecipeAdapter.IngredientViewHolder> {
    private List<String> ingredientList;


    public MakeRecipeAdapter(List<String> ingredientList){
        this.ingredientList = ingredientList;
    }

    @NonNull
    @Override
    public MakeRecipeAdapter.IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_list_item_layout, parent, false);
        return new MakeRecipeAdapter.IngredientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientViewHolder holder, int position) {
        holder.individualRecipe.setText(ingredientList.get(position));

    }

    @Override
    public int getItemCount() {
        if (ingredientList.isEmpty())
            return 0;
        else
            return ingredientList.size();
    }

    class IngredientViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.individualRecipe)
        TextView individualRecipe;


        public IngredientViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
