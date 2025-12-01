public class Exercicio2 {

    static int[][] qtde;
    static int[][] queb;

    public static void main(String[] args) {
        int [] p = {3, 1, 2, 3, 4, 2, 1, 5, 9, 8, 2, 4, 3, 6, 3, 8};
        //int [] p = {4, 5, 3, 2, 6, 1, 5, 6, 2, 7, 2, 1, 4, 3, 2, 8, 3,
        //	   6, 5, 2, 6, 2, 5, 2, 8, 3, 6, 4, 5, 3, 7, 4, 6, 3};
        int n = p.length-1;
        double inicio, fim, tempo;
        int m;

        qtde = new int[n+1][n+1];
        queb = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                qtde[i][j] = Integer.MAX_VALUE;
            }
        }

        inicio = System.currentTimeMillis();
        m = recursivo(p, 1, n);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        imprime(queb, 1, n);
        System.out.println();
        System.out.printf("%-15s%10s%10s\n", "Método", "Qtde", "Tempo");
        System.out.printf("%-15s%10d%10.2f\n\n", "Recursivo", m, tempo);

        inicio = System.currentTimeMillis();
        m = memoization(p, 1, n);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        imprime(queb, 1, n);
        System.out.println();
        System.out.printf("%-15s%10s%10s\n", "Método", "Qtde", "Tempo");
        System.out.printf("%-15s%10d%10.2f\n\n", "Memoization", m, tempo);

        inicio = System.currentTimeMillis();
        m = dinamico(p);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println();
        System.out.printf("%-15s%10s%10s\n", "Método", "Qtde", "Tempo");
        System.out.printf("%-15s%10d%10.2f\n", "Dinamico", m, tempo);
    }

    static int recursivo(int[] p, int i, int j) {
        if (i == j) {
            queb[i][j] = i;
            return 0;
        } else {
            int s = 0;
            int qMin = Integer.MAX_VALUE;
            for (int k = i; k < j; k++) {
                int q = recursivo(p, i, k) + recursivo(p, k+1, j) + p[i-1] * p[k] * p[j];
                if (q < qMin) {
                    qMin = q;
                    s = k;
                }
            }
            queb[i][j] = s;
            return qMin;
        }
    }

    static int memoization(int[] p, int i, int j) {

        if (qtde[i][j] < Integer.MAX_VALUE) {
            return qtde[i][j];
        }
        if (i == j) {
            qtde[i][j] = 0;
            return 0;
        }
        int qMin = Integer.MAX_VALUE;
        int s = 0;

        for (int k = i; k < j; k++) {
            int q = memoization(p, i, k) + memoization(p, k + 1, j) + p[i - 1] * p[k] * p[j];

            if (q < qMin) {
                qMin = q;
                s = k;
            }
        }
        qtde[i][j] = qMin;
        queb[i][j] = s;

        return qMin;
    }

    static int dinamico(int[] p) {
        int n = p.length - 1;
        int m[][] = new int[n + 1][n + 1];
        int s[][] = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
        imprime(s, 1, n);
        return m[1][n];
    }

    static void imprime(int[][] s, int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            // Imprime o lado ESQUERDO do corte (de i até s[i][j])
            imprime(s, i, s[i][j]);
            System.out.print(" x ");
            // Imprime o lado DIREITO do corte (de s[i][j]+1 até j)
            imprime(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }

}

