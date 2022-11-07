//importing the scanner so that user input can be accepted
import java.sql.SQLOutput;
import java.util.Scanner;

public class CaeserCipher {

    private static Scanner sc = new Scanner(System.in);

    public static void run() { //constructor where input for chioce of action is enterred
        //creates menu
        int choice = 1;// just to get the loop started value of "choice" is fixed

        while (choice != 3) { // if choice is 3, the program will just end and stop running
            System.out.println();
            //text for the menu for user to see the options
            System.out.println(
                    """
                            1. Encrypt
                            2. Decrypt
                            3. Quit
                            Enter choice:\s
                            """
            );
            choice = sc.nextInt(); //user enters number
            sc.nextLine(); //Buffer

            if (choice == 1) { // if 1 is entered then encrypt function is called
                encrypt();
            }

            if (choice == 2) { // if 2 is entered then decrypt function is called
                decrypt();
            }
        }


    }


    private static void encrypt() { // encrypt function
        System.out.print("Key: ");
        int key = sc.nextInt(); // user enters key
        sc.nextLine(); //Buffer
        System.out.println("Enter text: ");
        String text = sc.nextLine(); // user enters text
        String finalText = "";
        //loops through the length of the text that is entered
        for(int i = 0; i < text.length(); i++) {
            int ascii = text.charAt(i); // ascii value of specific character at position i is stored
            int letter; // letter variable is declared
            if(ascii>=65 & ascii <=90){ // if the ascii value is between these, letter is capital case
                letter = ascii + key; // add key to ascii value
                if(letter>90){ // if the new letter's ascii is greater than that of Z, subtract 26
                    letter -=26;
                }
            }
            else{ // letter looked at is lower case
                letter = ascii + key; // add key to ascii value
                if(letter>122){ // if the ascii is greater than 122, which is z, subtract 26
                    letter -= 26;
                }
            }

            finalText += (char)letter; // converts ascii to char, and appends this to finalText
        }
        System.out.println(finalText); // once done looping, prints out the final text which has all characters appended

    }

    private static void decrypt() { // decrypt function
        System.out.print("Key: ");
        int key = sc.nextInt(); // user enters key to be shifted by
        sc.nextLine(); //Buffer
        System.out.println("Enter text: ");
        String text = sc.nextLine();
        String finalText = "";
        //loops through the length of the text that is entered
        for(int i = 0; i < text.length(); i++) {
            //multiple checks to loop through all of the 8 bits
            int ascii = text.charAt(i);
            int letter;
            if(ascii>=65 & ascii <=90){
                letter = ascii - key;
                if(letter<65){
                    letter +=26;
                }
            }
            else{
                letter = ascii - key;
                if(letter<97)
                    letter +=26;
            }

            finalText += (char)letter;
        }
        System.out.println(finalText);

    }


}

