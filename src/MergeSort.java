public class MergeSort extends Sort{

    @Override
    public void sortList() {
        mergeSort(list, list.length);
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
}
