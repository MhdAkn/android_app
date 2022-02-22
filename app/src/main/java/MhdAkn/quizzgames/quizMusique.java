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
import MhdAkn.quizzgames.R;
public class quizMusique extends AppCompatActivity {
    //declaration des textview
    private TextView question,questionNum;
    private TextView choix1,choix2,choix3;
    private ArrayList<quizMod> quizModArrayList;
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
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(quizMusique.this);
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
        quizModArrayList.add(new quizMod("Pour commencer en douceur, en quoi se décompose traditionnellement une symphonie ?","En opus","En actes","En mouvements","En mouvements"));
        quizModArrayList.add(new quizMod("Ensemble de cinq lignes parallèles par rapport auxquelles on dispose allégrement divers symboles musicaux, je suis...?","la portée","le système","La clé","la portée"));
        quizModArrayList.add(new quizMod("Nos amis anglo-saxons utilisent parfois des lettres en guise de notation musicale. Quelle lettre utilisent-ils donc pour le do ?","A","B","C","C"));
        quizModArrayList.add(new quizMod("La salle Pleyel tire son nom... ?","de la rue dans laquelle elle est située","des pianos homonymes","de l’anglais « play » (jouer)","des pianos homonymes"));
        quizModArrayList.add(new quizMod("Avec quel outil un chef dirige-t-il traditionnellement son orchestre ?","Une baguette","Un archet","Un tisonnier","Une baguette"));
        quizModArrayList.add(new quizMod("Sur quel support le musicien appréciera-t-il de disposer ses partitions","Le chevalet","Le pupitre","Le prompteur","Le pupitre"));
        quizModArrayList.add(new quizMod("Certains instruments (de musique) peuvent être équipés... ?","d’un silencieux","d’un catalyseur","d’une sourdine","d’une sourdine"));
        quizModArrayList.add(new quizMod("La Fête de la musique a lieu...?","chaque 29 février","le 21 juin","le premier jour du printemps","le 21 juin"));
        quizModArrayList.add(new quizMod("Le piano appartient à la famille...?","des cordes frappées","des cordes décuplées","des cordes pincées","des cordes frappées"));
        quizModArrayList.add(new quizMod("Qu’est-ce que l’Oreille absolue ?","En Océanie","La faculté de pouvoir identifier instantanément une note de musique entendue","La faculté de pouvoir identifier instantanément le timbre d’un instrument de musique","La faculté de pouvoir identifier instantanément une note de musique entendue"));

    }
}