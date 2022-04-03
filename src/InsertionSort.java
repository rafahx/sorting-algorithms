public class InsertionSort extends Sort{

    // Ordena por inserção, assim como a organização de uma mão de cartas no baralho
    // Complexidade: Pior caso = O(n²); Melhor caso = O(n)
    @Override
    public void sortList() {
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
    }
}
