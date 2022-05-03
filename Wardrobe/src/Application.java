import java.util.ArrayList;

public class Application {

    private static final int MAX_PRICE = 999999999;
    private static final int ROOM_SIZE = 250;

    private static final ArrayList<ArrayList<Element>> allCombinations = new ArrayList<>();
    private static final ArrayList<ArrayList<Element>> cheapestProducts = new ArrayList<>();

    public static void main(String[] args) {

        ArrayList<Element> elements = new ArrayList();

        Element a = new Element(50, 59);
        Element b = new Element(75, 62);
        Element c = new Element(100, 90);
        Element d = new Element(120, 111);

        elements.add(a);
        elements.add(b);
        elements.add(c);
        elements.add(d);

        determineCombinations(elements);

        printAllCombinations(allCombinations);
        printCheapestCombination(allCombinations);
    }

    private static void determineCombinations(final ArrayList<Element> elements) {
        recursiveCheck(elements, 0, new ArrayList<>());
    }

    private static void recursiveCheck(final ArrayList<Element> elements, final int value, final ArrayList<Element> currentElementCombination) {
        int copyValue = value;

        for (int i = 0; i < elements.size(); i++) {
            Element currentElement = elements.get(i);
            int result = copyValue + currentElement.getLength();
            currentElementCombination.add(currentElement);
            if (result < ROOM_SIZE) {
                recursiveCheck(elements, result, currentElementCombination);
            } else if (result == ROOM_SIZE) {
                allCombinations.add(new ArrayList<>(currentElementCombination));
            }
            currentElementCombination.remove(currentElementCombination.size() - 1);
        }
    }

    private static void printCheapestCombination(ArrayList<ArrayList<Element>> allCombinations) {
        int currentlyCheapestPrice = MAX_PRICE;
        for (ArrayList<Element> combination : allCombinations) {
            int priceOfCombination = getTotalPriceOfCombination(combination);
            if (priceOfCombination < currentlyCheapestPrice) {
                currentlyCheapestPrice = priceOfCombination;
                cheapestProducts.clear();
                cheapestProducts.add(combination);
            } else if (priceOfCombination == currentlyCheapestPrice) {
                cheapestProducts.add(combination);
            }
        }
        System.out.println("----Cheapest Combinations----");
        for (ArrayList<Element> elements : cheapestProducts) {
            printCombination(elements);
        }

    }

    private static int getTotalPriceOfCombination(ArrayList<Element> combination) {
        int totalPrice = 0;
        for(Element element : combination){
            totalPrice += element.getPrice();
        }
        return totalPrice;
    }


    private static void printAllCombinations(ArrayList<ArrayList<Element>> allCombinations) {
        for (ArrayList<Element> combination : allCombinations)
            printCombination(combination);
    }

    private static void printCombination(ArrayList<Element> combination) {
        int totalPrice = 0;
        for (Element element : combination) {
            System.out.print(element.getLength() + " | ");
            totalPrice += element.getPrice();
        }

        System.out.println("-> " + totalPrice + " USD");
    }
}
