public class PhoneNumberDecoder {
    public static void main(String[] args) {
        String input = "800888TEST";
        String output = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == 'A' || ch == 'B' || ch == 'C') output += '2';
            else if (ch == 'D' || ch == 'E' || ch == 'F') output += '3';
            else if (ch == 'G' || ch == 'H' || ch == 'I') output += '4';
            else if (ch == 'J' || ch == 'K' || ch == 'L') output += '5';
            else if (ch == 'M' || ch == 'N' || ch == 'O') output += '6';
            else if (ch == 'P' || ch == 'Q' || ch == 'R' || ch == 'S') output += '7';
            else if (ch == 'T' || ch == 'U' || ch == 'V') output += '8';
            else if (ch == 'W' || ch == 'X' || ch == 'Y' || ch == 'Z') output += '9';
            else output += ch;  
        }

        System.out.println("Converted number: " + output);
    }
}


