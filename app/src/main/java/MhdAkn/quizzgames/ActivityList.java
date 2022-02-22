package MhdAkn.quizzgames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ActivityList extends AppCompatActivity {
    int positionRemove = -1;
    ListView simpleListView;
    ArrayList<Object> laliste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        String json = null;
        InputStream jsonFile = null;

        simpleListView = (ListView) findViewById(R.id.listDefault);
        laliste = new ArrayList<Object>();

        try {
            jsonFile = getAssets().open("player.json");
            int size = jsonFile.available();
            byte[] buffer = new byte[size];
            jsonFile.read(buffer);
            jsonFile.close();
            json = new String(buffer, "UTF-8");
            JSONObject object = new JSONObject(json);

            JSONArray childArray = object.getJSONArray("players");
            for (int i = 0; i < childArray.length(); i++) {
                //laliste.listIterator(Integer.parseInt(childArray.getJSONObject(i).getString("prenom")));
                laliste.add(childArray.getJSONObject(i).getString("playerName"));
            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        simpleListView = (ListView) findViewById(R.id.listDefault);
        final ArrayAdapter<Object> adapter = new ArrayAdapter<Object>(this, android.R.layout.simple_list_item_1, laliste);
        simpleListView.setAdapter(adapter);
        simpleListView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CallFunc(position);
            }
        });
    }
    private void CallFunc(int position) {
        Intent intent = null;
        intent = new Intent(getBaseContext(),ViewScore.class);
        intent.putExtra("position",position);
        if (intent != null)
            startActivity(intent);
    }

}