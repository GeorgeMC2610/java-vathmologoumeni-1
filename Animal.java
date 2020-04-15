import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Animal
{
    private int weight, maxAge, id;
    private String customName, type, animalName;
    private static List<Integer> takenIds  = new ArrayList<>();

    public Animal()
    {
        weight     = -1;
        maxAge     = -1;
        id         = -1;
    }

    public Animal(String customName, String animalName, String type, int weight, int maxAge)
    {
        this.customName = customName;
        this.animalName = animalName;
        this.type       = type;
        this.weight     = weight;
        this.maxAge     = maxAge;
        this.id         = generateNewId();
    }

    //getters για τις τιμές των ζώων
    public int    getWeight()      {return weight;}
    public int    getMaxAge()      {return maxAge;}
    public int    getId()          {return id;}
    public String getCustomName()  {return customName;}
    public String getType()        {return type;}
    public String getAnimalName()  {return animalName;}

    //setters των τιμών. Setter για τον κωδικό (id) δεν θα υπάρχει, καθώς θέλουμε αυτή η πληροφορία να είναι άκρως προστατευμένη.
    public void setWeight(int weight) 
    {
        if (weight > 0)
            this.weight = weight;
    }

    public void setMaxAge(int maxAge)
    {
        if (maxAge > 0)
            this.maxAge = maxAge;
    }

    public void setCustomName(String customName)    {this.customName = customName;}
    public void setType(String type)                {this.type = type;}
    public void setAnimalName(String animalName)    {this.animalName = animalName;}

    //σε περίπτωση που χρειαστεί να παράγουμε έναν κωδικό για ένα ζώο, έχουμε αυτήν εδώ τη συνάρτηση, που επιστρέφει έναν τυχαίο αριθμό από το 10000 έως το 99999.
    private static int generateNewId()
    {
        Random rand = new Random();
        boolean found = false;
        int a = 10000;

        while (found == false)
        {
           a = rand.nextInt(99999);

           for (int i = 0; i < takenIds.size(); i++)
           {
               if (a == takenIds.get(i))
                    a = rand.nextInt(99999);
           }
           
           found = true;
        }

        takenIds.add(a);
        return a;
    }
}