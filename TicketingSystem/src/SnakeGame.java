import java.util.*;

public class SnakeGame {
    static int width = 20, height = 10;
    static int snakeX = width / 2, snakeY = height / 2;
    static LinkedList<int[]> snake = new LinkedList<>();
    static int foodX, foodY;
    static char dir = 'R';
    static boolean gameOver = false;
    static Random rand = new Random();

    public static void main(String[] args) throws Exception {
        snake.add(new int[]{snakeX, snakeY});
        placeFood();
        Scanner sc = new Scanner(System.in);

        while (!gameOver) {
            printBoard();
            System.out.print("Move (WASD): ");
            char input = sc.next().toUpperCase().charAt(0);
            if ("WASD".indexOf(input) != -1) dir = input;
            move();
        }
        System.out.println("Game Over!");
    }

    static void placeFood() {
        foodX = rand.nextInt(width);
        foodY = rand.nextInt(height);
    }

    static void move() {
        int[] head = snake.getFirst();
        int x = head[0], y = head[1];
        switch (dir) {
            case 'W': y--; break;
            case 'S': y++; break;
            case 'A': x--; break;
            case 'D': x++; break;
        }
        if (x < 0 || x >= width || y < 0 || y >= height) {
            gameOver = true; return;
        }
        int[] newHead = new int[]{x, y};
        snake.addFirst(newHead);
        if (x == foodX && y == foodY) placeFood();
        else snake.removeLast();
    }

    static void printBoard() {
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                if (i == foodX && j == foodY) System.out.print("F");
                else if (isSnake(i, j)) System.out.print("O");
                else System.out.print(".");
            }
            System.out.println();
        }
    }

    static boolean isSnake(int x, int y) {
        for (int[] s : snake) if (s[0] == x && s[1] == y) return true;
        return false;
    }
}