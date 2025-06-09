public class Pyramid {
    public static void main(String[] args) {
        int rows = 5; // You can change this value to increase/decrease pyramid height

        for (int i = 1; i <= rows; i++) {
            // Print spaces
            for (int j = i; j < rows; j++) {
                System.out.print(" ");
            }

            // Print stars
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }

            // Move to next line
            System.out.println();
        }
    }
}

