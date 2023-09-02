import java.io.*;
public class Task1 {
    int i = 0;
    Console con = System.console();

    public void check() {
        System.out.println("You wants to play more?");
        System.out.println("Press 1 to continue or 0 for exit");
        int f = Integer.parseInt(con.readLine());
        if (f == 1) {
            i = 4;
        } else {
            i = -1;
        }
        return;
    }
    
    public static void main(String[] args) {
        Task1 game = new Task1(); 

        int temp = (int) (Math.random() * 100);
        int cnt = 0;
        int loss=0;
        for (game.i = 3; game.i >= 0; game.i--) {
            System.out.println("Enter the guess no");
            int no = Integer.parseInt(game.con.readLine());
            if (no == temp) {
                System.out.println("Your guess is right");

                cnt++;
                game.check();
            } else if (no > temp) {
                System.out.println("Your guess is too high");
                System.out.println("now you left with " + game.i + " choices");
                loss++;
            } else if (no < temp) {
                System.out.println("Your guess is too low");
                System.out.println("now you left with " + game.i + " choices");
                loss++;
            }
            if (game.i == 0) {
                game.check();
            }
        }
        System.out.println("The Total no. of times you won is " + cnt+" The Total no. of times you loss is "+loss);
    }
}