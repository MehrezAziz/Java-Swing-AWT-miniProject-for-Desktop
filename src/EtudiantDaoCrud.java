public interface EtudiantDaoCrud {
        public int insertEtudiant(String nom,String prenom, int cin, double moy);
        public int modifierEtudiant(String nom,String prenom, int cin, double moy);
        public int supprimerEtudiant(int cin);
        public  void afficheAll();
        public int supprimerTous();

}
