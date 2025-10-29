import java.util.Random;
public class Exercicio1 {
    public static void main(String[] args) {
        int[] B = Exercicio1.criaVetorAleatorio(15);

        System.out.println("Vetor B (original):");
        Exercicio1.imprimeVetor(B);
        System.out.println("Heap B (original):");
        Exercicio1.imprimeHeap(B);

        Exercicio1.buildmaxheap(B);

        System.out.println("Vetor B após buildmaxheap:");
        Exercicio1.imprimeVetor(B);
        System.out.println("Heap B após buildmaxheap:");
        Exercicio1.imprimeHeap(B);
    }

    static int left (int i) {
        return 2*i + 1;
    }

    static int right (int i) {
        return 2*i + 2;
    }

    static void swap(int[] V, int i, int j){
        int tmp = V[i];
        V[i] = V[j];
        V[j] = tmp;
    }

    static void maxheapfy (int[] V, int i) {
        int l = left(i);
        int r = right(i);
        int m = i;
        int n = V.length;

        if (l < n && V[l] > V[m]) {
            m = l;
        }
        if (r < n && V[r] > V[m]) {
            m = r;
        }
        if (m != i) {
            swap(V, i, m);
            maxheapfy(V, m);
        }
    }

    static void buildmaxheap (int[] V) {
        int n = V.length;
        for (int i = n/2-1; i >=0 ; i--) {
            maxheapfy(V, i);
        }
    }

    static int[] criaVetorAleatorio (int n) {
        Random randomGenerator = new Random();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = randomGenerator.nextInt(10 * n);
        }
        return A;
    }

    static void imprimeVetor (int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.printf("%6d", A[i]);
        }
        System.out.print("\n\n\n");
    }

    static void imprimeHeap (int[] A) {
        int h = (int) (Math.log(A.length) / Math.log(2));
        int espacos = calculaEspacos(h);
        for (int i = 0; i <= h; i++) {
            for (int j = 1; j <= Math.pow(2, i); j++) {
                if ((int) (Math.pow(2, i)) - 1 + (j-1) >= A.length) break;
                imprimeEspacos(espacos);
                System.out.printf("%3d", A[(int) (Math.pow(2, i)) - 1 + (j-1)]);
                imprimeEspacos(espacos);
                if (j < Math.pow(2, i)) {
                    System.out.printf("%3s", "");
                }
            }
            espacos = (espacos - 3) / 2;
            System.out.println();
        }
        System.out.print("\n\n\n");
    }

    static int calculaEspacos (int h) {
        int espacos = 3;
        for (int i = 1; i <= h; i++) {
            espacos = 2 * espacos + 3;
        }
        return espacos;
    }

    static void imprimeEspacos (int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(" ");
        }
    }

}
