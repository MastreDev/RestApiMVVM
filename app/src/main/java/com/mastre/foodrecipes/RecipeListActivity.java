package com.mastre.foodrecipes;

import android.os.Bundle;
import android.view.View;

public class RecipeListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipe_list);

        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mProgressBar.getVisibility() == View.VISIBLE) {
                    showProgressBar(false);
                } else {
                    showProgressBar(true);
                }
            }
        });
    }
}
