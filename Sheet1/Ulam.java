public class Ulam {
    public static boolean isUlam(int n) {
        int c = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n*3 + 1;
            }
            c++;

            if (c > 475) return false;
        }
        return true;
    }

    public static void main(String args[]) {
        int isEvidence = 0;
        for(int i=2; i<1000000; i++) {
            if (!isUlam(i)) {
                isEvidence = i;
                break;
            }
        }

        if (isEvidence != 0) {
            System.out.printf("With %d, the Ulam function does not work!\n", isEvidence);
        } else {
            System.out.println("The Ulam function work in the range from [1, 1000000]");
        }
    }
}