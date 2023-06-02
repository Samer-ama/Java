import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BattleGame {

    public static void main(String[] args) {
        playGame("src/player","src/fileName","src/spells");

    }
    private static Random random(){
        Random random = new Random();
        return random;
    }
    private static void attack(Character attacker, Character victim) {
        Random tempo = new Random();
        double random1 = tempo.nextDouble();

        System.out.println(attacker + "\n"+
                "damage percentage is: " + String.format("%.2f",random1));

        if (victim.getCurrentHealth()>0){
            System.out.println(victim.getName() + " got a damage of " +
                    String.format("%.2f",random1));
        } else if (victim.getCurrentHealth()<=0) {
            System.out.println(victim.getName() + " the player was knocked out ");

        } else if (attacker.getCurrentHealth()>0) {
            System.out.println(attacker.getName() + " got a damage of " +
                    String.format("%.2f",random1));
        }else if(attacker.getCurrentHealth()<=0){
            System.out.println(attacker.getName() + " the player was knocked out ");
        }
    }
    public static void playGame(String playerFile, String monsterFile,String spellsFile) {

        if (FileIO.readSpells(spellsFile).equals(null)){
            System.out.println("the game will be played without spells");
        }

        ArrayList<Spell> spellArrayList = FileIO.readSpells(spellsFile);
        Character.setListSpells(spellArrayList);

        Character player = FileIO.readCharacter(playerFile);
        Character monster = FileIO.readCharacter(monsterFile);

        if (player.equals(null) ||
                monster.equals(null)) {
            System.out.println("the game cannot be played.. ");
            return;
        }else {
            System.out.println("player name: "+ player.getName()+"\n" + "current health: " + player.getCurrentHealth() +"\n"+
                    "Attack Value is: " + player.getAttackValue()+"\n" + "The number of wins is: "+player.getNumberOfWins()+"\n\n");
            System.out.println("Monster name: "+ monster.getName()+"\n" + "current health: " + monster.getCurrentHealth() +"\n"+
                    "Attack Value is: " + monster.getAttackValue()+"\n" + "The number of wins is: "+monster.getNumberOfWins()+"\n\n");
        Character.displaySpells();
        }

        Scanner input = new Scanner(System.in);
        while (player.getCurrentHealth() > 0 &&
                monster.getCurrentHealth() > 0) {

            System.out.println("Please enter attack to start, name of spell or quit to exit the Game.");
            String attackersInput = input.nextLine();



            if (attackersInput.equalsIgnoreCase("attack")){
                attack(player,monster);
                attack(monster,player);
            } else if (attackersInput.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye");
                break;

//            } else if (!attackersInput.equalsIgnoreCase("attack") ||
//            !attackersInput.equalsIgnoreCase("quit")) {
//                System.out.println("invalid entry.. please try 'attack' to play or 'quit' to exit the game ");
            }else {
                int random1 = random().nextInt();
                double damage = Character.castSpell(attackersInput,random1);

                if (damage<=0){
                    System.out.println("The " + player.getName() + " tried to cast a spell, but they failed" );
                }else {
                    System.out.println(String.format("the" + attackersInput + " was casted and produced "
                                    + String.format("%.2f",damage) +
                                    " this damage that " + monster.getName() + " receive."));
                }
            }
            if (player.getCurrentHealth()<=0){
                System.out.println("Game over" + monster.getName() + " wins the game..");
                monster.increaseWins();
                Character winningCharacter = new Character(monster.getName(), monster.getAttackValue(),monster.getMaximumHealth(),monster.getNumberOfWins());
                FileIO.writeCharacter(winningCharacter,("src/fileName"));

            }else if (monster.getCurrentHealth()<=0){
                System.out.println("Game over" + player.getName() + "wins the game..");
                player.increaseWins();
                Character winningCharacter1 = new Character(player.getName(),player.getAttackValue(),player.getMaximumHealth(),player.getNumberOfWins());
                FileIO.writeCharacter(winningCharacter1,"src/player");
            }
        }
    }
}


