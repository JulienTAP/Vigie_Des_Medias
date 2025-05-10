package Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Utils.Percentage;
import Entities.Media;
import Entities.Organisation;
import Entities.Rich;
import Links.LinkSameProperties;
import Links.Property;

import java.util.ArrayList;

public class Database {

    private String path;

    private ArrayList<Media> mediaList = new ArrayList<Media>();
    private ArrayList<Organisation> organisationList = new ArrayList<Organisation>();
    private ArrayList<Rich> richList = new ArrayList<Rich>();

    public Database(String path){
        this.path = path;
    }

    public String getPath(){
        return path;
    }

    public void loadMedia() {
        System.out.println("Loading media");
        try (BufferedReader br = new BufferedReader(new FileReader(path + "/medias.tsv"))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] fields = line.split("\t");
                String name = fields[0];
                String type = fields[1];
                String periodicity = fields[2];
                String scale = fields[3];
                boolean free = "Gratuit".equalsIgnoreCase(fields[4]);
                boolean available = fields.length < 6 || !"checked".equalsIgnoreCase(fields[5]);

                Media.MediaType mediaType = parseMediaType(type);
                Media.MediaPeriodicity mediaPeriodicity = parseMediaPeriodicity(periodicity);

                Media media = new Media(name, mediaType, mediaPeriodicity, scale, free, available);
                mediaList.add(media);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Media.MediaType parseMediaType(String type) {
        switch (type.toLowerCase()) {
            case "télévision":
                return Media.MediaType.TELEVISION;
            case "site":
                return Media.MediaType.SITE;
            case "radio":
                return Media.MediaType.RADIO;
            case "presse (généraliste  politique  économique)":
                return Media.MediaType.PRESS;
            default:
                throw new IllegalArgumentException("Unknown media type: " + type);
        }
    }

    private Media.MediaPeriodicity parseMediaPeriodicity(String periodicity) {
        switch (periodicity.toLowerCase()) {
            case "quotidien":
                return Media.MediaPeriodicity.DAILY;
            case "hebdomadaire":
                return Media.MediaPeriodicity.WEEKLY;
            case "mensuel":
                return Media.MediaPeriodicity.MONTHLY;
            default:
                return null; // Handle missing or unknown periodicity
        }
    }


    private void loadOrganisations() {
        System.out.println("Loading organisations");
        try (BufferedReader br = new BufferedReader(new FileReader(path + "/organisations.tsv"))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] fields = line.split("\t");
                String name = fields[0];
                String comment = fields.length > 1 ? fields[1] : "";

                Organisation organisation = new Organisation(name, comment);
                organisationList.add(organisation);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadRich() {
        System.out.println("Loading rich");
        try (BufferedReader br = new BufferedReader(new FileReader(path + "/personnes.tsv"))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] fields = line.split("\t");
                String name = fields[0];
                ArrayList<Integer> ranks = new ArrayList<>();

                for (int i = 1; i < fields.length; i++) {
                    if (!fields[i].isEmpty()) {
                        try {
                            ranks.add(Integer.parseInt(fields[i]));
                        } catch (NumberFormatException e) {
                            ranks.add(null); // Handle non-integer or empty values
                        }
                    } else {
                        ranks.add(null); // Add null for missing ranks
                    }
                }

                Rich rich = new Rich(name, ranks);
                richList.add(rich);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadRichOrganisationProperties() {
        System.out.println("Loading rich-organisation properties");
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] fields = line.split("\t");
                String origine = fields[1];
                String qualificatif = fields[2];
                String valeur = fields[3];
                String cible = fields[4];
                String commentaire = fields.length > 5 ? fields[5] : "";

                // Find the Rich object by name
                Rich rich = richList.stream()
                        .filter(r -> r.getName().equalsIgnoreCase(origine))
                        .findFirst()
                        .orElse(null);

                // Find the Organisation object by name
                Organisation organisation = organisationList.stream()
                        .filter(o -> o.getName().equalsIgnoreCase(cible))
                        .findFirst()
                        .orElse(null);

                if (rich != null && organisation != null) {
                    // Parse PropertyQualifier
                    Property.PropertyQualifier qualifier;
                    switch (qualificatif.toLowerCase()) {
                        case "égal à":
                            qualifier = Property.PropertyQualifier.EQUALS;
                            break;
                        case "contrôle":
                            qualifier = Property.PropertyQualifier.SUPERIOR;
                            break;
                        case "participe":
                            qualifier = Property.PropertyQualifier.PARTICIPANT;
                            break;
                        default:
                            throw new IllegalArgumentException("Unknown qualifier: " + qualificatif);
                    }

                    // Parse Percentage
                    Percentage percentage = valeur.isEmpty() ? null : new Percentage(Double.parseDouble(valeur.replace("%", "")));

                    // Create and add Property
                    Property<Organisation> property = new Property<>(organisation, qualifier, percentage, commentaire);
                    rich.addProperty(property);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        loadRichOrganisationProperties();

        System.out.println("Database loaded");
    }

    public static void main(String[] args) {
        Database db = new Database("Dataset");
        db.load();

        System.out.println(db.richList.get(0).printAll());
    }
}
