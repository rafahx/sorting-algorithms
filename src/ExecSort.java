import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ExecSort {

    public static void main (String [] args) {
        int list[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        shuffleArray(list);
        printList("ShuffleArray: ", list);
        printList("BubbleSort: ", bubbleSort(list));

        shuffleArray(list);
        printList("ShuffleArray: ", list);
        printList("Insertion: ", insertionSort(list));

        shuffleArray(list);
        printList("ShuffleArray: ", list);
        printList("Selection: ", selectionSort(list));

    }

    // Bubble Sort, onde o número maior chega ao final da lista mais rapidamente
    // Complexidade: Pior caso = O(n²); Melhor caso = O(1)
    public static int[] bubbleSort(int list[]) {
        boolean changed = true;

        // Enquanto houve mudança
        while(changed){
            changed = false;
            // Percorre o índice pelo tamanho menos 1 (length considera o tamanho inteiro do array)
            for (int j = 0; j <= list.length - 2; j++){
                // Se o número do índice atual é maior que o próximo índice, inverte eles de posição
                if (list[j] > list[j + 1]){
                    int aux;
                    aux = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = aux;
                    changed = true;
                }
            }
        }

        return list;
    }

    // Ordena por inserção, assim como a organização de uma mão de cartas no baralho
    // Complexidade: Pior caso = O(n²); Melhor caso = O(n)
    public static int[] insertionSort(int list[]) {
        int i, key;

        // Percorre o array a partir da segunda posição
        for(int j = 1; j < list.length; j++) {
            // Considera o segundo valor como chave para comparação
            key = list[j];
            // Define o índice como o anterior do j
            i = j - 1;
            // Se o número do índice de i for maior que o número chave
            while(i > -1 && list[i] > key){
                // Empurra o número para o índice da frente
                list[i + 1] = list[i];
                // Decrementa para sempre encontrar o local correto da chave
                i--;
            }
            // Define o local correto do número chave
            list[i + 1] = key;
        }

        return list;
    }

    // Ordena sempre buscando o valor menor do vetor e puxando para o menos índice
    // Complexidade: Pior caso = O(n²); Melhor caso = O(n²)
    public static int[] selectionSort(int list[]) {

        for (int i = 0; i < list.length - 1; i++) {
            // Define o índice do menor valor
            int min = i;

            // Varre o resto de vetor a partir dos que já foram ordenados
            for (int j = (i + 1); j < list.length; j++)
                // Se encontrou um número menor, salva o índice
                if (list[min] > list[j])
                    min = j;

            // Se encontrou um número menor, inverte de posição
            if (list[min] != list[i]){
                int aux = list[i];
                list[i] = list[min];
                list[min] = aux;
            }
        }

        return list;
    }

    public static int[] shuffleArray(int list[]) {
        Random random = new Random();
        for(int i = list.length - 1; i > 0; i--){
            int j = random.nextInt(i + 1);
            int aux = list[i];
            list[i] = list[j];
            list[j] = aux;
        }
        return list;
    }

    public static void printList(String name, int list[]) {
        System.out.print("\n" + name + " \t");
        for (int i = 0; i <= list.length - 1; i++){ System.out.print(list[i] + " "); }
    }
}
