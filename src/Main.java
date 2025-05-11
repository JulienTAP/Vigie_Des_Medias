import Database.Database;

public class Main {

    public static void main(String[] args) {
        Database db = new Database("Dataset");
        db.load();

        Console console = new Console();
        console.addObserver(db);

        System.out.println("=".repeat(100));

        console.input(db.getMediaList(), db.getOrganisationList(), db.getRichList());
    }
}
