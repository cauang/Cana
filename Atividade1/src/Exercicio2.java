import java.util.concurrent.TimeUnit;
public class Exercicio2 {
    public static void main(String[] args) {
        System.out.printf("metodo1\n");
        System.out.printf("%10s%20s%10s\n","n", "solucao", "tempo");
        for (int n = 0; n <= 10; n+=1) {
            metodo1(n);
        }
        System.out.printf("metodo2\n");
        System.out.printf("%10s%20s%10s\n","n", "solucao", "tempo");
        for (int n = 0; n <= 10; n+=1) {
            metodo2(n);
        }
        System.out.printf("metodo3\n");
        System.out.printf("%10s%20s%10s\n","n", "solucao", "tempo");
        for (int n = 0; n <= 10; n+=1) {
            metodo3(n);
        }
        System.out.printf("metodo4\n");
        System.out.printf("%10s%20s%10s\n","n", "solucao", "tempo");
        for (int n = 0; n <= 10; n+=1) {
            metodo4(n);
        }
        System.out.printf("metodo5\n");
        System.out.printf("%10s%20s%10s\n","n", "solucao", "tempo");
        for (int n = 0; n <= 10; n+=1) {
            metodo5(n);
        }

    }

    static void metodo1 (long n) {                      // TEMPO -  VEZES C
        double inicio = System.currentTimeMillis();
        long valor = 0;                                 // c1         1
        long termo = n * n * n * n;                     // c2         1
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (long i = 1; i <= 4; i++) {                 // c3   4 + 1
            valor += termo;                             // C4   4
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        double fim = System.currentTimeMillis();        // C5   1
        double tempo = fim - inicio;                    // C6   1
        System.out.printf("%10d%20d%10.0f\n", n, valor, tempo); //C7    1
    }
    // t(N) = C1 1 + C2 1 + C3 (n+1) + C4 N + C5 1 + C6 1 = O(1) ---- CONSTANTE

    static void metodo2 (long n) {
        double inicio = System.currentTimeMillis();     // c1           1
        long valor = 0;                                 // c2           1
        long termo = 4 * n * n * n;                     // c3           1
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (long i = 1; i <= n; i++) {                // c4           N
            valor += termo;                             // c5           N - 1
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        double fim = System.currentTimeMillis();    //c6    1
        double tempo = fim - inicio;                // c7   1
        System.out.printf("%10d%20d%10.0f\n", n, valor, tempo);// c8    1
    }
    //T(n) = C1+C2+C3+ N.C4 + N.C5 + C6 + C7 +C8 = 0(N) --- LINEAR

    static void metodo3 (long n) {
        double inicio = System.currentTimeMillis();
        long valor = 0;
        long termo = n * n * n;
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (long i = 1; i <= 4; i++) {
            for (long j = 1; j <= n; j++) {
                valor += termo;
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        double fim = System.currentTimeMillis();
        double tempo = fim - inicio;
        System.out.printf("%10d%20d%10.0f\n", n, valor, tempo);
    }

    static void metodo4 (long n) {
        double inicio = System.currentTimeMillis();
        long valor = 0;
        long termo = n * n;
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (long i = 1; i <= 2 * n; i++) {
            for (long j = 1; j <= 2 * n; j++) {
                valor += termo;
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        double fim = System.currentTimeMillis();
        double tempo = fim - inicio;
        System.out.printf("%10d%20d%10.0f\n", n, valor, tempo);
    }

    static void metodo5 (long n) {
        double inicio = System.currentTimeMillis();
        long valor = 0;
        long termo = 4 * n;
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (long i = 1; i <= n; i++) {
            for (long j = 1; j <= n; j++) {
                for (long k = 1; k <= n; k++) {
                    valor += termo;
                    try {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        double fim = System.currentTimeMillis();
        double tempo = fim - inicio;
        System.out.printf("%10d%20d%10.0f\n", n, valor, tempo);
    }

}
