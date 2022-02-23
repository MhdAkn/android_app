package MhdAkn.quizzgames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class quizSport extends AppCompatActivity {
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
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(quizSport.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score,(LinearLayout)findViewById(R.id.idLscore));
        TextView score = bottomSheetView.findViewById(R.id.idScore);
        Button restartQuiz = bottomSheetView.findViewById(R.id.idRestart);
        score.setText("Ton score est \n"+currentScore + "/5");
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
        questionNum.setText("Questions réussies :"+ currentScore+ "/5");
        if (questionAttempted > 5){
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
        quizModArrayList.add(new quizMod("Combien de ballon d'or Christiano Ronaldo a obtenue?","5","6","7","5"));
        quizModArrayList.add(new quizMod("Où ont lieu les jeux Olympiques d’été en 2016?","Doha","Rio de Janeiro","Chicago","Rio de Janeiro"));
        quizModArrayList.add(new quizMod("Quel nom porte un terrain de tennis  ?","La surface","Le court","La terre battue","La surface"));
        quizModArrayList.add(new quizMod("Qui a recu le ballon d'or 2021 ?","Lewandoski","Messi","Christiano Ronaldo","Messi"));
        quizModArrayList.add(new quizMod("Quelle est la couleur d'une balle de tennis ?","Vert","Jaune","Rouge","Jaune"));

    }
}