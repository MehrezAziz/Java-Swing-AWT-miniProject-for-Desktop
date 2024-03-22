package oo;
import java.util.*;

public interface formationCRUD {
        public int insertFormation(int id,String titre,Date datef, String lieu, boolean certificat);
        public int modifierEtudiant(int id,String titre,Date datef, String lieu, boolean certificat);
        public int supprimerEtudiant(int id);
        public  void afficheAll();
        public int supprimerTous();

}
