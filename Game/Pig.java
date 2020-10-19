import java.util.Random;
import java.util.Scanner;

public class PigGameP3 {
    static final int TARGET = 100;
    static final int LIMIT = 20;

    public PigGameP3() {
    }

    public static void main(String[] args) {
        int cspoints = 0;
        int csscore = 0;
        int userpoints = 0;
        int userscore = 0;
        Scanner keyboard = new Scanner(System.in);
        Random rnd = new Random();
        boolean found = true;

        while(found) {
            int r;
            do {
                r = 1 + rnd.nextInt(6);
                System.out.println("Users turn r or h:");
                char letter = keyboard.next().charAt(0);
                if (letter == 'r' && r == 1) {
                    userscore += userpoints;
                    userpoints = 0;
                    System.out.println("Rolled a " + r);
                    System.out.println("Users current points earned: " + userpoints);
                    System.out.println("Users score: " + userscore);
                    break;
                }

                else if (letter == 'r' && r != 1 && r <= 6) {
                    userpoints += r;
                    System.out.println("Rolled a " + r);
                    System.out.println("Users current points earned: " + userpoints);
                }

                else if (letter == 'h') {
                    userpoints += r;
                    System.out.println("Rolled a " + r);
                    System.out.println("Users current points earned: " + userpoints);
                    userscore += userpoints;
                    System.out.println("Users score: " + userscore);
                    userpoints = 0;
                    break;
                }

                else if (userscore >= 100) {
                    System.out.println("User wins!");
                    System.out.println("Users score: " + userscore);
                    System.exit(0);
                    found = false;
                }
                else{
                    System.out.println("Error try again.");
                    continue;
                }
            } while(userscore < 100);

            do {
                r = 1 + rnd.nextInt(6);
                System.out.println("Computers turn:");
                if (r == 1) {
                    System.out.println("Rolled a " + r);
                    csscore += cspoints;
                    cspoints = 0;
                    System.out.println("Computers current points earned: " + cspoints);
                    System.out.println("Computers score: " + csscore);
                    break;
                }

                if (r != 1 && r <= 6) {
                    cspoints += r;
                    System.out.println("Rolled a " + r);
                    System.out.println("Computers current points earned: " + cspoints);
                }

                if (cspoints >= 20) {
                    cspoints += r;
                    System.out.println("Rolled a " + r);
                    System.out.println("Computers current points earned: " + cspoints);
                    csscore += cspoints;
                    System.out.println("Computers score: " + csscore);
                    cspoints = 0;
                    break;
                }

                if (csscore >= 100) {
                    System.out.println("Computer wins!");
                    System.out.println("Computers score: " + csscore);
                    System.exit(0);
                    found = false;
                }
            } while(csscore < 100);

            System.out.println("==============================================");
            System.out.println("Users score: " + userscore + " Computers score: " + csscore);
        }

    }
}
