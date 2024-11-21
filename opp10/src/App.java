import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class App {
    static int lesHeltall(String prompt) {
        try {
            @SuppressWarnings("resource") // Ignore warning about resource leak System.in is supposed to stay open
            final Scanner inputScanner = new Scanner(System.in);
            System.out.println(prompt);
            final int outputInt = inputScanner.nextInt();
            return outputInt;
        }
        catch (Exception e) {
            System.out.println("Noe gikk galt. Skriv kun inn heltall.");
            return lesHeltall(prompt);
        }
    }
    static String lesBrukerGenerertTekst(String prompt) {
        try {
            @SuppressWarnings("resource") // Ignore warning about resource leak System.in is supposed to stay open
            final Scanner inputScanner = new Scanner(System.in);
            System.out.println(prompt);
            final String outputString = inputScanner.nextLine();
            return outputString;
        }
        catch (Exception e) {
            System.out.println("Noe gikk galt.");
            return lesBrukerGenerertTekst(prompt);
        }
    }

    public static void task1() {
        ArrangementRegister eventhouseArrangementRegister = new ArrangementRegister(new ArrayList<Arrangement>());
        int svar = lesHeltall("Yo velkommen til min arrangement greie \n"
        + "Tast 1 for å starte med kule verdier \n"
        + "Tast 2 for å ikke gjøre det"
        );
        if (svar == 1) {
            Arrangement avgangssermoniEldrehjemmet = new Arrangement("HamarHurra", "Hamar", "sermoni", 1724928940001L);
            Arrangement bursdagsfest = new Arrangement("Kåre bursdag", "Oslo", "bursdag", 1724928940091L);
            Arrangement begravelse = new Arrangement("Trist bursdag", "Oslo", "trist", 1732106874913L);
            Arrangement johoo = new Arrangement("Johoo festival", "Oslo", "trist", 1732106974913L);
            Arrangement tristDag = new Arrangement("Tristere bursdag", "Drammen", "trist", 1732106894919L);
            Arrangement dansing = new Arrangement("Dansedag", "Trondheim", "landstreff", 1732106875919L);
            Arrangement y2k = new Arrangement("Ostepop parade", "New York", "fellesfest", 1700928950091L);
            Arrangement fest1970sTema = new Arrangement("Feiring av fjerning av Sverige", "Bergen", "fellesfest", 0);
            // * Beklager
            eventhouseArrangementRegister.registrerNyttArrangement(avgangssermoniEldrehjemmet);
            eventhouseArrangementRegister.registrerNyttArrangement(fest1970sTema);
            eventhouseArrangementRegister.registrerNyttArrangement(bursdagsfest);
            eventhouseArrangementRegister.registrerNyttArrangement(begravelse);
            eventhouseArrangementRegister.registrerNyttArrangement(tristDag);
            eventhouseArrangementRegister.registrerNyttArrangement(dansing);
            eventhouseArrangementRegister.registrerNyttArrangement(johoo);
            eventhouseArrangementRegister.registrerNyttArrangement(y2k);
            System.out.println("-- Arrangementer --");
            final ArrayList<Arrangement> fultSorterteArrangementer = eventhouseArrangementRegister.skaffFultSortertListe();
            fultSorterteArrangementer.forEach(arrangement -> {
                System.out.println(arrangement.toString());
            });
        }
        while (true) {
            System.out.println("--");
            int handling = lesHeltall("Yoooo, vil du gjøre saker. Skriv greia du vil \n"
            + "Tast 1 for å legge til et arrangement \n"
            + "Tast 2 for å finne et arrangement på et sted \n"
            + "Tast 3 for å finne et arrangement på en dato \n"
            + "Tast 4 for å finne et arrangement mellom 2 datoer \n"
            + "Tast 5 for å lage en sortert liste over arrangementer \n"
            + "Ditt svar: "
            );
            if (handling == 1) {
                final String navn = lesBrukerGenerertTekst("Hva burde arrangementet hete?");
                final String sted = lesBrukerGenerertTekst("Hvor burde arrangementet være?");
                final int tidspunktÅr = lesHeltall("Hvilket år burde arrangementet være?");
                final int tidspunktMåned = lesHeltall("Hvilken måned burde arrangementet være?");
                final int tidspunktDato = lesHeltall("Hvilken dato burde arrangementet være?");
                Arrangement nyttArrangement = new Arrangement(navn, sted, sted, new Date(tidspunktÅr, tidspunktMåned, tidspunktDato).getTime());
                eventhouseArrangementRegister.registrerNyttArrangement(nyttArrangement);
                System.out.println("-- Nytt Arrangement --");
                System.out.println(nyttArrangement.toString());
            }
            else if (handling == 2) {
                final String stedBrukerSerEtter = lesBrukerGenerertTekst("Hvilket sted ser du etter?");
                List<Arrangement> arrangementerPåSted = eventhouseArrangementRegister.finnAlleArrangementPåSted(stedBrukerSerEtter);
                System.out.println("-- Arrangementer På sted gitt --");
                arrangementerPåSted.forEach(arrangement -> {
                    System.out.println(arrangement.toString());
                });
            }
            else if (handling == 3) {
                final int tidspunktÅr = lesHeltall("Hvilket år er arrangementet du ser etter?");
                final int tidspunktMåned = lesHeltall("Hvilken måned er arrangementet du ser etter?");
                final int tidspunktDato = lesHeltall("Hvilken dato er arrangementet du ser etter?");
                Date targetDate = new Date();
                targetDate.setYear(tidspunktÅr);
                targetDate.setMonth(tidspunktMåned);
                targetDate.setDate(tidspunktDato);
                List<Arrangement> arrangementerPåDato = eventhouseArrangementRegister.finnAlleArrangementPåDato(targetDate);
                arrangementerPåDato = ArrangementRegister.skaffTidsSortertListeOverArrangementer(arrangementerPåDato);
                System.out.println("-- Arrangementer På Dato gitt --");
                arrangementerPåDato.forEach(arrangement -> {
                    System.out.println(arrangement.toString());
                });
            }
            else if (handling == 4) {
                final int startTidspunktÅr = lesHeltall("Hvilket år er startdatoen?") - 1900;
                final int startTidspunktMåned = lesHeltall("Hvilken måned er startdatoen?") - 1;
                final int startTidspunktDato = lesHeltall("Hvilken dato er startdatoen?");
                final int sluttTidspunktÅr = lesHeltall("Hvilket år er sluttdatoen?") - 1900;
                final int sluttTidspunktMåned = lesHeltall("Hvilken måned er sluttdatoen?") - 1;
                final int sluttTidspunktDato = lesHeltall("Hvilken dato er sluttdatoen?");
                List<Arrangement> arrangementerMellomDatoer = eventhouseArrangementRegister.finnAlleArrangementMellomDatoer(new Date(startTidspunktÅr, startTidspunktMåned, startTidspunktDato).getTime(), new Date(sluttTidspunktÅr, sluttTidspunktMåned, sluttTidspunktDato).getTime());
                System.out.println("-- Arrangementer mellom datoer --");
                arrangementerMellomDatoer.forEach(arrangement -> {
                    System.out.println(arrangement.toString());
                });
            }
            else if (handling == 5) {
                System.out.println("-- Arrangementer fullsortert --");
                final ArrayList<Arrangement> fultSorterteArrangementer = eventhouseArrangementRegister.skaffFultSortertListe();
                fultSorterteArrangementer.forEach(arrangement -> {
                    System.out.println(arrangement.toString());
                });
            }
            // ! Til personen som leser denne koden. Beklager på det høyeste. Du fortjener bedre.
            // ! Jeg kunne ønske at jeg kunne si at dette er dårlig skrevet fordi jeg ikke kan bedre
            // ! Sannheten er at dette var et valg. Et valg som kommer til å påvirke deg og dine
            // * mvh Theodor :(
        }
    }

    public static void task2() {
        final Dish meatBalls = new Dish("Meatballs", DishType.APPETIZER, 59.99);
        final ArrayList<Dish> swedishDishList = new ArrayList<Dish>();
        swedishDishList.add(meatBalls);
        // final Menu swedishMenu = new Menu(swedishDishList); ? WTF
        final Menu swedishMenu = new Menu(new ArrayList<Dish>(swedishDishList));
        final ArrayList<Menu> menuList = new ArrayList<Menu>();
        menuList.add(swedishMenu);

        final MenuRegister menuRegister = new MenuRegister(swedishDishList, menuList);

        while (true) {
            final int choice = lesHeltall("Hvilken handling vil du gjøre? \n"
            + "1. Registrere en ny rett \n"
            + "2. Finne en rett basert på navn \n"
            + "3. Finne alle retter av en gitt type \n"
            + "4. Registrere en ny meny som består av ett sett med retter \n"
            + "5. Finne alle menyer med totalpris innenfor et gitt interval \n"
            + "6. Se alle menyer og alle retter"
            );
            
            if (choice == 1) {
                final String name = lesBrukerGenerertTekst("What name does the dish have?");
                int count = 0;
                for (DishType dishType : DishType.values()) { 
                    count++;
                    System.out.println(count + ": " + dishType); 
                }
                final int dishTypeChoice = lesHeltall("Hvilken mattype er retten din?");
                final int price = lesHeltall("Hvor mye skal retten koste?");
                final Dish newDish = new Dish(name, DishType.valueOf(DishType.values()[dishTypeChoice - 1].name()), price);
                menuRegister.addNewDish(newDish);
            }
            if (choice == 2) {
                final Dish foundDish = menuRegister.getDishFromName(lesBrukerGenerertTekst("Hva er navnet på retten du ser etter?"));
                if (foundDish != null) {
                    System.out.println(foundDish.toString());
                }
                else {
                    System.out.println("Not found");
                }
            } 
            if (choice == 3) {
                int count = 0;
                for (DishType dishType : DishType.values()) { 
                    count++;
                    System.out.println(count + ": " + dishType); 
                }
                final int dishTypeChoice = lesHeltall("Hvilken mattype ser du etter?");
                final ArrayList<Dish> dishsOfType = menuRegister.getAllDishesOfType(DishType.valueOf(DishType.values()[dishTypeChoice - 1].name()));
                for (Dish currentDish : dishsOfType) {
                    System.out.println(currentDish.toString());
                }
                if (dishsOfType.size() == 0) System.out.println("No dishes in category found");
            }
            if (choice == 4) {
                final ArrayList<Dish> newDishList = new ArrayList<Dish>();
                while (true) {
                    final String name = lesBrukerGenerertTekst("What name does the dish have?");
                    int count = 0;
                    for (DishType dishType : DishType.values()) { 
                        count++;
                        System.out.println(count + ": " + dishType); 
                    }
                    final int dishTypeChoice = lesHeltall("Hvilken mattype er retten din?");
                    final int price = lesHeltall("Hvor mye skal retten koste?");
                    final Dish newDish = new Dish(name, DishType.valueOf(DishType.values()[dishTypeChoice - 1].name()), price);
                    newDishList.add(newDish);
                    menuRegister.addNewDish(newDish);
                    if (lesBrukerGenerertTekst("Vil du avslutte å legge til retter? (ja/nei)").equals("ja")) break;
                }
                Menu newMenu = new Menu(newDishList);
                menuRegister.addNewMenu(newMenu);
            }
            if (choice == 5) {
                int lowerBound = lesHeltall("Hva er det nedre prisnivået du søker etter?");
                int upperBound = lesHeltall("Hva er det høyere prisnivået du søker etter?");
                ArrayList<Menu> menusInRange = menuRegister.getAllMenusInPriceRange(lowerBound, upperBound);
                for (Menu menu : menusInRange) {
                    System.out.println(menu.toString());
                }
            }
            if (choice == 6) {
                for (Dish currentDish : menuRegister.getDishes()) {
                    System.out.println(currentDish.toString());
                }
                for (Menu currentMenu : menuRegister.getMenus()) {
                    System.out.println(currentMenu.toString());
                }
                System.out.println("SIZE: " + menuRegister.getMenus().size());
            }
        }
    }
    public static void main(String[] args) throws Exception {
        // task1();
        task2();
    }
}
