package Database;

import Entities.Abstract.Purchasable;
import Entities.Media;
import Entities.Organisation;
import Entities.Rich;

import java.util.ArrayList;

public class Database {

    private String path;

    private ArrayList<Media> mediaList = new ArrayList<Media>();
    private ArrayList<Organisation> organisationList = new ArrayList<Organisation>();
    private ArrayList<Rich> richList = new ArrayList<Rich>();
    private ArrayList<Purchasable> purchasableList = new ArrayList<Purchasable>();

    public Database(String path){
        this.path = path;
    }

    public String getPath(){
        return path;
    }

    private void loadMedia(){
        System.out.println("Loading media");

        // TO DO

    }

    private void loadOrganisations(){
        System.out.println("Loading organisations");

        // TO DO

    }

    private void loadRich(){
        System.out.println("Loading rich");

        // TO DO

    }

    private void loadLinks(){
        System.out.println("Loading links");

        // TO DO

    }

    public void load(){
        System.out.println("Loading database from: " + path);

        loadMedia();
        loadOrganisations();
        loadRich();
        loadLinks();

        System.out.println("Database loaded");
    }
}
