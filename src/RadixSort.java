import java.util.Arrays;

public class RadixSort extends Sort{

    @Override
    public void sortList() {
        radixSort(list.length);
    }

    // Ordenação que não utiliza comparação entre dois números para ordenar a lista
    // Complexidade: Pior caso = O(nk); Melhor caso = -; k = comprimento médio da chave
    static void radixSort(int size) {
        // Busca o maior número dentro da lista
        int maxNumber = getMaxNumber(size);

        // Utiliza o método CountSort para cada casa decimal do maior número da lista
        for (int exponentialDivider = 1; maxNumber / exponentialDivider > 0; exponentialDivider *= 10) {
            countSort(size, exponentialDivider);
        }
    }

    // Realiza o CountSort para a casa decimal representada pelo divisor exponencial
    static void countSort(int size, int exponentialDivider) {
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
    static int getMaxNumber(int size) {
        int maxNumber = list[0];
        for (int i = 1; i < size; i++)
            if (list[i] > maxNumber)
                maxNumber = list[i];
        return maxNumber;
    }
}
