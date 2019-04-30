package com.mastre.foodrecipes;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mastre.foodrecipes.models.Recipe;
import com.mastre.foodrecipes.requests.RecipeApi;
import com.mastre.foodrecipes.requests.ServiceGenerator;
import com.mastre.foodrecipes.requests.responses.RecipeResponse;
import com.mastre.foodrecipes.util.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeListActivity extends BaseActivity {

    private static final String TAG = "RecipeListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipe_list);

        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (mProgressBar.getVisibility() == View.VISIBLE) {
//                    showProgressBar(false);
//                } else {
//                    showProgressBar(true);
//                }
                testRetrofitRequest();
            }
        });
    }

    private void testRetrofitRequest() {
        RecipeApi recipeApi = ServiceGenerator.getRecipeApi();

//        Call<RecipeSearchResponse> responseCall = recipeApi.searchRecipe(
//                Constants.API_KEY_0,
//                "kimchi",
//                "1"
//        );
//
//        responseCall.enqueue(new Callback<RecipeSearchResponse>() {
//            @Override
//            public void onResponse(Call<RecipeSearchResponse> call, Response<RecipeSearchResponse> response) {
//                Log.e(TAG, "onResponse: server response " + response.toString());
//                if (response.code() == 200) {
//                    Log.e(TAG, "onResponse: " + response.body());
//                    List<Recipe> recipes = new ArrayList<>(response.body().getRecipes());
//                    for (Recipe recipe : recipes) {
//                        Log.e(TAG, "onResponse: : " + recipe.getTitle());
//                    }
//                } else {
//                    Log.e(TAG, "onResponse: " + response.errorBody());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<RecipeSearchResponse> call, Throwable t) {
//
//            }
//        });

        Call<RecipeResponse> responseCall = recipeApi.getRecipe(
                Constants.API_KEY_0,
                "85e8d6"

        );

        responseCall.enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                Log.e(TAG, "onResponse: server response " + response.toString());
                if (response.code() == 200) {
                    Log.e(TAG, "onResponse: " + response.body());
                    Recipe recipe = response.body().getRecipe();
                    Log.d(TAG, "onResponse: RETREIVED RECIPE : " + recipe.toString());

                } else {
                    Log.e(TAG, "onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {

            }
        });

    }
}
