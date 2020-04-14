public class Animal
{
    private int weight, maxAge;
    private String id, name, type, animalName;

    public Animal(int w, int m, String i, String n, String t, String a)
    {
        weight = w;
        maxAge = m;
        id = i;
        name = n;
        type = t;
        animalName = a;
    }

    //getters για τις τιμές των ζώων
    public int    getWeight()      {return weight;}
    public int    getMaxAge()      {return maxAge;}
    public String getId()          {return id;}
    public String getName()        {return name;}
    public String getType()        {return type;}
    public String getAnimalName()  {return animalName;}

}