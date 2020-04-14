import java.util.Scanner;

public class zooMain
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        //εμφάνιση του μενού με διαδοχικά prints.
        System.out.println("ΓΙΩΡΓΟΣ ΣΕΪΜΕΝΗΣ, ΠΑΝΕΠΙΣΤΗΜΙΟ ΠΕΙΡΑΙΩΣ ΤΜΗΜΑ ΠΛΗΡΟΦΟΡΙΚΗΣ, Π19204");


        System.out.println("\n\nΚαλώς ορίσατε στο μενού του Ζωολογικού Κήπου. Ενέργειες:\n");
        System.out.println("'1' Προβολή όλων των διαθέσιμων ζώων");
        System.out.println("'2' Προσθήκη νέου ζώου");
        System.out.println("'3' Αναζήτηση με όνομα");
        System.out.println("'4' Αναζήτηση με κωδικό");
        System.out.println("'5' Επεξεργασία ζώου");
        System.out.println("'6' Διαγραφή ζώου");
        System.out.println("'7' ΕΞΟΔΟΣ\n");
        
        System.out.println("\nΕισάγετε ενέργεια: ");
    }
}