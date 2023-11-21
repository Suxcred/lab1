import java.util.*;

public class Main {

    public static void main(String[] args) {
        int ArrayAndList = 100000;
        int kInsert = 1000;

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        ListTest arrayListTest = new ListTest(arrayList, "ArrayList");
        ListTest linkedListTest = new ListTest(linkedList, "LinkedList");

        arrayListTest.fill(ArrayAndList);
        linkedListTest.fill(ArrayAndList);

        arrayListTest.Accessrandom();
        linkedListTest.Accessrandom();
        arrayListTest.Accesssequential();
        linkedListTest.Accesssequential();

        arrayListTest.InsertBeginning(kInsert);
        linkedListTest.InsertBeginning(kInsert);
        arrayListTest.InsertMiddle(kInsert);
        linkedListTest.InsertMiddle(kInsert);
        arrayListTest.InsertEnd(kInsert);
        linkedListTest.InsertEnd(kInsert);
    }
}

class ListTest {
    private List<Integer> list;
    private String listType;

    public ListTest(List<Integer> list, String listType) {
        this.list = list;
        this.listType = listType;
    }

    public void fill(int count) {
        long time = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            list.add(random.nextInt(count));
        }
        System.out.printf("Fill of %s: %d ms%n", listType, System.currentTimeMillis() - time);
    }

    public void Accessrandom() {
        int ArrayAndList = list.size();
        long time = System.currentTimeMillis();
        for (int i = 0; i < ArrayAndList; i++) {
            int element = list.get(i);
        }
        System.out.printf("Random access in %s: %d ms%n", listType, System.currentTimeMillis() - time);
    }

    public void Accesssequential() {
        long time = System.currentTimeMillis();
        for (Integer element : list) {
            int value = element;
        }
        System.out.printf("Sequential access in %s: %d ms%n", listType, System.currentTimeMillis() - time);
    }

    public void InsertBeginning(int count) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.add(0, i);
        }
        System.out.printf("Insert at the beginning of %s: %d ms%n", listType, System.currentTimeMillis() - time);
    }

    public void InsertMiddle(int count) {
        long time = System.currentTimeMillis();
        int ArrayAndList = list.size();
        for (int i = 0; i < count; i++) {
            list.add(ArrayAndList / 2, i);
        }
        System.out.printf("Insert in the middle of %s: %d ms%n", listType, System.currentTimeMillis() - time);
    }

    public void InsertEnd(int count) {
        long time = System.currentTimeMillis();
        int ArrayAndList = list.size();
        for (int i = 0; i < count; i++) {
            list.add(ArrayAndList + i, i);
        }
        System.out.printf("Insert at the end of %s: %d ms%n", listType, System.currentTimeMillis() - time);
    }
}