public class QuickSort extends Sort{

    @Override
    public void sortList() {
        quickSort(list, 0, list.length -1);
    }

    // Também utiliza o método de divisão e consquista, define a ordenação da lista de acordo com o pivô escolhido
    // Instável com números duplicados
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
}
