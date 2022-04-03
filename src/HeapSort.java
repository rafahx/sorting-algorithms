public class HeapSort extends Sort {

    // Algoritmo parte da familía de ordenação por seleção
    // Ótimo desempenho, tendo o seu tempo no pior cenário quase igual ao tempo do cenário médio
    // Não é um algortimo estável
    // Complexidade: Pior caso = O(n log n); Melhor caso = O(n log n)
    @Override
    public void sortList() {
        // Define o tamanho da lista que será usado posteriormente
        int size = list.length - 1;

        // Chama a função que vai fazer a primeira ordenação Heap para buscar o valor mais alto para a primeira posição
        buildMaxHeap(list, size);

        // Varre toda a lista aplicando a ordenação, de trás para frente
        for (int i = size; i > 0; i--) {
            // Inverte o maior número da lista com o último
            int aux  = list[0];
            list[0] = list[size];
            list[size] = aux;
            // Diminuí um do tamanho pois o maior valor já está na última posição da lista
            size -= 1;
            // Chama a função principal para buscar o maior valor novamente para a primeira posição
            // Continua fazendo isso até chegar no final da lista e ordenar todos os valores
            maxHeapify(list, size, 0);
        }
    }

    // Constrói a primeira estrutura Heap, trazendo o maior valor para cima da lista
    public static void buildMaxHeap(int[] list, int size){
        // Define o meio da lista
        int middle = (list.length / 2);

        // Percorre apenas metade da lista pois cada número vai ser tratado como o número pai de dois outros números
        // Com base no cálculo: primeiro filtro = 2 * i + 1; segundo filho = 2 * i + 2;
        // Logo não precisamos passar por toda a lista para ajustar todos os valores, pois os posteriores serão tratados
        // como filhos
        for (int i = middle -1; i >= 0; i--)
            maxHeapify(list, size, i);
    }

    // Função principal de toda o algoritmo
    // Recebe a lista, o tamanho dela, e o índice do pai atual
    public static void maxHeapify(int[] list, int size, int father){
        // Define o valor máximo como o pai
        int max = father;
        // Define o filho da esquerda do pai
        int leftChild = 2 * father + 1;
        // Define o filho da direita do pai
        int rightChild = 2 * father + 2;

        // Se o filho da esquerda for maior que o pai atual
        if (leftChild <= size && list[leftChild] > list[max])
            // O filho da esquerda assume como o maior
            max = leftChild;

        // Se o filho da direita for maior que o pai atual
        if (rightChild <= size && list[rightChild] > list[max])
            // O filho da direita assume como o maior
            max = rightChild;

        // Se houve mudança entre o pai inicial
        if (max != father) {
            // Inverte as posições para do pai inicial com o atual encontrado
            int aux  = list[father];
            list[father] = list[max];
            list[max] = aux;
            // Chama a função novamente, desta vez, definindo o pai como sendo o filho que foi alterado
            // Neste momento, o antigo pai virou filho, e este que vai ser repassado na próxima chamada
            maxHeapify(list, size, max);
        }
    }
}
