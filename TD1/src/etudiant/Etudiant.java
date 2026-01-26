package etudiant;

public class Etudiant {
    private String nom;

    public Etudiant(String nom){
        this.nom = nom;
    }

    public void travailler(){
        if (this.nom.equals("toto")){
            System.out.println(this.nom + " se met au travail !");
        }
    }

    public void seReposer(){
        if (this.nom.equals("toto")){
            System.out.println(this.nom + " se repose");
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Etudiant <arg1>");
            return;
        }
        String nom = args[0];
        Etudiant stud = new Etudiant(nom);
        stud.seReposer();
        stud.travailler();
        // Etudiant jojokes = new Etudiant("Jojokes");
        // jojokes.seReposer();
        // jojokes.travailler();
        // Etudiant toto = new Etudiant("toto");
        // toto.seReposer();
        // toto.travailler();
        // toto.seReposer();
    }
}
