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


public class quizLitterature extends AppCompatActivity {
    //declaration des textview
    private TextView question, questionNum;
    private TextView choix1,choix2,choix3;
    private ArrayList<quizMod> quizModArrayList;
    Random random;
    int currentScore = 0, questionAttempted = 1, currentPos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_culture);
        question = findViewById(R.id.textview1);
        questionNum = findViewById(R.id.textview2);
        choix1 = findViewById(R.id.checkBox1);
        choix2 = findViewById(R.id.checkBox2);
        choix3 = findViewById(R.id.checkBox3);
        quizModArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizModArrayList);
        currentPos = random.nextInt(quizModArrayList.size());
        setDataToView(currentPos);

        //evenemzent click sur le choix 1
        choix1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(choix1.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModArrayList.size());
                setDataToView(currentPos);
            }
        });

        //evenemzent click sur le choix 2
        choix2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModArrayList.get(currentPos).getAnswer().trim().equalsIgnoreCase(choix2.getText().toString().trim())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModArrayList.size());
                setDataToView(currentPos);
            }
        });

        //evenement click sur le choix 3
        choix3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModArrayList.get(currentPos).getAnswer().trim().equalsIgnoreCase(choix3.getText().toString().trim())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModArrayList.size());
                setDataToView(currentPos);
            }
        });
    }

    //
    private void showBottom() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(quizLitterature.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score, (LinearLayout) findViewById(R.id.idLscore));
        TextView score = bottomSheetView.findViewById(R.id.idScore);
        Button restartQuiz = bottomSheetView.findViewById(R.id.idRestart);
        score.setText("Ton score est \n" + currentScore + "/10");
        restartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizModArrayList.size());
                setDataToView(currentPos);
                questionAttempted = 1;
                currentScore = 0;
                bottomSheetDialog.dismiss();

            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }


    //
    private void setDataToView(int currentPos) {
        questionNum.setText("Questions r??ussies :" + currentScore + "/10");
        if (questionAttempted > 10) {
            showBottom();
        } else {
            question.setText(quizModArrayList.get(currentPos).getQuestion());
            choix1.setText(quizModArrayList.get(currentPos).getR1());
            choix2.setText(quizModArrayList.get(currentPos).getR2());
            choix3.setText(quizModArrayList.get(currentPos).getR3());
        }
    }

    //presentation des questions et choix de reponse
    private void getQuizQuestion(ArrayList<quizMod> quizModArrayList) {
        quizModArrayList.add(new quizMod("Quel est le premier auteur africain qui a eu le prix Nobel de litt??rature?", "Ahmadou Kourouma", "Wole Soyinka", "Biraogo Diop", "Wole Soyinka"));
        quizModArrayList.add(new quizMod("A quel ecrivain doit-on cette phrase : << En Afrique , un vieillard qui meurt est une biblioth??que qui brule>>", "Semb??ne Ousmane", "Joseph Ki Zerbo", "Amadou Hampat?? Ba", "Amadou Hampat?? Ba"));
        quizModArrayList.add(new quizMod("Quel c??l??bre roman conte le d??chirement d'un ??migr?? africain en occident ?", "Le mandat", "L'aventure ambigue", "Le cercle des tropiques", "L'aventure ambigue"));
        quizModArrayList.add(new quizMod(" Parmis ces romans de l'??crivaine Calixte Beyala,lequel remporta le Grand Prix du Roman de l'Acad??mie francaise ?", "La petite fille du r??verb??re ", "Ass??ze l'Africaine", "Les honneurs perdus", "Les honneurs perdus"));
        quizModArrayList.add(new quizMod("Quel est le dernier roman d'Ahmadou Kourouma ?", "Allah n'est pas oblig??", "La gr??ve des battus", "Quand on refuse  on dit non", "Quand on refuse  on dit non"));
        quizModArrayList.add(new quizMod("Dans quel c??l??bre roman africain le personnage principale s'appellle Okonkwo ", "Le monde s'effondre ", "Tribaliques ", "Cr??puscule des temps anciens", "Le monde s'effondre "));
        quizModArrayList.add(new quizMod("Qui a ecrit << Noirs dans les capmps nazis >> ?", "Yacine Kateb ", "Soni Labou Tansi", "Serge Bil??", "Serge Bil??"));
        quizModArrayList.add(new quizMod("A quelle illustre historien africain disparu en 2006 doit-on << A quand l'Afrique>> ?", "Joseph Ki Zerbo", "Camara Laye", "Aim?? C??saire", "Joseph Ki Zerbo"));
        quizModArrayList.add(new quizMod("En 2006 l'Egypte  perdit l'un de ses plus illustres ??crivains ,qui est-ce ?", "Alaa El Aswany", "Naguib Mahfouz", "Nawal El Saadawi", "Naguib Mahfouz"));
        quizModArrayList.add(new quizMod("Pour quel oueuvre, Alain Mabanckou obtint le Prix RRenaudot 2006  ?", "Et Dieu seul sait comment je dors", "M??moire de porc-??pic", "Verre Cass?? ", "M??moire de porc-??pic"));

    }
}