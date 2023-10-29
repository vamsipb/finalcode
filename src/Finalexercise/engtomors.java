package Finalexercise;

import java.util.Scanner;

public class engtomors {
    public static void main(String[] args) {
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f',
                'g', 'h', 'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x',
                'y', 'z', '1', '2', '3', '4',
                '5', '6', '7', '8', '9', '0', '.', ',', '?'};
        String[] code
                = {".-", "-...", "-.-.", "-..", ".",
                "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---",
                ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--",
                "--..", ".-.-.-", "--..--", "..--..", "/"};
        engtomors trt = new engtomors();
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the number to choose");
        int input = scan.nextInt();
        scan.nextLine();

        if (input == 1) {
            System.out.println("Enter Morse code separated by semicolons: ");
            String morse = scan.nextLine();
            String text = trt.morseToEnglish1(code, morse);
            System.out.println("Translated Text: " + text);
        } else if (input == 2) {
            System.out.println("Enter Text separated by spaces: ");
            String text = scan.nextLine();
            String morse = trt.englishToMorse(code, text, alphabet);
            System.out.println("Translated Morse Code: " + morse);
        } else {
            throw new RuntimeException("Not implemented");
        }
    }

    public String morseToEnglish1(String[] code, String input) {
        String output = "";
        String[] array = input.split(" ");
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(";")) {
                output = output + " ";
            }

            for (int j = 0; j < code.length; j++) {
                if (array[i].compareTo(code[j]) == 0) {
                    output = output + (char) (j + 'a');
                    break;
                }
            }
        }
        return output;
    }
    public String englishToMorse(String[] code, String input, char[] letter) {
        String output = "";
        if (!input.isEmpty()) {
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == ' ') {
                    output = output + "; ";
                }
                for (int j = 0; j < letter.length; j++) {
                    if (input.charAt(i) == letter[j]) {
                        output = output + code[j] + " ";
                        break;
                    }
                }
            }
            return output;
        } else {
            throw new RuntimeException("Invalid input");
        }
    }
}

