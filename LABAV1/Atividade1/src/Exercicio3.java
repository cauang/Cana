import java.util.concurrent.TimeUnit;

public class Exercicio3 {
    public static void main(String[] args) {
        double inicio1, fim1, tempo1;
        double inicio2, fim2, tempo2;
        double inicio3, fim3, tempo3;
        double inicio4, fim4, tempo4;

        System.out.printf("%5s%10s%10s%10s%10s\n","n", "tempo1", "tempo2", "tempo3", "tempo4");
        System.out.println("---------------------------------------------");
        for (int n = 0; n <= 10; n+=1) {
            inicio1 = System.currentTimeMillis();
            metodo1(n);
            fim1 = System.currentTimeMillis();
            tempo1 = fim1 - inicio1;
            inicio2 = System.currentTimeMillis();
            metodo2(n);
            fim2 = System.currentTimeMillis();
            tempo2 = fim2 - inicio2;
            inicio3 = System.currentTimeMillis();
            metodo3(n);
            fim3 = System.currentTimeMillis();
            tempo3 = fim3 - inicio3;
            inicio4 = System.currentTimeMillis();
            metodo4(n);
            fim4 = System.currentTimeMillis();
            tempo4 = fim4 - inicio4;
            System.out.printf("%5d%10.0f%10.0f%10.0f%10.0f\n", n, tempo1, tempo2, tempo3, tempo4);
        }

    }

    static void metodo1 (long n) {
        long valor = 0;                        
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (long i = 10; i < 12; i++) {
            for (long j = 4; j <= 6; j++) {
                valor += 1;
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static void metodo2 (long n) {
        long valor = 0;
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (long i = 1; i < n; i++) {
            for (long j = 1; j <= 5; j++) {
                valor += 1;
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static void metodo3 (long n) {
        long valor = 0;
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (long i = 0; i <= n; i++) {
            for (long j = 1; j <= n - i + 1; j++) {
                valor += 1;
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static void metodo4 (long n) {
        long valor = 0;
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (long i = 1; i <= n * n; i++) {
            for (long j = 0; j <= i; j++) {
                valor += 1;
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
