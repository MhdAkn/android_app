package MhdAkn.quizzgames;

public class Score {


    String nom;
    String categorie;
    String score;
    public Score(String nom, String categorie, String score) {
        this.nom = nom;
        this.categorie = categorie;
        this.score = score;
    }

    public String getNom() {
        return nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getScore() {
        return score;
    }
}
