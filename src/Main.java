import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Object> mainList = new ArrayList<>();
        mainList.add(1);
        mainList.add(2);
        mainList.add(3);
        mainList.add(4);
        ArrayList<Object> newList1 = new ArrayList<>();
        newList1.add(5);
        newList1.add(6);
        newList1.add(7);
        newList1.add(8);
        ArrayList<Object> newList2 = new ArrayList<>();
        newList2.add(9);
        newList2.add(10);
        newList2.add(11);
        newList1.add(newList2);
        mainList.add(newList1);
        System.out.println("Original:\n" + mainList);
        System.out.println("All dimensions:");
        showAllDimensions(mainList);
        System.out.println("Custom dimensions:");
        showDimensions(mainList, 2);//dept is level of nesting when we start showing inner dimensions
        System.out.println("Flat:");
        showFlat(mainList);
    }

    public static void showAllDimensions(List<Object> input) {
        StringBuilder result = new StringBuilder();
        showAllDimensionsRecursion(input, result);
        System.out.println(result);
    }

    private static void showAllDimensionsRecursion(List<Object> input, StringBuilder result) {
        for (Object object : input) {
            if (object instanceof List) {
                showAllDimensionsRecursion((List) object, result);
                result.append("]");
            } else {
                result.append((input.indexOf(object) == 0) ? "[" : "");
                result.append(object);
                result.append((input.indexOf(object) != input.size() - 1) ? "," : "]");
            }
        }
    }

    //[1,2,3,4,5,6,7,8,9,10,11]
    public static void showFlat(List<Object> input) {
        StringBuilder result = new StringBuilder("[");
        showFlatRecursion(input, result);
        result.append("]");
        System.out.println(result);
    }

    private static void showFlatRecursion(List<Object> input, StringBuilder result) {
        for (Object object : input) {
            if (object instanceof List) {
                showFlatRecursion((List) object, result);
            } else {
                result.append(object);
                result.append((input.indexOf(object) != input.size() - 1) ? "," : "");
            }
        }
    }

    public static void showDimensions(List<Object> input, int dept) {
        StringBuilder result = new StringBuilder("[");
        showDimensionsRecursion(input, result, dept);
        System.out.println(result);
    }

    private static void showDimensionsRecursion(List<Object> input, StringBuilder result, int dept) {
        for (Object object : input) {
            if (object instanceof List) {
                showDimensionsRecursion((List) object, result, dept - 1);
                result.append((dept <= 1) ? "]" : "");
            } else {
                result.append((input.indexOf(object) == 0 && dept <= 0) ? "[" : "");
                result.append(object);
                result.append((input.indexOf(object) != input.size() - 1) ? "," : "]");
            }
        }
    }
}
