import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class zooMain
{
    static final Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        List<Animal> allAnimals = new ArrayList<>();
        int menu = 0;

        Animal a1 = new Animal("Jigger", "Tiger", "Mammal", 120, 25);
        Animal a2 = new Animal("Shiba", "Leopard", "Mammal", 10, 15);
        Animal a3 = new Animal("Jason", "Wolf", "Mammal", 90, 30);
        Animal a4 = new Animal("Errand", "Parrot", "Aves", 90, 30);

        allAnimals.add(a1);
        allAnimals.add(a2);
        allAnimals.add(a3);

        System.out.println("ΓΙΩΡΓΟΣ ΣΕΪΜΕΝΗΣ, ΠΑΝΕΠΙΣΤΗΜΙΟ ΠΕΙΡΑΙΩΣ ΤΜΗΜΑ ΠΛΗΡΟΦΟΡΙΚΗΣ, Π19204\n\n");


        System.out.println("Καλώς ορίσατε στο μενού του Ζωολογικού Κήπου. Ενέργειες:");

        do
        {
            menu = showMenu();
            switch (menu)
            {
                case 1:
                    System.out.println("ΛΙΣΤΑ ΜΕ ΟΛΑ ΤΑ ΔΙΑΘΕΣΙΜΑ ΖΩΑ:\n");
                    int i = 1;
                    for (Animal a: allAnimals)
                    {
                        System.out.println(i + ". " + "Όνομα: " + a.getCustomName() + ", Ζώο: " + a.getAnimalName() + ", Κωδικός: " + a.getId());
                        i++;
                    }

                    System.out.print("\nΠατήστε enter για να επιστρέψετε στο μενού...");
                    try
                    {
                        System.in.read();
                    }
                    catch (Exception e)
                    {}
                    continue;
                case 2:
                    String customName, animalName, type;
                    int maxAge, weight; 
            
                    System.out.println("=== ΜΕΝΟΥ ΠΡΟΣΘΗΚΗΣ ΝΕΟΥ ΖΩΟΥ ===\n");
            
                    //εισαγωγή στοιχείων του ζώου. Από τη στιγμή που ο Χρήστης εισάγει strings δεν χρειάζεται κάποιος έλεγχος.
                    System.out.print("Τι ζώο είναι; --> ");
                    animalName = input.next();

                    System.out.print("Πώς θέλετε να το ονομάσετε; --> ");
                    customName = input.next();

                    System.out.print("Σε ποιά κατηγορία ανήκει (π.χ. θηλαστικό); --> ");
                    type = input.next();

                    //εισαγωγή αριθμητικών στοιχείων, εδώ θα χρειαστεί λίγος παραπάνω έλεγχος.
                    System.out.print("Πόσα κιλά (kg) ζυγίζει; --> ");
                    weight = input.nextInt();

                    System.out.print("Ποιά είναι μέγιστη ηλικία του; --> ");
                    maxAge = input.nextInt();
                    
                    Animal a = new Animal(animalName, customName, type, weight, maxAge);
                    allAnimals.add(a);
                    continue;
                case 3:
                    continue;
                case 4:
                    continue;
                case 5:
                    continue;
                case 6:
                    continue;
            }
        } while(menu != 7);
    }

    public static int showMenu()
    {
        //Scanner input = new Scanner(System.in);
        String firstAction = "";
        int numAction = 0;

        //εμφάνιση του μενού με διαδοχικά prints.
        System.out.println("\n'1' Προβολή όλων των διαθέσιμων ζώων");
        System.out.println("'2' Προσθήκη νέου ζώου");
        System.out.println("'3' Αναζήτηση με όνομα");
        System.out.println("'4' Αναζήτηση με κωδικό");
        System.out.println("'5' Επεξεργασία ζώου");
        System.out.println("'6' Διαγραφή ζώου");
        System.out.println("'7' ΕΞΟΔΟΣ");
        
        //χρησιμοποιούμε μια do while επανάληψη, για να διασφαλίσουμε την επιθυμητή είσοδο του χρήστη.
        do
        {
            //μήνυμα για εισαγωγή ενέργειας
            System.out.print("\nΕισάγετε ενέργεια: ");
            firstAction = input.next();
            
            //θα πρέπει να υπολογίσουμε κάθε πιθανό σενάριο εισόδου, οπότε σε περίπτωση που ο Χρήστης δώσει κάποιο γράμμα και όχι αριθμό, πρέπει να πράξουμε ανάλογα.
            try
            {
                //πρσοπάθεια απόσπασης σε ακέραια τιμή του αριθμού που δίνει ο Χρήστης
                numAction = Integer.parseInt(firstAction);

                //έλεγχος για το αν η τιμή που εισήχθη είναι έγκυρη. Αν δεν είναι έγκυρη, προβάλλουμε μήνυμα, και μετά ξανά προσπαθούμε με την λέξη continue
                if (numAction <= 0 || numAction > 7)
                {
                    System.out.print("[ΣΦΑΛΜΑ]: Λάθος αριθμός.");
                    continue;
                }
                else break;
            }
            //κώδικας που εκτελείται σε περίπτωση που ο χρήστης ΔΕΝ έχει δώσει αριθμό.
            catch (Exception e)
            {
                System.out.print("[ΣΦΑΛΜΑ]: Θα πρέπει να εισάγετε κάποιον αριθμό.");
            }
        } while (true);

        return numAction;
    }
}