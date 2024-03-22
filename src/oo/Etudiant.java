package oo;

public class Etudiant extends Personne{
    private String filiere;
    private int niveau;
    private int groupe;

    public String getFiliere() {
        return filiere;
    }

    public int getNiveau() {
        return niveau;
    }

    public int getGroupe() {
        return groupe;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public void setGroupe(int groupe) {
        this.groupe = groupe;
    }
}
