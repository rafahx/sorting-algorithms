import java.util.Random;

public abstract class Sort {

    static int[] list = {  1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
                          15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
                          27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38};

    // Método sort da classe
    public abstract void sortList();
    public int[] getList() {
        return list;
    }

    // Embaralha os números dentro da lista
    public void shuffleList() {
        Random random = new Random();
        for(int i = list.length - 1; i > 0; i--){
            int j = random.nextInt(i + 1);
            int aux = list[i];
            list[i] = list[j];
            list[j] = aux;
        }
    }

    // Printa a lista
    public void printList(String name, int[] list) {
        System.out.print("\n" + name + " \t");
        for (int i = 0; i <= list.length - 1; i++){ System.out.print(list[i] + " "); }
    }
}
