import java.lang.reflect.Array;
import java.util.ArrayList;

public class Application {

    private static final int max = 250;
    private static ArrayList<ArrayList<Element>> possibleCombinations = new ArrayList<>();

    public static void main(String[] args) {

        ArrayList<Element> elements = new ArrayList();


        Element a = new Element(50);
        Element b = new Element(75);
        Element c = new Element(100);
        Element d = new Element(120);

        elements.add(a);
        elements.add(b);
        elements.add(c);
        elements.add(d);

        determineCombinations(elements);
    }

    private static void determineCombinations(ArrayList<Element> elements) {
        int value = 0;
        recursiveCheck(elements, value, new ArrayList<Element>());
    }

    private static void recursiveCheck(ArrayList<Element> elements, int value, ArrayList<Element> currentElementCombination) {
        int copyValue = value;

        for (int i = 0; i < elements.size(); i++) {
            Element currentElement = elements.get(i);
            int result = copyValue + currentElement.getLength();
            currentElementCombination.add(currentElement);
            if (result < max) {
                recursiveCheck(elements, result, currentElementCombination);
            } else if (result == max) {
                possibleCombinations.add(currentElementCombination);

                for(Element element: currentElementCombination){
                    System.out.print(element.getLength() + " | ");
                }
                System.out.println();
            }
            currentElementCombination.remove(currentElementCombination.size()-1);
        }
    }
}
