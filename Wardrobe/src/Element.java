public class Element {

    private final int length;
    private final int price;

    public Element(final int length, final int price){
        this.length = length;
        this.price = price;
    }

    public int getLength() {
        return length;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Element{" +
                "length=" + length +
                '}';
    }
}
