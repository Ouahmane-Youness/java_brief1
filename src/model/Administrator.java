package model;

public class Administrator extends Person{
    private String idAdminstrator;


    public Administrator(int id, String last_name, String first_name, String password, String idAdminstrator) {
        super(id, last_name, first_name, password);
        this.idAdminstrator = idAdminstrator;
    }


    public String getIdAdminstrator() {
        return idAdminstrator;
    }

    public void setIdAdminstrator(String idAdminstrator) {
        this.idAdminstrator = idAdminstrator;
    }

    @Override
    public void displayMenu() {
        System.out.println("\n=== MENU ADMINISTRATOR ===");
        System.out.println("1. Create client account");
        System.out.println("2. Modify client information");
        System.out.println("3. close an account");
        System.out.println("4. consult bank statement ");
        System.out.println("5. Déconnecte");
        System.out.print("Votre choix: ");
    }


}
