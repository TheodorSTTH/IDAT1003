import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner sc;
    private final int ADD_PROPERTY = 1;
    private final int LIST_ALL_PROPERTIES = 2;
    private final int FIND_PROPERTY = 3;
    private final int CALCULATE_AVERAGE_AREA = 4;
    private final int EXIT = 9;

    public UserInterface() {
        sc = new Scanner(System.in);
    }

    /**
     * Presents the menu for the user, and awaits input from the user. The menu
     * choice selected by the user is being returned.
     *
     * @return the menu choice by the user as a positive number starting from 1.
     * If 0 is returned, the user has entered a wrong value
     */
    private int showMenu() {
        int menuChoice = 0;
        System.out.println("\n***** Property Register Application v0.1 *****\n");
        System.out.println("1. Add property");
        System.out.println("2. List all properties");
        System.out.println("3. Search property");
        System.out.println("4. Calculate average area");
        System.out.println("9. Quit");
        System.out.println("\nPlease enter a number between 1 and 9.\n");

        if (sc.hasNextInt()) {
            menuChoice = sc.nextInt();
            sc.nextLine(); // consume newline
        } else {
            System.out.println("You must enter a number, not text");
            sc.nextLine(); // consume invalid input
        }
        return menuChoice;
    }

    /**
     * Starts the application. This is the main loop of the application,
     * presenting the menu, retrieving the selected menu choice from the user,
     * and executing the selected functionality.
     */
    public void start() {
        boolean finished = false;
        PropertyRegister propertyRegister = new PropertyRegister(new ArrayList<>());
        propertyRegister.addProperty(new Property(1445, "Gloppen", 77, 631, null, 1017.6, "Jens Olsen"));
        propertyRegister.addProperty(new Property(1445, "Gloppen", 77, 131, "Syningom", 661.3, "Nicolay Madsen"));
        propertyRegister.addProperty(new Property(1445, "Gloppen", 75, 19, "Fugletun", 650.6, "Evilyn Jensen"));
        propertyRegister.addProperty(new Property(1445, "Gloppen", 74, 188, null, 1457.2, "Karl Ove Bråten"));
        propertyRegister.addProperty(new Property(1445, "Gloppen", 69, 47, "Høiberg", 1339.4, "Elsa Indregård"));

        while (!finished) {
            int menuChoice = this.showMenu();
            switch (menuChoice) {
                case ADD_PROPERTY:
                    Property newProperty = readPropertyFromUser();
                    propertyRegister.addProperty(newProperty);
                    System.out.println("Property added successfully.");
                    break;
                case LIST_ALL_PROPERTIES:
                    listAllProperties(propertyRegister);
                    break;
                case FIND_PROPERTY:
                    findProperty(propertyRegister);
                    break;
                case CALCULATE_AVERAGE_AREA:
                    calculateAverageArea(propertyRegister);
                    break;
                case EXIT:
                    System.out.println("Thank you for using the Properties app!\n");
                    finished = true;
                    break;
                default:
                    System.out.println("Unrecognized menu selected..");
                    break;
            }
        }
        sc.close();
    }

    private Property readPropertyFromUser() {
        System.out.println("Enter Municipality Number:");
        int municipalityNumber = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.println("Enter Municipality Name:");
        String municipalityName = sc.nextLine();

        System.out.println("Enter Lot Number:");
        int lotNumber = sc.nextInt();

        System.out.println("Enter Section Number:");
        int sectionNumber = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.println("Enter Name (or leave empty if none):");
        String name = sc.nextLine();

        System.out.println("Enter Area:");
        double area = sc.nextDouble();
        sc.nextLine(); // consume newline

        System.out.println("Enter Owner's Name:");
        String nameOfOwner = sc.nextLine();

        return new Property(municipalityNumber, municipalityName, lotNumber, sectionNumber, name, area, nameOfOwner);
    }

    private void listAllProperties(PropertyRegister propertyRegister) {
        ArrayList<Property> allProperties = propertyRegister.getAllProperties();
        if (allProperties.isEmpty()) {
            System.out.println("No properties registered.");
        } else {
            for (Property property : allProperties) {
                System.out.println(property);
                System.out.println("--------------------------------------------------");
            }
        }
    }

    private void findProperty(PropertyRegister propertyRegister) {
        System.out.println("Enter Municipality Number:");
        int municipalityNumber = sc.nextInt();

        System.out.println("Enter Lot Number:");
        int lotNumber = sc.nextInt();

        System.out.println("Enter Section Number:");
        int sectionNumber = sc.nextInt();
        sc.nextLine(); // consume newline

        Property foundProperty = propertyRegister.getProperty(municipalityNumber, lotNumber, sectionNumber);

        if (foundProperty != null) {
            System.out.println("Property found:");
            System.out.println(foundProperty);
        } else {
            System.out.println("No property found with the given details.");
        }
    }

    private void calculateAverageArea(PropertyRegister propertyRegister) {
        double averageArea = propertyRegister.getAverageArea();
        System.out.println("The average area of the properties is: " + averageArea);
    }
}
