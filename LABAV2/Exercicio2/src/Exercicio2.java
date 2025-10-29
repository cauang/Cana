import java.util.Random;

public class Exercicio2 {

    static class Crianca {
        public String nome;
        public int idade;
        public char turno;

        public Crianca() {
            Random randomGenerator = new Random();
            nome = "";
            nome += (char)('A' + randomGenerator.nextInt(26));
            for (int i = 2; i <= 10; i++) {
                nome += (char) ('a' + randomGenerator.nextInt(26));
            }
            idade = 6 + randomGenerator.nextInt(11);
            turno = (randomGenerator.nextInt(2) == 0) ? 'M' : 'T';
        }
    }

    public static void main(String[] args) {
        int n = 20;
        Crianca[] criancas = new Crianca[n];
        for (int i = 0; i < criancas.length; i++) {
            criancas[i] = new Crianca();
        }
        imprime(criancas);
        //organizaTurno (criancas);
        organizaIdade (criancas);
        imprime(criancas);
    }
     static void swap(Crianca[] A, int i, int j){
         Crianca tmp = A[i];
         A[i] = A[j];
         A[j] = tmp;
    }
    static void organizaTurno (Crianca[] A) {
        int p = 0;                              // c1   1
        for (int j = 0; j < A.length; j++) {    // c2   (n)−(0)+1=n+1
            if (A[j].turno == 'M') {            // c3   n
                swap(A, p, j);                  // c4   m vezes (m = nº de 'M', 0 ≤ m ≤ n)
                p++;                            // c5   m vezes

                // t(n) = Θ(n);
                // Como 0 ≤ m ≤ n  ⇒ pior caso m = n  -> T(n) = Θ(n)
            }
        }
    }
    static int classeIdade(int idade){
        if (idade >= 14 && idade <= 16) return 0;
        if (idade >= 11 && idade <= 13) return 1;
        return 2;
    }

    static void organizaIdade (Crianca[] A) {
        int low = 0;                                // c1   1
        int mid = 0;                                // c2   1       
        int high = A.length - 1;                    // c3   1

        while(mid <= high){                         // c4       2n+1
            int cls = classeIdade(A[mid].idade);    // c5       2n
            if (cls ==0) {                            
                swap(A, low, mid);              
                low++;                        
                mid++;                            
            }else if (cls ==1){                    
                mid ++;                           

            }else {                              
                swap(A, mid, high);               
                high --;                     
            }
        }
        // t(n) = Θ(n)                           

    }

    static void imprime (Crianca[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.printf("%15s%7d%7c\n", A[i].nome, A[i].idade, A[i].turno);
        }
        System.out.print("\n\n\n");
    }
}
