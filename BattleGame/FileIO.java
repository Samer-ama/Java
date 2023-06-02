import java.io.*;
import java.util.ArrayList;

public class FileIO {

    public static Character readCharacter(String fileName) {

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String name = bufferedReader.readLine();
            double attackValue = Double.parseDouble(bufferedReader.readLine());
            double maximumHealth = Double.parseDouble(bufferedReader.readLine());
            int numberOfWin = Integer.parseInt(bufferedReader.readLine());

            bufferedReader.close();
            fileReader.close();

            Character character = new Character(name, attackValue, maximumHealth, numberOfWin);
            return character;

        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("unable to locate the file");

        } catch (IOException o) {
            throw new IllegalArgumentException("please Verify the file input and try again");
        }
    }
    public static ArrayList<Spell> readSpells(String fileName){
        ArrayList<Spell> spellArrayList = new ArrayList<>();

        try{
            FileReader fileReader1 = new FileReader(fileName);
            BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
            String line = bufferedReader1.readLine();

            while(line != null){
                String[] items = line.split(" ");
                String name = items[0];
                double minDamage = Double.parseDouble(items[1]);
                double maxDamage = Double.parseDouble(items[2]);
                double chanceOfSuccess = Double.parseDouble(items[3]);
                Spell tempo = new Spell(name, minDamage, maxDamage, chanceOfSuccess);

                spellArrayList.add(tempo);
                line = bufferedReader1.readLine();
            }

            bufferedReader1.close();
            fileReader1.close();

            return spellArrayList;

        } catch (FileNotFoundException e){
            throw new IllegalArgumentException("unable to locate the file");

        } catch (IOException o){
            throw new IllegalArgumentException("please Verify the file input and try again");
        }
    }

    public static void writeCharacter(Character charToWrite, String fileToWrite ) {
        try {
            FileWriter fileWriter = new FileWriter(fileToWrite);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(charToWrite.getName());
            System.out.println();
            bufferedWriter.write("" + charToWrite.getAttackValue());
            System.out.println();
            bufferedWriter.write("" + charToWrite.getMaximumHealth());
            System.out.println();
            bufferedWriter.write("" + charToWrite.getNumberOfWins());
            System.out.println();

            bufferedWriter.close();
            fileWriter.close();

        } catch(FileNotFoundException e) {
            System.out.println("unable to locate the file");
        } catch(IOException o) {
            System.out.println("please Verify the file input and try again");
        }
    }
}


