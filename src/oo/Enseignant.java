package oo;

public class Enseignant extends  Personne{
    private String specialite,grade;

    public String getGrade() {
        return grade;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
