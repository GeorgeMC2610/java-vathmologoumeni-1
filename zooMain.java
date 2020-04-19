import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class zooMain
{
    static final Scanner input = new Scanner(System.in);
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
                    String answer = input.nextLine();

                    if (answer.equals("y"))
                        break;
                    else
                        menu = 7;
                        break;
                case 2:
                    String customName, animalName, type;
                    int maxAge, weight; 
            
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
                    weight = input.nextInt();

                    System.out.print("Ποιά είναι μέγιστη ηλικία του; --> ");
                    maxAge = input.nextInt();
                    
                    Animal a = new Animal(customName, animalName, type, weight, maxAge);
                    allAnimals.add(a);

                    System.out.println("\n[ΠΡΟΣΘΗΚΗ]: Επιτυχής προσθήκη! Το ζώο σας είναι στον ζωολογικό κήπο με κωδικό " + a.getId());
                    menu = 0;
                    break;
                case 3:
                    String answer1, keyword;

                    do
                    {
                        System.out.print("Ποιό όνομα θέλετε να ψάξετε; --> ");
                        keyword = input.nextLine();
                        
                        serialSearch(keyword, false);

                        System.out.print("\nΘα θέλατε να ψάξετε και για κάποιο άλλο όνομα; (y/n) --> ");
                        answer1 = input.nextLine();

                    } while (answer1.equals("y"));

                    break;
                case 4:
                    String startingKeyword, answer2 = "";
                    int numericKeyword = -1;

                    do
                    {
                        System.out.print("Ποιον κωδικό θέλετε να ψάξετε; --> ");
                        startingKeyword = input.nextLine();

                        try
                        {
                            numericKeyword = Integer.parseInt(startingKeyword);
                        }
                        catch (Exception e)
                        {
                            System.out.println("[ΣΦΑΛΜΑ]: O κωδικός θα πρέπει να είναι αριθμός.");
                        }

                        if (numericKeyword != -1)
                            serialSearch(startingKeyword, true);

                        System.out.print("\nΘα θέλατε να ψάξετε για κάποιον άλλον κωδικό; (y/n) --> ");
                        answer2 = input.nextLine();

                    } while (answer2.equals("y"));
                    
                    break;
                case 5:
                    break;
                case 6:
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
        
        //χρησιμοποιούμε μια do-while επανάληψη, για να διασφαλίσουμε την επιθυμητή είσοδο του χρήστη.
        do
        {
            //μήνυμα για εισαγωγή ενέργειας
            System.out.print("\nΕισάγετε ενέργεια: ");
            String firstAction = input.nextLine();
            
            //θα πρέπει να υπολογίσουμε κάθε πιθανό σενάριο εισόδου, οπότε σε περίπτωση που ο Χρήστης δώσει κάποιο γράμμα και όχι αριθμό, πρέπει να πράξουμε ανάλογα.
            try
            {
                //πρσοπάθεια απόσπασης σε ακέραια τιμή του αριθμού που δίνει ο Χρήστης
                numAction = Integer.parseInt(firstAction);

                //έλεγχος για το αν η τιμή που εισήχθη είναι έγκυρη. Αν δεν είναι έγκυρη, προβάλλουμε μήνυμα, και μετά ξανά προσπαθούμε με την λέξη continue.
                if (numAction <= 0 || numAction > 7)
                {
                    System.out.print("[ΣΦΑΛΜΑ]: Λάθος αριθμός.");
                    continue;
                }
                else
                    break;
            }
            //κώδικας που εκτελείται σε περίπτωση που ο χρήστης ΔΕΝ έχει δώσει αριθμό.
            catch (Exception e)
            {
                System.out.print("[ΣΦΑΛΜΑ]: Θα πρέπει να εισάγετε κάποιον αριθμό.");
            }
        } while (true);

        return numAction;
    }

    //μέθοδος για σειριακή αναζήτηση
    public static void serialSearch(String keyword, boolean searchForId)
    {
        int numericKeyword = -1;
        boolean foundAtLeastOne = false;

        for (Animal a: allAnimals)
        {
            if (searchForId == true)
            {
                numericKeyword = Integer.parseInt(keyword);

                if (a.getId() == numericKeyword)
                {
                    System.out.println("ΒΡΕΘΗΚΕ ΑΠΟΤΕΛΕΣΜΑ: " + a.getCustomName() + ", " + a.getAnimalName() + ", " + a.getType() + ", " + a.getMaxAge() + " χρόνια, " + a.getWeight() + " κιλά.");
                    foundAtLeastOne = true;
                }
            }
            else
            {
                if (a.getCustomName().equals(keyword))
                {
                    System.out.println("ΒΡΕΘΗΚΕ ΑΠΟΤΕΛΕΣΜΑ: " + a.getId() + ", " + a.getAnimalName() + ", " + a.getType() + ", " + a.getMaxAge() + " χρόνια, " + a.getWeight() + " κιλά.");
                    foundAtLeastOne = true;
                }
            }
        }

        if (!(foundAtLeastOne))
            System.out.println("Δεν βρέθηκαν αποτελέσματα με την λέξη-κλειδί '" + keyword + "'.");
    }
}