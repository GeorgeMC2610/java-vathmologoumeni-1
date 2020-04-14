public class Animal
{
    private int weight, maxAge, id;
    private String name, type, animalName;

    public Animal(String n, String a, String t, int i)
    {
        weight     = 0;
        maxAge     = 0;
        id         = i;
        name       = n;
        type       = t;
        animalName = a;
    }

    //getters για τις τιμές των ζώων
    public int    getWeight()      {return weight;}
    public int    getMaxAge()      {return maxAge;}
    public int    getId()          {return id;}
    public String getName()        {return name;}
    public String getType()        {return type;}
    public String getAnimalName()  {return animalName;}


}