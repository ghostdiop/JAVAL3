/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author Djiby DIOP
 */
public class Etudiant extends Personne{
    private String tuteur;
    //association many to one
    private Classe cl;

    public Etudiant() {
        super();
        type="Etudiant";
    }

    public Etudiant(String tuteur) {
        this.tuteur = tuteur;
        type="Etudiant";
    }
    

    public Etudiant(String tuteur, String nomComplet) {
        super(nomComplet);
        this.tuteur = tuteur;
        type="Etudiant";
    }

    public Etudiant(String tuteur, int id, String nomComplet) {
        super(id, nomComplet);
        this.tuteur = tuteur;
        type="Etudiant";
    }

    public Etudiant(String tuteur, Classe cl, String nomComplet) {
        super(nomComplet);
        this.tuteur = tuteur;
        this.cl = cl;
    }
    
    

    public String getTuteur() {
        return tuteur;
    }

    public void setTuteur(String tuteur) {
        this.tuteur = tuteur;
    }

    @Override
    public String toString() {
        return toString()+"Tuteur:"+tuteur; //To change body of generated methods, choose Tools | Templates.
    }

    public Classe getCl() {
        return cl;
    }

    public void setCl(Classe cl) {
        this.cl = cl;
    }    
    
}
