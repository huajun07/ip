public class Chirp {
    private static final String name = "Chirp";

    public static void main(String[] args) {
        greet();
        exit();
    }

    private static void printLine() {
        System.out.println("-".repeat(60));
    }

    private static void greet() {
        printLine();
        System.out.println(" Hello! I'm " + name);
        System.out.println(" What can I do for you?");
        printLine();
        System.out.println();
    }

    private static void exit() {
        printLine();
        System.out.println(" Bye. Hope to see you again soon!");
        printLine();
        System.out.println();
    }

}
