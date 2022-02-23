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
    ArrayList<Object> laliste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        /*TextView outputNom = findViewById(R.id.playerName);
        TextView outputCat = findViewById(R.id.categorieName);
        TextView outputScore= findViewById(R.id.score);
*/
        list = findViewById(R.id.listDefault);
        laliste = new ArrayList<Object>();

        String json ;
        InputStream jsonFile ;

        //Intent intent = getIntent();
        //int position = (int) intent.getExtras().get("position");

        try {
            jsonFile =this.getAssets().open("player.json");
            int size = jsonFile.available();
            byte[] buffer = new byte[size];
            jsonFile.read(buffer);
            jsonFile.close();
            json = new String(buffer, "UTF-8");
            JSONObject object = new JSONObject(json);

           /* outputNom.setVisibility(View.VISIBLE);
            outputCat.setVisibility(View.VISIBLE);
            outputScore.setVisibility(View.VISIBLE);*/


            JSONArray childArray = object.getJSONArray("players");
            for (int i = 0; i < childArray.length(); i++) {
                laliste.add(childArray.getJSONObject(i).getString("playername"));

            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        final ArrayAdapter<Object> adapter= new ArrayAdapter<Object>(this, android.R.layout.simple_list_item_1,laliste);
        list.setAdapter(adapter);
        list.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(),ViewScore.class);
                intent.putExtra("position",position);
                if(intent !=null){
                    startActivity(intent);
                }
            }
        });
    }
}