//importing the scanner so that user input can be accepted
import java.util.Scanner;

public class CaeserCipher {

    private static Scanner sc = new Scanner(System.in);

    public static void run(){
        //creates menu
        System.out.println(
                """
                1. Encrypt
                2. Decrypt
                3. Quit
                Enter choice:\s
                """
        );
        int choice = sc.nextInt();
        sc.nextLine(); //Buffer

        if(choice==1){
            encrypt();
        }
        if(choice==2){
            decrypt();
        }

    }

    private static void encrypt() {
        System.out.print("Key: ");
        int key = sc.nextInt();
        sc.nextLine(); //Buffer
        System.out.println("Enter text: ");
        String text = sc.nextLine();
        String finalText = "";
        //loops through the length of the text that is entered
        for(int i = 0; i < text.length(); i++) {
            //multiple checks to loop through all of the 8 bits
            int ascii = text.charAt(i);
            System.out.println(ascii);
            if(ascii>=65 & ascii <=90){
                int letter = ascii + key;
                if(letter>90){
                    letter -=26;
                }
            }
            else{
                int letter = ascii + key;
                if(letter>122){
                    letter -= 26;
                }
            }

            finalText += (char)letter;
        }
        System.out.println(finalText);

    }

    private static void decrypt() {
        System.out.print("Key: ");
        int key = sc.nextInt();
        sc.nextLine(); //Buffer
        System.out.println("Enter text: ");
        String text = sc.nextLine();
        String finalText = "";
        //loops through the length of the text that is entered
        for(int i = 0; i < text.length(); i++) {
            //multiple checks to loop through all of the 8 bits
            int ascii = text.charAt(i);
            System.out.println(ascii);
            if(ascii>=65 & ascii <=90){
                int letter = ascii - key;
                if(letter<65){
                    letter +=26;
                }
            }
            else{
                int letter = ascii - key;
                if(letter<97)
                    letter +=26;
                letter += 26;
            }

            finalText += (char)letter;
        }
        System.out.println(finalText);

    }


}

