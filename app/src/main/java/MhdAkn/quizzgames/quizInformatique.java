package MhdAkn.quizzgames;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class quizInformatique extends AppCompatActivity {
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
                if (quizModArrayList.get(currentPos).getAnswer().trim().equalsIgnoreCase(choix2.getText().toString().trim())){
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
                if (quizModArrayList.get(currentPos).getAnswer().trim().equalsIgnoreCase(choix3.getText().toString().trim())){
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
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(quizInformatique.this);
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
        quizModArrayList.add(new quizMod("Lequel des langages informatiques suivants est utilisé pour l'intelligence artificielle ?","C","COBOL","PROLOG","C"));
        quizModArrayList.add(new quizMod("Le cerveau de tout système informatique est  ?","CPU","Unité de controle","Mémoire","CPU"));
        quizModArrayList.add(new quizMod("Quel protocol fournit un service de messagerie entre différents hotes?","FTP","TELNET","SMTP","SMTP"));
        quizModArrayList.add(new quizMod("Le microprocessseur est introduit dans quelle gération d'ordinateur  ?","Quatrième génération","Troisième génération","Deuxième gérération","Quatrième génération"));
        quizModArrayList.add(new quizMod("Un programme qui convertit le langage assembleur en langage machine est appelé ?","Compilateur","Assembleur","Comparateur","Assembleur"));
        quizModArrayList.add(new quizMod("Le système binaire utilise la base ?","2","10","16","2"));
        quizModArrayList.add(new quizMod("Lequel des langages suivants est mieux adapté au programmation struturé ?","PL/SQL","PASCAL","FORTRAN","Le Rhin"));
        quizModArrayList.add(new quizMod("ASCII signifie  ?","American standard code for information interchange","American security code for information interchange","American scientific code for information interchange","American standard code for information interchange"));
        quizModArrayList.add(new quizMod("Laquelle des mémoires suivantes est non volatile ?","ROM","SRAM","DRAM","ROM"));
        quizModArrayList.add(new quizMod("GUI signifie  ?","Graph Use Interface","Graphical User Interface","Graphical Universal Interface","Graphical User Interface"));

    }
}