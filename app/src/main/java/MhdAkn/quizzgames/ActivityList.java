package MhdAkn.quizzgames;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ActivityList extends AppCompatActivity {
    ListView list;
    //declaration d'un arraylist
    ArrayList<Object> laliste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        list = findViewById(R.id.listDefault);
        laliste = new ArrayList<Object>();

        String json ;
        InputStream jsonFile ;
//lecture contenu du fichier json
        try {
            jsonFile =this.getAssets().open("player.json");
            int size = jsonFile.available();
            byte[] buffer = new byte[size];
            jsonFile.read(buffer);
            jsonFile.close();
            json = new String(buffer, "UTF-8");
            JSONObject object = new JSONObject(json);

            JSONArray childArray = object.getJSONArray("players");
            //  affichage du contenu du fichier json au nniveau de la liste itermediaire
            for (int i = 0; i < childArray.length(); i++) {
                laliste.add(childArray.getJSONObject(i).getString("playername"));

            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        final ArrayAdapter<Object> adapter= new ArrayAdapter<Object>(this, android.R.layout.simple_list_item_1,laliste);
        list.setAdapter(adapter);
        list.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        //action de click direction vers l'activité correspondante
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    startActivity(new Intent(ActivityList.this, quizCulture.class));
                }
                if (position == 1) {
                    startActivity(new Intent(ActivityList.this,quizInformatique.class));
                }
                else if ((position == 2 ) /*(itemCateg == "Informatique")*/) {
                    startActivity(new Intent(ActivityList.this, quizMusique.class));
                }
                else if ((position == 3) /*itemCateg == "Musique"*/) {
                    startActivity(new Intent(ActivityList.this, quizLitterature.class));
                }
                else if ((position == 4 ) /*itemCateg == "Sport"*/) {
                    startActivity(new Intent(ActivityList.this, quizSport.class));
                }
            }
        });

    }
}