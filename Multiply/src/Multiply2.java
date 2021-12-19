/*
Multiply two integers without using multiplication, division and bitwise operators, and no loops
*/
public class Multiply2 {
    public static void main(String[] args) {
        int x = 0, y = 0;
        System.out.println(multiplication(x, y));
    }

    public static int multiplication(int x, int y) {
        if (x == 0 || y == 0) {
            return 0;
        }
        if (x < 0) {
            return -y + multiplication(x + 1, y);
        }
        return y + multiplication(x - 1, y);
    }
}
