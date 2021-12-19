/*
Multiply two integers without using multiplication, division and bitwise operators, and no loops
*/
public class Multiply {
    public static void main(String[] args) {
        int x = -51, y = -13;
        System.out.println(multiplication(x, y));
    }

    public static int multiplication(int x, int y) {
        if (x == 0 || y == 0) {
            return 0;
        }

        if (x < 0 && y < 0) {
            return x < y ? -x + multiplication(x, y + 1) : -y + multiplication(x + 1, y);
        }

        if (x < 0) {
            return -x > y ? x + multiplication(x, y - 1) : -y + multiplication(x + 1, y);
        }

        if (y < 0) {
            return -y > x ? y + multiplication(x - 1, y) : -x + multiplication(x, y + 1);
        }

        return x < y ? y + multiplication(x - 1, y) : x + multiplication(x, y - 1);
    }
}
