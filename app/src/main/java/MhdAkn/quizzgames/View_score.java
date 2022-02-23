package MhdAkn.quizzgames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class View_score extends AppCompatActivity {
    //declaration des objets et types List
    List<Score> ScoreList =new ArrayList<>();
    ArrayList<Object> laliste;
    List<Score> ScoreItemList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_score2);
        //instanciation de la liste
        laliste = new ArrayList<Object>();
        // declaration des variables pour la manipulation du fichier
        String json ;
        InputStream jsonFile ;
        //Lecture du fichier json
        try {
            jsonFile =this.getAssets().open("player.json");
            int size = jsonFile.available();
            byte[] buffer = new byte[size];
            jsonFile.read(buffer);
            jsonFile.close();
            json = new String(buffer, "UTF-8");
            //  affichage du contenu du fichier json au nniveau de la liste itermediaire
            JSONObject object = new JSONObject(json);
            JSONArray childArray = object.getJSONArray("players");
            for (int i = 0; i < childArray.length(); i++) {
                //recuperation des donnes depuis le fichier
                String nom = childArray.getJSONObject(i).getString("playername");
                String cat =childArray.getJSONObject(i).getString("categorieName");
                String sc =childArray.getJSONObject(i).getString("score");
                //affichage dans la listview
                ScoreList.add(new Score(nom,cat,sc));
                ListView listViewSc = findViewById(R.id.maliste);
                listViewSc.setAdapter(new scoreAdapter(this,ScoreList));

            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

    }

}