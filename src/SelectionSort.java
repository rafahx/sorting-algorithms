public class SelectionSort extends Sort{

    // Ordena sempre buscando o valor menor do vetor e puxando para o menos índice
    // Complexidade: Pior caso = O(n²); Melhor caso = O(n²)
    @Override
    public void sortList() {

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
    }
}
