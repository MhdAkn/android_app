package MhdAkn.quizzgames;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class quizCulture extends AppCompatActivity {
    //declaration des textview
    private TextView question,questionNum;
    private TextView choix1,choix2,choix3;
    private ArrayList<quizMod>quizModArrayList;
    Random random;
    int currentScore =0,questionAttempted=1,currentPos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_culture);
        question=findViewById(R.id.textview1);
        questionNum=findViewById(R.id.textview2);
        choix1=findViewById(R.id.checkBox1);
        choix2=findViewById(R.id.checkBox2);
        choix3=findViewById(R.id.checkBox3);
        quizModArrayList= new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizModArrayList);
        currentPos=random.nextInt(quizModArrayList.size());
        setDataToView(currentPos);

        //evenemzent click sur le choix 1
        choix1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if (choix1.isChecked() choix2.di)
                if (quizModArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(choix1.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizModArrayList.size());
                setDataToView(currentPos);
            }
        });

        //evenemzent click sur le choix 2
        choix2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(choix2.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizModArrayList.size());
                setDataToView(currentPos);
            }
        });

        //evenement click sur le choix 3
        choix3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(choix3.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizModArrayList.size());
                setDataToView(currentPos);
            }
        });
    }
    //
    private void showBottom(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(quizCulture.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score,(LinearLayout)findViewById(R.id.idLscore));
        TextView score = bottomSheetView.findViewById(R.id.idScore);
        Button restartQuiz = bottomSheetView.findViewById(R.id.idRestart);
        score.setText("Ton score est \n"+currentScore + "/10");
        restartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizModArrayList.size());
                setDataToView(currentPos);
                questionAttempted=1;
                currentScore=0;
                bottomSheetDialog.dismiss();

            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }


    //
    private void setDataToView(int currentPos){
        questionNum.setText("Questions réussies :"+ currentScore+ "/10");
        if (questionAttempted > 10){
            showBottom();
        }else {
            question.setText(quizModArrayList.get(currentPos).getQuestion());
            choix1.setText(quizModArrayList.get(currentPos).getR1());
            choix2.setText(quizModArrayList.get(currentPos).getR2());
            choix3.setText(quizModArrayList.get(currentPos).getR3());
        }
    }

    //presentation des questions et choix de reponse
    private void getQuizQuestion(ArrayList<quizMod> quizModArrayList) {
        quizModArrayList.add(new quizMod("Quelle est la capitale des Bermudes ?","Hamilton","Kingston","Cottenham","Hamilton"));
        quizModArrayList.add(new quizMod("Quel a été le premier nom du jeu de boules ?","Le Tire-Pointe","Le Boulingrins","Le Gagne-Pastis","Le Boulingrins"));
        quizModArrayList.add(new quizMod("Quel est le pays natal de Wolfgang Amadeus Mozart ?","L'Autriche","La Roumanie","L'Allemagne","L'Autriche"));
        quizModArrayList.add(new quizMod("Quel monument devrait s'écrouler entre 2010 et 2020 ?","La Tour Eiffel","La Tour de Pise","La cabane du voisin","La Tour de Pise"));
        quizModArrayList.add(new quizMod("Lequel des cinq sens manque au serpent ?","L'ouie","L'odorat","Ancun, il les a tous","L'ouie"));
        quizModArrayList.add(new quizMod("Complétez ce célèbre slogan ''... Coca-cola''","Don't drink","I hate","Always","Always"));
        quizModArrayList.add(new quizMod("Quel est le plus long fleuve d'Europe occidentale ?","Le Rhène","Le Rhin","La Loire","Le Rhin"));
        quizModArrayList.add(new quizMod("Quelle ville a construit le premier métro ?","Paris","Londres","Berlin","Londres"));
        quizModArrayList.add(new quizMod("Qui a mis le premier le pied sur la Lune ?","Neil Armstrong","Tintin","Youri Gagarine","Neil Armstrong"));
        quizModArrayList.add(new quizMod("Sur quel continent se trouve la Terre-Adélie ?","En Océanie","En Antarctique","En Afrique","En Antarctique"));

    }
}