import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class zooMain
{
    static Scanner input = new Scanner(System.in);
    static List<Animal> allAnimals = new ArrayList<>();

    public static void main(String[] args)
    {
        int menu = 0;

        Animal a1 = new Animal("Alfred", "Tiger", "Mammal", 120, 25);
        Animal a2 = new Animal("Huntress", "Leopard", "Mammal", 10, 15);
        Animal a3 = new Animal("Screamer", "Wolf", "Mammal", 90, 30);
        Animal a4 = new Animal("Jason", "Parrot", "Aves", 90, 30);
        Animal a5 = new Animal("Pinto", "Giraffe", "Mammal", 140, 45);
        Animal a6 = new Animal("Jager", "Hyenna", "Mammal", 99, 23);
        Animal a7 = new Animal("Bigtooth", "Shark", "Fish", 187, 29);

        allAnimals.add(a1);
        allAnimals.add(a2);
        allAnimals.add(a3);
        allAnimals.add(a4);
        allAnimals.add(a5);
        allAnimals.add(a6);
        allAnimals.add(a7);


        System.out.println("ΓΙΩΡΓΟΣ ΣΕΪΜΕΝΗΣ, ΠΑΝΕΠΙΣΤΗΜΙΟ ΠΕΙΡΑΙΩΣ ΤΜΗΜΑ ΠΛΗΡΟΦΟΡΙΚΗΣ, Π19204\n\n");


        System.out.println("Καλώς ορίσατε στο μενού του Ζωολογικού Κήπου. Ενέργειες:");

        //δείχνουμε διαδοχικά κάθε φορά το μενού στον Χρήστη μέχρι να πατήσει 7, που είναι η έξοδος.
        do
        {
            menu = showMenu();
            switch (menu)
            {
                case 1:
                    System.out.println("\nΛΙΣΤΑ ΜΕ ΟΛΑ ΤΑ ΔΙΑΘΕΣΙΜΑ ΖΩΑ:\n");
                    int i = 1;
                    for (Animal a: allAnimals)
                    {
                        System.out.println(i + ". " + "Όνομα: " + a.getCustomName() + ", Ζώο: " + a.getAnimalName() + ", Κωδικός: " + a.getId());
                        i++;
                    }

                    //δυνατότητα πατήματος enter για συνέχεια.
                    System.out.print("\nΕπιστροφή στο αρχικό μενού; (y/n) --> ");
                    String answer1 = input.nextLine();

                    if (answer1.equals("y") || answer1.equals("Y"))
                        break;
                    else
                        menu = 7;
                        break;
                case 2:
                    String customName, animalName, type, answer2 = "";
                    int maxAge, weight; 
                    
                    //δίνουμε την δυνατότητα στον Χρήστη να εισάγει πολλά ζώα, αν αυτός επιθυμεί.
                    do {

                        System.out.println("=== ΜΕΝΟΥ ΠΡΟΣΘΗΚΗΣ ΝΕΟΥ ΖΩΟΥ ===");
                
                        //εισαγωγή στοιχείων του ζώου. Από τη στιγμή που ο Χρήστης εισάγει strings δεν χρειάζεται κάποιος έλεγχος.
                        System.out.print("\nΠώς θέλετε να το ονομάσετε; --> ");
                        customName = input.nextLine();

                        System.out.print("Τι ζώο είναι; --> ");
                        animalName = input.nextLine();

                        System.out.print("Σε ποιά κατηγορία ανήκει (π.χ. θηλαστικό); --> ");
                        type = input.nextLine();

                        //εισαγωγή αριθμητικών στοιχείων, εδώ θα χρειαστεί λίγος παραπάνω έλεγχος.
                        System.out.print("Πόσα κιλά (kg) ζυγίζει; --> ");
                        String startingWeight = input.nextLine();
                        weight = convertSafelyToInteger(startingWeight);

                        System.out.print("Ποιά είναι μέγιστη ηλικία του; --> ");
                        String startingMaxAge = input.nextLine();
                        maxAge = convertSafelyToInteger(startingMaxAge);
                        
                        Animal a = new Animal(customName, animalName, type, weight, maxAge);
                        allAnimals.add(a);

                        System.out.println("\n[ΠΡΟΣΘΗΚΗ]: Επιτυχής προσθήκη! Το ζώο σας είναι στον ζωολογικό κήπο με κωδικό " + a.getId());
                        System.out.print("Θα θέλατε να προσθέσετε κι άλλο ζώο στη λίστα; (y/n) --> ");
                        answer2 = input.nextLine();

                    } while (answer2.equals("y") || answer2.equals("Y"));

                    break;
                case 3:
                    String answer3, keyword;

                    do
                    {
                        System.out.print("Ποιό όνομα θέλετε να ψάξετε; --> ");
                        keyword = input.nextLine();
                        
                        serialSearch(keyword, false, -1);

                        System.out.print("\nΘα θέλατε να ψάξετε και για κάποιο άλλο όνομα; (y/n) --> ");
                        answer3 = input.nextLine();

                    } while (answer3.equals("y") || answer3.equals("Y"));

                    break;
                case 4:
                    String startingKeyword, answer4 = "";
                    int numericKeyword;

                    do
                    {
                        System.out.print("Ποιον κωδικό θέλετε να ψάξετε; --> ");
                        startingKeyword = input.nextLine();
                        numericKeyword = convertSafelyToInteger(startingKeyword);
                        serialSearch("", true, numericKeyword);

                        System.out.print("\nΘα θέλατε να ψάξετε για κάποιον άλλον κωδικό; (y/n) --> ");
                        answer4 = input.nextLine();

                    } while (answer4.equals("y") || answer4.equals("Y"));
                    
                    break;
                case 5:
                    String answer5;
                    
                    do
                    {
                        System.out.print("Εισάγετε τον κωδικό του ζώου που θέλετε να επεργαστείτε --> ");
                        startingKeyword = input.nextLine();
                        numericKeyword = convertSafelyToInteger(startingKeyword);

                        for (Animal a: allAnimals)
                        {
                            if (a.getId() == numericKeyword)
                            {
                                System.out.print("\nΕισάγετε ένα νέο όνομα. (ΠΡΟΗΓ.: " + a.getCustomName() + ") --> ");
                                String newCustomName = input.nextLine();
                                a.setCustomName(newCustomName);

                                System.out.print("Εισάγετε ένα νέο ζώο. (ΠΡΟΗΓ.: " + a.getAnimalName() + ") --> ");
                                String newAnimalName = input.nextLine();
                                a.setAnimalName(newAnimalName);

                                System.out.print("Εισάγετε μία νέα κατηγορία. (ΠΡΟΗΓ.: " + a.getType() + ") --> ");
                                String newType = input.nextLine();
                                a.setType(newType);

                                System.out.print("Εισάγετε τον νέο αριθμό σε κιλά. (ΠΡΟΗΓ.: " + a.getWeight() + ") --> ");
                                String newStringWeight = input.nextLine();
                                int newWeight = convertSafelyToInteger(newStringWeight);
                                a.setWeight(newWeight);

                                System.out.print("ισάγετε την νέα μέγιστη ηλικία. (ΠΡΟΗΓ.: " + a.getMaxAge() + ") --> ");
                                String newStringMaxAge = input.nextLine();
                                int newMaxAge = convertSafelyToInteger(newStringMaxAge);
                                a.setWeight(newMaxAge);
                                
                                System.out.println("\n[ΕΠΕΞΑΡΓΑΣΙΑ]: Η επεξεργασία ολοκληρώθηκε!");
                            }
                        }

                        System.out.print("\nΘα θέλατε να επεξεργαστείτε κάποιο άλλο ζώο; (y/n) --> ");
                        answer5 = input.nextLine();

                    } while(answer5.equals("y") || answer5.equals("Y"));

                    break;
                case 6:
                    String answer6;
                    int positionToDelete = -1;

                    do
                    {
                        System.out.print("Εισάγετε τον κωδικό του ζώου που θέλετε να διαγράψετε --> ");
                        startingKeyword = input.nextLine();
                        numericKeyword = convertSafelyToInteger(startingKeyword);

                        for (i = 0; i < allAnimals.size(); i++)
                        {
                            if (allAnimals.get(i).getId() == numericKeyword)
                            {
                                positionToDelete = i;               
                            }
                        }

                        if (positionToDelete != -1)
                        {
                            allAnimals.remove(positionToDelete);
                            System.out.println("\n[ΔΙΑΓΡΑΦΗ]: Επιτυχής διαγραφή του ζώου με κωδικό " + numericKeyword + "!\n");
                        }
                        else
                            System.out.println("\n[ΔΙΑΓΡΑΦΉ]: Δεν βρέθηκε κάποιο ζώο.\n");

                        System.out.print("Θα θέλατε να διαγράψετε κι άλλο ζώο; (y/n) --> ");
                        answer6 = input.nextLine();

                    } while (answer6.equals("y") || answer6.equals("Y"));
                    break;
            }
        } while(menu != 7);
    }

    //μέθοδος για την Εμφάνιση του μενού, η οποία επιστρέφει και την επιλογή του Χρήστη.
    public static int showMenu()
    {
        //String firstAction = "";
        int numAction = 0;

        //εμφάνιση του μενού με διαδοχικά prints.
        System.out.println("\n'1' Προβολή όλων των διαθέσιμων ζώων");
        System.out.println("'2' Προσθήκη νέου ζώου");
        System.out.println("'3' Αναζήτηση με όνομα");
        System.out.println("'4' Αναζήτηση με κωδικό");
        System.out.println("'5' Επεξεργασία ζώου");
        System.out.println("'6' Διαγραφή ζώου");
        System.out.println("'7' ΕΞΟΔΟΣ");

        while (true)
        {
            System.out.print("\nΕισάγετε ενέργεια: ");
            String firstAction = input.nextLine();
            numAction = convertSafelyToInteger(firstAction);

            if (numAction <= 0 || numAction > 7)
            {
                System.out.println("[ΣΦΑΛΜΑ]: Λάθος αριθμός.");
                continue;
            }
            else
                return numAction;
        }     
    }

    //μέθοδος για σειριακή αναζήτηση
    public static boolean serialSearch(String keyword, boolean searchForId, int numericKeyword)
    {
        boolean foundAtLeastOne = false;

        //Ψάχνουμε ένα-ένα τα αντικείμενά μας
        for (Animal a: allAnimals)
        {
            //άμα η boolean μεταβλητή είναι true σημαίνει ότι ψάχνουμε για κωδικό, επομένως έχουμε να κάνουμε με αριθμό, άρα διαφορετική συνθήκη για σειριακή αναζήτηση.
            if (searchForId)
            {
                //από τη στιγμή που έχουμε να κάνουμε με αριθμό, κάνουμε με το σύμβολο '==' την συνθήκη μας.
                if (a.getId() == numericKeyword)
                {
                    System.out.println("ΒΡΕΘΗΚΕ ΑΠΟΤΕΛΕΣΜΑ: " + a.getCustomName() + ", " + a.getAnimalName() + ", " + a.getType() + ", " + a.getMaxAge() + " χρόνια, " + a.getWeight() + " κιλά.");
                    foundAtLeastOne = true;
                }
            }
            else
            {
                //εδώ χρησιμοποιούμε την .equals για να δούμε αν δύο Strings είναι ίδια μεταξύ τους.
                if (a.getCustomName().equals(keyword))
                {
                    System.out.println("ΒΡΕΘΗΚΕ ΑΠΟΤΕΛΕΣΜΑ: " + a.getId() + ", " + a.getAnimalName() + ", " + a.getType() + ", " + a.getMaxAge() + " χρόνια, " + a.getWeight() + " κιλά.");
                    foundAtLeastOne = true;
                }
            }
        }

        //σε περίπτωση που δεν βρήκαμε τίποτα στην λίστα, με τη βοήθεια αυτής της μεταβλητής, πετάμε και το ανάλογο μήνυμα στον χρήστη.
        if (!(foundAtLeastOne))
            System.out.println((numericKeyword == -1)? "\nΔεν βρέθηκαν αποτελέσματα με την λέξη-κλειδί '" + keyword + "'." : "\nΔεν βρέθηκαν αποτελέσματα με τον κωδικό " + numericKeyword + ".");
        
        return foundAtLeastOne;
    }

    public static int convertSafelyToInteger(String s)
    {
        int i;
        while (true)
        {
            try
            {
                i = Integer.parseInt(s);
                return i;
            }
            catch (Exception e)
            {
                System.out.print("[ΣΦΑΛΜΑ]: Θα πρέπει να εισάγετε έναν ακέραιο αριθμό. Προσπαθήστε ξανά --> ");
                s = input.nextLine();
                continue;
            }
        }
    }
}