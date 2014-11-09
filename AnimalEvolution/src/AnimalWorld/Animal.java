package AnimalWorld;

/**
 *
 *
 * Animal is the parent class of all creatures: Mammal
 *
 * @author Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public abstract class Animal implements Organism {

    protected EatingStrategy eatingStrat;
    protected MovementStrategy moveStrat;
    protected OutCrossing outCrossingStrat;
    protected int size;  //the higher the number the bigger the animal
    protected int movementSpeed;   //number is how many squared that the animal can move
    protected int[] position;    //array of size 2, with 0 being the x coord and 1 being the y
    protected boolean isCannibal;  //0 is not a cannibal, 1 is a cannibal
    protected boolean canEatLarger; //0 can not eat larger creatures, 1 can eat larger
    protected String name;    //the name of this Animal
    protected int gender; //0 is a female, 1 is male
    protected BodyComponent body;
    protected int damageConstant;
    protected int damageCapacity;
    protected int markedDamage;

    public Animal(String aniName, int[] attributes, BodyComponent initialBody) {
        position = new int[2];
        position[0] = attributes[0];
        position[1] = attributes[1];

        if (attributes[2] == 1) {
            moveStrat = new Fight();
        } else if (attributes[2] == 2) {
            moveStrat = new Flight();
        } else {
            moveStrat = new RandomMovement();
        }

        if (attributes[3] == 1) {
            eatingStrat = new Carnivore();
            isCannibal = true;
        } else if (attributes[3] == 2) {
            eatingStrat = new Herbivore();
            isCannibal = false;
        } else {
            eatingStrat = new Omnivore();
            isCannibal = false;
        }
        
        body = initialBody;
        size = body.getSize();
        damageCapacity = size/10;
        damageConstant = size/30;
        markedDamage = 0;

        movementSpeed = attributes[4];
        
        gender = attributes[5];

    }

    int eat() //returns 0 if it did not eat and 1 if it did eat
    {
        return 0;
    }

    void move() {

    }

    void takeTurn() {

    }

    @Override
    public int[] getPosition() {
        return position;
    }

    @Override
    public int getX() {
        return position[0];
    }

    @Override
    public int getY() {
        return position[1];
    }
    
    public String getName(){
        return name;
    }
    
    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(o == this) return true;
        if(!(o instanceof Animal)) return false;
        Animal otherAnimal = (Animal) o;
        if(this.getName().equals(otherAnimal.getName()))
            return true;
        else return false;
    }

    abstract int hide(); //returns a 0 if unable to hide and a 1 if hide was successful
}
