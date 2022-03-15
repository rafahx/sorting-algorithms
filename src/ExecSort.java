import java.util.Random;
import java.util.*;

public class ExecSort {

    public static void main (String [] args) {
        int[] list = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};

        shuffleList(list);
        printList("ShuffledList: ", list);
        printList("BubbleSort: ", bubbleSort(list));

        shuffleList(list);
        printList("ShuffledList: ", list);
        printList("Insertion: ", insertionSort(list));

        shuffleList(list);
        printList("ShuffledList: ", list);
        printList("Selection: ", selectionSort(list));

        shuffleList(list);
        printList("ShuffledList: ", list);
        mergeSort(list, list.length);
        printList("MergeSort: ", list);

        shuffleList(list);
        printList("ShuffledList: ", list);
        quickSort(list, 0, list.length - 1);
        printList("QuickSort: ", list);

        shuffleList(list);
        printList("ShuffledList: ", list);
        radixSort(list, list.length);
        printList("RadixSort: ", list);

    }

    // Bubble Sort, onde o número maior chega ao final da lista mais rapidamente
    // Complexidade: Pior caso = O(n²); Melhor caso = O(1)
    public static int[] bubbleSort(int[] list) {
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
    public static int[] insertionSort(int[] list) {
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
    public static int[] selectionSort(int[] list) {

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

    // Ordena a lista pelo método de divisão e conquista
    // Complexidade: Pior caso = O(n log n); Melhor caso = O(n log n) típico, O(n) variante natural
    public static void mergeSort(int[] list, int size){
        if (size < 2)
            return;

        // Define o meio e os vetores auxiliares
        int mid = size / 2;
        int [] leftList = new int[mid];
        int [] rightList = new int[size-mid];

        // Carrega a lista da esquerda
        for(int i = 0; i < mid; i++)
            leftList[i] = list[i];
        // Carrega a lista de direita
        for(int i = 0; i < size - mid; i++)
            rightList[i] = list[mid + i];

        // Faz chamada recursiva da função para dividir todos os vetores até que sobre apenas um número no vetor
        mergeSort(leftList, mid);
        mergeSort(rightList, size-mid);
        // Chamada que une os dois vetores
        merge(leftList, rightList, list, mid,size-mid);
    }

    // Faz a junção dos dois vetores ordenando eles dentro do vetor original
    public static void merge(int[] leftList, int[] rightList, int[] list, int leftSize, int rightSize){
        int i = 0, left = 0, right = 0;

        //Percorre enquanto não tiver passado por pelo menos o número total de índice de um dos vetores
        while(left < leftSize && right < rightSize)
            // Verifica qual número é menor para carregar na lista original
            if(leftList[left] < rightList[right])
                list[i++] = leftList[left++];
            else
                list[i++] = rightList[right++];

        // Carrega os números que sobraram da lista de esquerda no vetor original
        while(left < leftSize)
            list[i++] = leftList[left++];
        // Carrega os números que sobraram da lista de direita no vetor original
        while(right < rightSize)
            list[i++] = rightList[right++];

    }

    // Também utiliza o método de divisão e consquista, define a ordenação da lista de acordo com o pivô escolhido
    // Não permite números duplicados
    // Complexidade: Pior caso = O(n²); Melhor caso = O(n log n)
    public static void quickSort(int[] list, int initial, int last) {
        if (initial < last){
            // Define o índice do pivô e faz a chamada recursiva da função para separar a lista em vetores menores
            int pivot = separate(list, initial, last);
            quickSort(list, initial, pivot - 1);
            quickSort(list, pivot + 1, last);
        }
    }

    // Vai separar os números para esquerda ou direita dependendo se ele for menor ou maior que o pivô definido
    public static int separate(int[] list, int initial, int last) {
        // Define o pivô como sendo o primeiro número do vetor
        int pivot = list[initial];
        int i = initial + 1, l = last;

        // Percorre a lista testando tanto o começo quando o fim da mesma com o pivô para saber a posição que os números
        // devem ser colocados
        while (i <= l) {
            // Se o número da esquerda já é menor que o pivô
            if (list[i] <= pivot){
                i++;
            // Se o número da direita já é maior que o pivô
            } else if (pivot < list [l]) {
                l--;
            } else {
            // Inverte a posição do primeiro e último número
                int aux = list[i];
                list[i] = list[l];
                list[l] = aux;
                i++;
                l--;
            }
        }
        // Primeiro índice vai receber o menor número que está na posição do pivô
        list[initial] = list[l];
        // Pivô é carregado para o índice correto
        list[l] = pivot;
        return l;
    }

    // Ordenação que não utiliza comparação entre dois números para ordenar a lista
    // Complexidade: Pior caso = O(nk); Melhor caso = -; k = comprimento médio da chave
    static void radixSort(int[] list, int size) {
        // Busca o maior número dentro da lista
        int maxNumber = getMaxNumber(list, size);

        // Utiliza o método CountSort para cada casa decimal do maior número da lista
        for (int exponentialDivider = 1; maxNumber / exponentialDivider > 0; exponentialDivider *= 10) {
            countSort(list, size, exponentialDivider);
        }
    }

    // Realiza o CountSort para a casa decimal representada pelo divisor exponencial
    static void countSort(int[] list, int size, int exponentialDivider) {
        int[] listOutput = new int[size];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Cada índice do contador vai representar a quantidade de números equivalente
        // Ex:
        //      List:  { 3, 6, 6, 5, 2}
        //      Count: { 0, 0, 1, 1, 0, 1, 2, 0, 0, 0}
        for (int i = 0; i < size; i++)
            count[(list[i] / exponentialDivider) % 10]++;

        // Atualiza os contadores para saber quais números devem ir para cada índice
        // Ex:
        //      Count: { 0, 0, 1, 2, 2, 3, 5, 5, 5, 5}
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Monta a lista final
        for (int i = size - 1; i >= 0; i--) {
            // Para cada elemento da lista, verifica o número de acordo com o divisor exponencial, localiza ele dentro
            // do array de contadores pelo índice, joga para o índice do novo array no índice - 1
            listOutput[count[(list[i] / exponentialDivider) % 10] - 1] = list[i];
            // Decrementa a quantidade de contadores daquele índice
            count[(list[i] / exponentialDivider) % 10]--;
        }

        // Copia a lista output para a lista original
        System.arraycopy(listOutput, 0, list, 0, size);
    }

    // Função adicional que busca o maior número dentro da lista
    static int getMaxNumber(int[] list, int size) {
        int maxNumber = list[0];
        for (int i = 1; i < size; i++)
            if (list[i] > maxNumber)
                maxNumber = list[i];
        return maxNumber;
    }

    // Embaralha os números dentro da lista
    public static void shuffleList(int[] list) {
        Random random = new Random();
        for(int i = list.length - 1; i > 0; i--){
            int j = random.nextInt(i + 1);
            int aux = list[i];
            list[i] = list[j];
            list[j] = aux;
        }
    }

    // Printa a lista
    public static void printList(String name, int[] list) {
        System.out.print("\n" + name + " \t");
        for (int i = 0; i <= list.length - 1; i++){ System.out.print(list[i] + " "); }
    }
}
