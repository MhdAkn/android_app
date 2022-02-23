package MhdAkn.quizzgames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class View_score extends AppCompatActivity {
    List<Score> ScoreList =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_score2);
        ScoreList.add(new Score("Sam","Culture générale","7/10"));
        ScoreList.add(new Score("Ameen","Informatique","8/10"));
        ScoreList.add(new Score("Andréa","Musique","5/10"));
        ScoreList.add(new Score("Sam","Littérature","7/10"));
        ScoreList.add(new Score("Mhd","Musqiue","9/10"));
        ScoreList.add(new Score("Andréa","Informatique","10/10"));
        ScoreList.add(new Score("Sam","Sport","2/5"));
        ScoreList.add(new Score("Mhd","Culture générale","2/10"));
        ScoreList.add(new Score("Sam","Sport","3/5"));
        ScoreList.add(new Score("Andréa","Sport","5/5"));

    ListView listViewSc = findViewById(R.id.maliste);
    listViewSc.setAdapter(new scoreAdapter(this,ScoreList));
    }
}