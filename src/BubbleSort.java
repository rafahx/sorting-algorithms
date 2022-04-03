public class BubbleSort extends Sort{

    // Bubble Sort, onde o número maior chega ao final da lista mais rapidamente
    // Complexidade: Pior caso = O(n²); Melhor caso = O(1)
    @Override
    public void sortList() {
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
    }
}
