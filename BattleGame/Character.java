import java.util.ArrayList;
import java.util.Random;
public class Character {
    private String name;
    private double attack;
    private double maximumHealth;
    private double currentHealth;
    private int numberOfWins;

    public Character(String name, double attack, double maximumHealth, int numberOfWins) {
        this.name = name;
        this.attack = attack;
        this.maximumHealth = maximumHealth;
        this.numberOfWins = numberOfWins;
        this.currentHealth = maximumHealth;
    }
    public String getName() {
        return this.name;
    }

    public Double getAttackValue() {

        return this.attack;
    }

    public Double getMaximumHealth() {

        return this.maximumHealth;
    }

    public Double getCurrentHealth() {

        return this.currentHealth;
    }

    public int getNumberOfWins() {

        return this.numberOfWins;
    }

    public String toString() {
        return "Player's name : " + name + "\n" + "Health is : " + currentHealth;
    }


    public double getAttackDamage(int x ) {
        Random random = new Random(x);
        double attackValue = (random.nextDouble() * (1.0 - 0.7) + 0.7) * attack;
        return attackValue;
    }

    public double takeDamage(double damage) {
        return currentHealth - damage;
    }

    public void increaseWins() {
        numberOfWins++;
    }


    private static ArrayList<Spell> listSpells;


    public static void setListSpells(ArrayList<Spell> spells) {
        ArrayList<Spell> arrayList = new ArrayList<>();
        for (int i = 0; i < spells.size(); i++) {
            arrayList.add(spells.get(i));
        }
        listSpells = arrayList;
    }

    public static void displaySpells() {
        for (int i = 0; i < listSpells.size(); i++) {
            System.out.println(listSpells.get(i).toString());
        }
    }

    public static double castSpell(String spellName, int number ) {

        for (int i = 0; i < listSpells.size(); i++) {
            if (listSpells.get(i).getName().equalsIgnoreCase(spellName)) {
                double damage = listSpells.get(i).getMagicDamage(number);
                return damage;
            }
        }
        return -1;
    }
    }

