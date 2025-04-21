import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HomeWork {

    public static List<Double> getRollingAverage(ArrayList<Integer> arr, int k) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Double> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            linkedList.add(arr.get(i));
        }
        addAverageToList(linkedList, res);
        for (int i = k; i < arr.size(); i++) {
            linkedList.add(arr.get(i));
            linkedList.remove();
            addAverageToList(linkedList, res);
        }
        return res;
    }

    public static void addAverageToList(List<Integer> arr, List<Double> res) {
        int sum = 0;
        for (Integer integer : arr) {
            sum += integer;
        }
        res.add((double) sum / arr.size());
    }

    public static void main(String[] args) {
        System.out.println(getRollingAverage(new ArrayList<>(Arrays.asList(1, 2, 3, 5)), 2));
    }

}

