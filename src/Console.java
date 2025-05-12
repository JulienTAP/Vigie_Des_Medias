import Entities.Media.Media;
import Entities.Media.Publication;
import Entities.Organisation;
import Entities.Rich;
import Events.Abstract.Observer;
import Events.Abstract.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private Publication publication;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(publication.getAuthor() + " " + publication.getName() + " " + publication.getContent());
        }
    }


    public void input(ArrayList<Media> mediaList, ArrayList<Organisation> organisationList, ArrayList<Rich> richList) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Select Rich");
            System.out.println("2. Select Media");
            System.out.println("3. Select Organisation");
            System.out.println("4. Print All Rich");
            System.out.println("5. Print All Media");
            System.out.println("6. Print All Organisations");
            System.out.println("7. New Publication");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter Rich name: ");
                    String richName = scanner.nextLine();
                    Rich selectedRich = richList.stream()
                            .filter(r -> r.getName().equalsIgnoreCase(richName))
                            .findFirst()
                            .orElse(null);
                    if (selectedRich != null) {
                        System.out.println("Selected Rich:");
                        System.out.println(selectedRich.printAll());
                    } else {
                        System.out.println("Rich not found.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Media name: ");
                    String mediaName = scanner.nextLine();
                    Media selectedMedia = mediaList.stream()
                            .filter(m -> m.getName().equalsIgnoreCase(mediaName))
                            .findFirst()
                            .orElse(null);
                    if (selectedMedia != null) {
                        System.out.println("Selected Media:");
                        System.out.println(selectedMedia.toString());
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Organisation name: ");
                    String orgName = scanner.nextLine();
                    Organisation selectedOrganisation = organisationList.stream()
                            .filter(o -> o.getName().equalsIgnoreCase(orgName))
                            .findFirst()
                            .orElse(null);
                    if (selectedOrganisation != null) {
                        System.out.println("Selected Organisation:");
                        System.out.println(selectedOrganisation.printAll());
                    } else {
                        System.out.println("Organisation not found.");
                    }
                    break;

                case 4:
                    System.out.println("Rich List:");
                    for (Rich rich : richList) {
                        System.out.println(rich.printAll());
                    }
                    break;

                case 5:
                    System.out.println("Media List:");
                    for (Media media : mediaList) {
                        System.out.println(media.toString());
                    }
                    break;

                case 6:
                    System.out.println("Organisation List:");
                    for (Organisation organisation : organisationList) {
                        System.out.println(organisation.printAll());
                    }
                    break;
                case 7:
                    System.out.print("Enter author name for new publication: ");
                    String PublicationAuthor = scanner.nextLine();
                    System.out.print("Enter name for new publication: ");
                    String PublicationName = scanner.nextLine();
                    System.out.print("Enter content for new publication: ");
                    String PublicationContent = scanner.nextLine();
                    publication = new Publication(PublicationAuthor, PublicationName, PublicationContent);
                    notifyObservers();

                    break;

                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println("=".repeat(100));
        }
    }
}