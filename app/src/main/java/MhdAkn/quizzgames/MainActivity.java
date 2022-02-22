package MhdAkn.quizzgames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //instanciation de la listview
    ListView ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Affichage de ma listview
        ls = findViewById(R.id.list);

        //composant de la listview stockee dans un string
        String[] categories = new String[]{"Culture générale", "Informatique", "Musique", "Sport", "Littérature", "Score"};

        //creation d'un adaptateur pour lier entre ces elements
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.categorie, R.id.cat, categories);

        //affecter a notre liste cet adaptateur
        ls.setAdapter(adapter);

        //gestion de click sur item
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = (String) ls.getAdapter().getItem(position);
                if (position == 0) {
                    startActivity(new Intent(MainActivity.this, quizCulture.class));
                } else if (position == 1) {
                    startActivity(new Intent(MainActivity.this, quizInformatique.class));
                } else if (position == 2) {
                    startActivity(new Intent(MainActivity.this, quizMusique.class));
                } else if (position == 3) {
                    startActivity(new Intent(MainActivity.this, quizSport.class));
                } else if (position == 4) {
                    startActivity(new Intent(MainActivity.this, quizLitterature.class));
                } else if (position == 5) {
                startActivity(new Intent(MainActivity.this, ViewScore.class));
            }
            }


        });

    }
}