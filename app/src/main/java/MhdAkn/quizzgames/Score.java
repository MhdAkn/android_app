package MhdAkn.quizzgames;
//class score
public class Score {

//Declaration des attributs de la classe
    String nom;
    String categorie;
    String score;
    //function construtor
    public Score(String nom, String categorie, String score) {
        this.nom = nom;
        this.categorie = categorie;
        this.score = score;
    }
//Methode Get pour la recuperation des  valeurs des variables
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
