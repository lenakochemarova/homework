import java.util.*;

public class CollectionsHomework {

    public static HashMap<String, Integer> reverseHashMap(HashMap<Integer, String> hashMap) {
        HashMap<String, Integer> result = new HashMap<>();
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }

    public static void arrayListAndLinkedList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
        long start, time;
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.get(new Random().nextInt(1000000));
        }
        time = System.nanoTime() - start;
        System.out.println("ArrayList: " + time / 1000000 + " sec");
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.get(new Random().nextInt(1000000));
        }
        time = System.nanoTime() - start;
        System.out.println("LinkedList: " + time / 1000000 + " sec");
    }

    public static ArrayList<String> removeDuplicates(ArrayList<String> arrayList) {
        HashSet<String> hashSet = new HashSet<>(arrayList);
        return arrayList = new ArrayList<>(hashSet);
    }

    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "A");
        hashMap.put(2, "B");
        hashMap.put(3, "C");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList("A", "B", "A", "C", "C"));

        System.out.println(hashMap);
        System.out.println(reverseHashMap(hashMap));
        System.out.println();
        arrayListAndLinkedList();
        System.out.println();
        System.out.println(arrayList);
        System.out.println(removeDuplicates(arrayList));
    }
}
