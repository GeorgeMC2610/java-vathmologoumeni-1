import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class zooMain
{
    public static void main(String[] args)
    {
        List<Animal> allAnimals = new ArrayList<>();

        Animal a1 = new Animal("Takis", "Tiger", "Mammal", 120, 25);
        Animal a2 = new Animal("Shiba", "Cat", "Mammal", 10, 15);
        Animal a3 = new Animal("Jason", "Wolf", "Mammal", 90, 30);

        /*switch (showMenu())
        {
            case 1:
                System.out.println("Lista me ta zwa");
                System.out.println("kiallos kwdikas");
                break;
            case 2:
                System.out.println("Prosthiki neou zwou");
                System.out.println("Kiallos kwdiks");
                break;
        }*/
    }

    public static int showMenu()
    {
        Scanner input = new Scanner(System.in);
        String firstAction = "";
        int numAction = 0;

        //εμφάνιση του μενού με διαδοχικά prints.
        System.out.println("ΓΙΩΡΓΟΣ ΣΕΪΜΕΝΗΣ, ΠΑΝΕΠΙΣΤΗΜΙΟ ΠΕΙΡΑΙΩΣ ΤΜΗΜΑ ΠΛΗΡΟΦΟΡΙΚΗΣ, Π19204\n\n");


        System.out.println("Καλώς ορίσατε στο μενού του Ζωολογικού Κήπου. Ενέργειες:\n");

        System.out.println("'1' Προβολή όλων των διαθέσιμων ζώων");
        System.out.println("'2' Προσθήκη νέου ζώου");
        System.out.println("'3' Αναζήτηση με όνομα");
        System.out.println("'4' Αναζήτηση με κωδικό");
        System.out.println("'5' Επεξεργασία ζώου");
        System.out.println("'6' Διαγραφή ζώου");
        System.out.println("'7' ΕΞΟΔΟΣ\n");
        
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

    //συνάρτηση προσθήκης νέου ζώου
    public static void addNewAnimal()
    {
        System.out.println("");
    }
}