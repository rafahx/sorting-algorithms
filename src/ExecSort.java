public class ExecSort {

    public static void main (String [] args) {
        printSort(new BubbleSort(), "BubbleSort:   ");
        printSort(new InsertionSort(), "InsertionSort:");
        printSort(new SelectionSort(), "SelectionSort:");
        printSort(new QuickSort(), "QuickSort:   ");
        printSort(new RadixSort(), "RadixSort:   ");
        printSort(new HeapSort(), "HeapSort:   ");
    }

    public static void printSort(Sort sort, String sortName){
        sort.shuffleList();
        sort.printList("ShuffledList: ", sort.getList());
        sort.sortList();
        sort.printList(sortName, sort.getList());
    }
}
