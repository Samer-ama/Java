
import java.util.Random;

public class Spell {

    private String name;
    private double minmumDamage;
    private double maximumDamage;
    private double chanceOfSuccess;


    public Spell(String name, double minmumDamage, double maximumDamage, double chanceOfSuccess){
        if (minmumDamage < 0 || minmumDamage > maximumDamage ||
                chanceOfSuccess < 0 || chanceOfSuccess > 1) {
            throw new IllegalArgumentException("please verify your entry.. ");
        }
        this.name = name;
        this.minmumDamage = minmumDamage;
        this.maximumDamage = maximumDamage;
        this.chanceOfSuccess = chanceOfSuccess;
    }

    public String getName() {

        return this.name;
    }

    public double getMagicDamage(int a) {
        Random random2 = new Random(a);
        double spellAttack = (random2.nextDouble()*(1-0) + 0);

        if(spellAttack > chanceOfSuccess){
            return 0;
        } else {
            return  spellAttack;
        }
    }

    public String toString(){
        return "The name of the spell : " + name + "\n" + "Minimum Damage : " + minmumDamage
                + " \n " + "Maximum Damage : " + maximumDamage + " \n" +
                "Success of Chance : " + chanceOfSuccess*100 +"% \n";
    }


}
