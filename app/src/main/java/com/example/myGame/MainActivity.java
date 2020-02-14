package com.example.myGame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buttonValidation;
    private EditText labelForeditTextChoixNombre;
    private TextView textViewComment;
    private ProgressBar progressbarTentatives;
    private TextView textViewTentatives;
    private ListView listViewHistorique;
    private TextView textViewScore;
    private int secret;
    private int counter;
    private int score;
    private List<String> listHistorique = new ArrayList<>();
    private int maxTentatives = 6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonValidation = findViewById(R.id.buttonValidation);
        labelForeditTextChoixNombre = findViewById(R.id.LabelForeditTextChoixNombre);
        textViewComment = findViewById(R.id.textViewComment);
        progressbarTentatives = findViewById(R.id.progressBar);
        textViewTentatives = findViewById(R.id.textViewAfficher);
        listViewHistorique = findViewById(R.id.listboxItems);
        textViewScore = findViewById(R.id.textViewScoreDevinez);

        initialisation();
        buttonValidation.setOnClickListener(( evt ) -> {


            int number = Integer.parseInt((labelForeditTextChoixNombre.getText().toString()));

            if (number < secret)
            {

                textViewComment.setText(R.string.sup);
            }
            else if (number > secret) {
                textViewComment.setText(R.string.inf);
            } else {
                textViewComment.setText(R.string.exact);
                score += 5;
                textViewScore.setText(String.valueOf(score));

            }

            ++counter;
            textViewTentatives.setText(String.valueOf(counter));
            progressbarTentatives.setProgress(counter);


            if (counter < maxTentatives) {
                rejouer();
            }

        });


    }
        private void rejouer ()

        {
            Log.i("MyLog", "REJOUER...");

        }


        private void initialisation ()
        {
            Random rand = new Random();
            secret = rand.nextInt(100);

            counter = 1;
            textViewTentatives.setText((String.valueOf(counter)));
            progressbarTentatives.setProgress(counter);
            progressbarTentatives.setMax(maxTentatives);
            textViewScore.setText(String.valueOf(score));


        }


    }
