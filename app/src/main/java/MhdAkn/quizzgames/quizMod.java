package MhdAkn.quizzgames;

public class quizMod {
    //declaration des attributs
    private String question;
    private String r1;
    private String r2;
    private String r3;
    private String answer;

    //constructeur

    public quizMod(String question, String r1, String r2, String r3, String answer) {
        this.question = question;
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getR1() {
        return r1;
    }

    public void setR1(String r1) {
        this.r1 = r1;
    }

    public String getR2() {
        return r2;
    }

    public void setR2(String r2) {
        this.r2 = r2;
    }

    public String getR3() {
        return r3;
    }

    public void setR3(String r3) {
        this.r3 = r3;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
