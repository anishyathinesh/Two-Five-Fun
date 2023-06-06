import java.util.*;
public class Main {
    private static Scanner in;

    public static void printMenu() {
        System.out.println();
        System.out.println(
                " +-+-+-+-+\n" +
                " |M|E|N|U|\n" +
                " +-+-+-+-+");
        System.out.println("the menu format is:");
        System.out.println("> # - tool");
        System.out.println("_______");
        System.out.println("Unit 1 |");
        System.out.println("_______");
        System.out.println("> 1.1 - measures of location (mean/median/mode)");

        System.out.println();
        System.out.println("type tool # and press [ENTER]: ");
    }
    public static ArrayList<Double> parseData(String strData) {
        ArrayList<Double> intData = new ArrayList<>();
        try {
            String[] data = strData.split("\\s");
            for (String dig : data) {
                intData.add(Double.parseDouble(dig));

            }
        } catch (NumberFormatException nfe) {
            System.err.println("your data must only contain numbers.");
        }
        return intData;
    }
    public static int partition(ArrayList<Double> data, int low, int high) {
        Double pivot = data.get(high);
        int i = low - 1;

        for (int j = low; j <= high -1; j++) {
            if (data.get(j) < pivot) {
                i++;
                Double t = data.get(i);
                data.set(i, data.get(j));
                data.set(j, t);
            }
        }
        Double t = data.get(i+1);
        data.set(i+1, data.get(high));
        data.set(high, t);
        return (i+1);
    }
    public static void quickSort(ArrayList<Double> data, int low, int high) {
        if (low < high) {
            int pi = partition(data, low, high);

            quickSort(data, low, pi - 1);
            quickSort(data, pi + 1, high);
        }
    }
    public static void goMOL(String measure, ArrayList<Double> data) {
        switch (measure) {
            case "mean":
                int sum = 0;
                for (Double i : data) {
                    sum += i;
                }
                System.out.println( "MEAN RESULT: " + sum / (double) data.size());
            case "median":
                quickSort(data, 0, data.size()-1);
                Double ans = 0.0;
                if (data.size() % 2 == 0) {
                    Double r = data.get(data.size() / 2);
                    Double l = data.get((data.size() / 2) - 1);
                    ans = (r + l) / 2;
                } else {
                    ans = data.get(data.size() / 2);
                }
                System.out.println( "MEDIAN RESULT: " + ans);

            case "mode":
                HashMap<Double, Integer> map = new HashMap<>();
                for (Double dig : data) {
                    if (map.containsKey(dig)) {
                        map.put(dig, map.get(dig)+1);
                    } else {
                        map.put(dig, 1);
                    }
                }
                ArrayList<Double> modes = new ArrayList<>();
                int highest = 0;
                for (Double key : map.keySet()) {
                    //TODO

                }
        }
    }
    public static void main(String[] args) {
        System.out.println("welcome to...");
        System.out.println("" +
                "" +
                "\n" +
                "  _______       ______        ___________    ________      ________  ___   __   \n" +
                " /_  __/ |     / / __ \\      / ____/  _/ |  / / ____/     / ____/ / / / | / /   \n" +
                "  / /  | | /| / / / / /     / /_   / / | | / / __/       / /_  / / / /  |/ /    \n" +
                " / /   | |/ |/ / /_/ /     / __/ _/ /  | |/ / /___      / __/ / /_/ / /|  /     \n" +
                "/_/    |__/|__/\\____/     /_/   /___/  |___/_____/     /_/    \\____/_/ |_/      \n");

        while (true) {

        Scanner in = new Scanner(System.in);

        printMenu();

        String userToolNum = in.nextLine();


            switch (userToolNum) {
                case "1.1":
                    System.out.println("type \"mean\", \"median\", or \"mode\" and press [ENTER]: ");
                    String userMOL = in.nextLine();
                    System.out.println("enter numbers seperated by a space: ");
                    ArrayList<Double> userData = parseData(in.nextLine());

                    goMOL(userMOL, userData);

                default:
                    System.err.println("tool # not recognized.");
            }


            System.out.println("press [ENTER] to try another tool, or type anything else to finish.");
            if (!in.nextLine().equals("")) {
                break;
            }

        }
    }
}