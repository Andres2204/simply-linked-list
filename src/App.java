import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner read = new Scanner(System.in);
        SimpleList list = new SimpleList();
        boolean sortAsc = true;
        String msg = "";

        while (true) {
            switch (menu(sortAsc, list, msg)) {
                case 1: // append to start
                    System.out.println("Insert a number: ");
                    msg = list.appendToStart(read.nextInt());
                    break;

                case 2: // appendt to end
                    System.out.println("Insert a number: ");
                    msg = list.appendToEnd(read.nextInt());
                    break;

                case 3: // sort
                    msg = list.sortByLigament(sortAsc);
                    break;

                case 4: // change sort direction
                    sortAsc = sortAsc ? false : true;
                    break;

                case 5: // exit
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;

            }
        }
    }

    public static int menu(boolean sortAsc, SimpleList list, String msg) {
        Scanner read = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print(
                """
                        ╔═══════════════════════════════╗
                        ║ Order Simple list By Ligament ║
                        ╚═══════════════════════════════╝

                        1. Append To Start.
                        2. Append To End,
                        3. ░ Sort. ░
                        4. Change Sort Direction.
                        5. exit

                        """ +
                        "Sort Direction: " + (sortAsc ? "Ascendant \n" : "decreasing \n") +
                        "Actual list: " + list.showList() +
                        "\n" + msg + (msg != "" ? "\n" : "") +
                        "\nSelect an option:\s");
        return read.nextInt();

    }
}
