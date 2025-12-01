public class Exercicio1 {

    static int[] qtde;

    public static void main(String[] args) {
        int troco = 33;
        int[] padrao = {1, 7, 17, 25};
        double inicio, fim, tempo;
        int q;

        inicio = System.currentTimeMillis();
        q = trocoDinamico(troco, padrao);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        if (q == Integer.MAX_VALUE) {q = -1;}
        System.out.printf("%-15s%10s%10s\n", "Método", "Qtde", "Tempo");
        System.out.printf("%-15s%10d%10.2f\n\n", "Dinâmico", q, tempo);

        inicio = System.currentTimeMillis();
        qtde = new int[troco+1];
        for (int t = 0; t <= troco; t++) {
            qtde[t] = -1;
        }
        q = trocoMemoization(troco, padrao);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        if (q == Integer.MAX_VALUE) {q = -1;}
        System.out.printf("%-15s%10s%10s\n", "Método", "Qtde", "Tempo");
        System.out.printf("%-15s%10d%10.2f\n\n", "Memoization", q, tempo);

        inicio = System.currentTimeMillis();
        q = trocoRecursivo(troco, padrao);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        if (q == Integer.MAX_VALUE) {q = -1;}
        System.out.printf("%-15s%10s%10s\n", "Método", "Qtde", "Tempo");
        System.out.printf("%-15s%10d%10.2f\n\n", "Recursivo", q, tempo);
    }

    static int trocoRecursivo(int troco, int[] padrao) {
        if (troco != 0) {
            int qMin = Integer.MAX_VALUE;
            for (int i = 0; i < padrao.length; i++) {
                if (troco - padrao[i] >= 0) {
                    int q = trocoRecursivo(troco - padrao[i], padrao) + 1;
                    if (q < 0) {
                        q = Integer.MAX_VALUE;
                    }
                    if (q < qMin) {
                        qMin = q;
                    }
                }
            }
            return qMin;
        }
        return 0;
    }


    static int trocoMemoization(int troco, int[] padrao) {
        if (qtde[troco] != -1) {
            return qtde[troco];
        }

        if (troco != 0) {
            int qMin = Integer.MAX_VALUE;

            for (int i = 0; i < padrao.length; i++) {
                if (troco - padrao[i] >= 0) {

                    int res = trocoMemoization(troco - padrao[i], padrao);

                    if (res != Integer.MAX_VALUE) {
                        int q = res + 1;
                        if (q < qMin) {
                            qMin = q;
                        }
                    }
                }
            }

            qtde[troco] = qMin;
            return qMin;
        }
        qtde[0] = 0;
        return 0;
    }

    static int trocoDinamico(int troco, int[] padrao) {
        int[] q = new int[troco + 1];
        int[] c = new int[troco + 1];

        q[0] = 0;
        c[0] = 0;

        for (int t = 1; t <= troco; t++) {
            q[t] = Integer.MAX_VALUE;
        }
        for (int t = 1; t <= troco; t++) {
            for (int i = 0; i < padrao.length; i++) {
                int moeda = padrao[i];
                if (t - moeda >= 0 && q[t - moeda] != Integer.MAX_VALUE) {

                    int tentativa = 1 + q[t - moeda];

                    if (tentativa < q[t]) {
                        q[t] = tentativa;
                        c[t] = moeda;
                    }
                }
            }
        }
        if (q[troco] != Integer.MAX_VALUE) {
            imprimeTroco(c, troco);
        }
        System.out.println();

        return q[troco];
    }

    static void imprimeTroco(int[] c, int troco) {
        System.out.print("Moedas utilizadas: ");    // c1      1

        while (troco > 0) {                         // c2      t + 1
            //         (t execuções verdadeiras + 1 falha na saída)

            int moeda = c[troco];                   // c3      t
            System.out.print(moeda + " ");          // c4      t
            troco = troco - moeda;                  // c5      t
        }

        System.out.println();                       // c6      1
    }
    // T(t) = O(t) ---- LINEAR

}
