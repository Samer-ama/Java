import java.util.Random;
import java.util.Scanner;

public class BullAndCows {
    public static void main(String[] args) {



    }
            public static boolean contains(int[] array, int specificNumber) {
                boolean isTrue = false;
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == specificNumber) {
                        isTrue = true;
                        break;
                    }
                }
                return isTrue;
            }

            public static int[] generateSecretDigits(int x) {
                Random random = new Random(x);
                int[] array = new int[4];
                int i = 0;
                while (i < 4) {
                    int j = random.nextInt(10);
                    if (!contains(array, j)) {
                        array[i] = j;
                        i++;
                    }
                    if (i == 4) {
                        break;
                    }
                }
                return array;
            }

            public static int getNumOfBulls(int[] secretNumber, int[] guessedNumber) {
                if (secretNumber.length != guessedNumber.length) {
                    throw new IllegalArgumentException("Please enter a four-digit number!");
                }
                for (int j=0;j<guessedNumber.length;j++) {
                    for (int k=j+1;k<guessedNumber.length;k++) {
                        if (guessedNumber[k]==guessedNumber[j]){
                            throw new IllegalArgumentException("Repeating the exact number is not permitted!");
                        }
                    }
                }
                int bulls = 0;
                for (int i = 0; i < guessedNumber.length; i++) {
                    if (guessedNumber[i] == secretNumber[i]) {
                        bulls++;
                    }
                }
                return bulls;
            }

            public static int getNumOfCows(int[] secretNumber, int[] guessedNumber) {
                if (secretNumber.length != guessedNumber.length) {
                    throw new IllegalArgumentException("Please enter a four-digit number!!");
                }
                for (int j=0;j<guessedNumber.length;j++) {
                    for (int k=j+1;k<guessedNumber.length;k++) {
                        if (guessedNumber[k]==guessedNumber[j]){
                            throw new IllegalArgumentException("Repeating the exact number is not permitted!");
                        }
                    }
                }
                int cows = 0;
                for (int i = 0; i < guessedNumber.length; i++) {
                    if (contains(secretNumber, guessedNumber[i]) && guessedNumber[i] != secretNumber[i]) {
                        cows++;
                    }
                }
                return cows;
            }

            public static int playBullsAndCows() {
                Scanner sc = new Scanner(System.in);
                int[] arr = generateSecretDigits(911);
                System.out.println(" enjoy the game ");
                int bulls;
                int cows;
                String leave = "N";
                int guess = 1;
                do {

                    System.out.print("Guess #" + guess + ", A four-digit number is required, each digit should be unique :");
                    try {
                        String num = sc.nextLine();
                        int[] toCheck = new int[4];
                        for (int i = 0; i < 4; i++) {
                            toCheck[i] = Integer.parseInt(String.valueOf(num.charAt(i)));
                        }
                        bulls = getNumOfBulls(arr, toCheck);
                        cows = getNumOfCows(arr, toCheck);
                        System.out.println("Bulls: " + bulls);
                        System.out.println("Cows: " + cows);
                        if (bulls == 4 && cows == 0) {
                            System.out.println(
                                    "Congratulations, you guessed the secret number! It took you " + guess + " attempts");
                            break;
                        }
                        guess++;
                    } catch (IllegalArgumentException e) {
                        bulls = 0;
                        cows = 0;
                        guess++;
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        bulls = 0;
                        cows = 0;
                        guess++;
                        System.out.println("You must enter a four-digit number! You just wasted a guess!");
                    }
                    if (guess > 5) {
                        System.out.print("wanna leave the game? type: y/n ");
                        leave = sc.nextLine();
                        if ("y".equalsIgnoreCase(leave)) {
                            System.out.println("You've decided to leave the game, you made " + guess + " attempts so far");
                            break;
                        }
                    }

                } while (!leave.equalsIgnoreCase("y"));
                return playBullsAndCows();
    }
}
