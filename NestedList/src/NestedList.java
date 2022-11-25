import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NestedList {
    public static void main(String[] args) {
        Nested parent = new Nested();
        parent.setName("parent");
        List<Nested> nestedList1 = new ArrayList<>();
        for (int i = 97; i <= 102; i++) {
            Nested nested1 = new Nested();
            nested1.setName("" + (char) i);
            nestedList1.add(nested1);
        }

        List<Nested> nestedList2 = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            Nested nested1 = new Nested();
            nested1.setName("Adem" + i);
            nestedList2.add(nested1);
        }


        nestedList2.get(0).setNestedList(Collections.singletonList(nestedList2.get(1)));
        nestedList2.get(0).getNestedList().get(0).setNestedList(Arrays.asList(nestedList2.get(2), nestedList2.get(3)));
        parent.setNestedList(Arrays.asList(nestedList1.get(0), nestedList2.get(0)));
        parent.getNestedList().get(0).setNestedList(Collections.singletonList(nestedList1.get(1)));
        parent.getNestedList().get(0).getNestedList().get(0).setNestedList(Collections.singletonList(nestedList1.get(2)));
        parent.getNestedList().get(0).getNestedList().get(0).getNestedList().get(0).setNestedList(Collections.singletonList(nestedList1.get(3)));
        parent.getNestedList().get(0).getNestedList().get(0).getNestedList().get(0).getNestedList().get(0).setNestedList(Arrays.asList(nestedList1.get(4), nestedList1.get(5)));

        recursive(parent, 0);
    }

    static void printItem(Nested item, int maxLevelOfChildren) {
        for (int i = 0; i < maxLevelOfChildren; i++) System.out.print(" ");
        System.out.println(maxLevelOfChildren + " " + item.getName());
    }

    static void recursive(Nested parent, int maxLevelOfChildren) {
        printItem(parent, maxLevelOfChildren);
        if (parent.getNestedList() != null) {
            for (Nested nested : parent.getNestedList()) {
                if (maxLevelOfChildren < 10)
                    recursive(nested, maxLevelOfChildren + 1);
            }
        }
    }

    static void printItem(List<Nested> item, int maxLevelOfChildren) {
        for (Nested nested : item) {
            for (int i = 0; i < maxLevelOfChildren; i++) System.out.print(" ");
            System.out.println(maxLevelOfChildren + " " + nested);
        }
    }

    static void recursive(List<Nested> parent, int maxLevelOfChildren) {
        if (parent != null) {
            printItem(parent, maxLevelOfChildren);
            for (Nested nested : parent) {
                if (maxLevelOfChildren < 5)
                    recursive(nested.getNestedList(), maxLevelOfChildren + 1);
            }
        }
    }
}
