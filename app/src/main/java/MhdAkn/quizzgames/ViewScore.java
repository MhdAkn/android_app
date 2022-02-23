package MhdAkn.quizzgames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.widget.TextView;
import android.widget.Toast;



import java.io.IOException;
import java.io.InputStream;
public class ViewScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_score);

        TextView name = findViewById(R.id.playerName);
        TextView categorie  = findViewById(R.id.categorieName);
        TextView score = findViewById(R.id.score);

        String json= null;
        InputStream jsonFile= null;

        Intent intent = getIntent();
        int position = (int) intent.getExtras().get("position");

        try {
            jsonFile = getAssets().open("player.json");
            int size = jsonFile.available();
            byte[] buffer = new byte[size];
            jsonFile.read(buffer);
            jsonFile.close();
            json = new String(buffer, "UTF-8");
            JSONObject object = new JSONObject(json);

            name.setVisibility(View.VISIBLE);
            categorie.setVisibility(View.VISIBLE);
            score.setVisibility(View.VISIBLE);

            JSONArray childArray = object.getJSONArray("players");
            for (int i = 0; i < childArray.length(); i++) {
                if (position == i){
                    name.setText(childArray.getJSONObject(i).getString("playername"));
                    categorie.setText(childArray.getJSONObject(i).getString("categorieName"));
                    score.setText(childArray.getJSONObject(i).getString("score"));


                }

                //Toast.makeText(this, ""+childArray.getJSONObject(i).getString("nom"), Toast.LENGTH_SHORT).show();
            }



            //outputnom.setText(json);

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}