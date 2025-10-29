import java.util.Random;

public class Exercicio3 {

    static class Aluno {
        public String matricula;
        public String nome;
        public int creditos;

        public Aluno() {
            Random randomGenerator = new Random();
            matricula = "";
            for (int i = 1; i <= 6; i++) {
                matricula += (char) ('0' + randomGenerator.nextInt(10));
            }
            nome = "";
            nome += (char)('A' + randomGenerator.nextInt(26));
            for (int i = 2; i <= 5; i++) {
                nome += (char) ('a' + randomGenerator.nextInt(26));
            }
            creditos = randomGenerator.nextInt(121); // 0 até 120
        }
    }

    public static void main(String[] args) {
        //        int n = 15;
        //        Aluno[] alunos = new Aluno[n];
        //        for (int i = 0; i < alunos.length; i++) {
        //            alunos[i] = new Aluno();
        //        }
        //
        //        System.out.println("ANTES DA ORDENACAO (por creditos):");
        //        imprime(alunos);
        //
        //        alunos = ordenaCreditos(alunos);
        //
        //        System.out.println("DEPOIS DA ORDENACAO (por creditos):");
        //          imprime(alunos);

        //PASSO 3
        int n = 15;
        Aluno[] alunos = new Aluno[n];
        for (int i = 0; i < alunos.length; i++) {
            alunos[i] = new Aluno();
        }

        System.out.println("ANTES DA ORDENACAO (por matricula):");
        imprime(alunos);

        alunos = ordenaMatricula(alunos);

        System.out.println("DEPOIS DA ORDENACAO (por matricula):");
        imprime(alunos);

    }

    // ---------- COUNTING SORT por campo 'creditos' ----------
    static Aluno[] ordenaCreditos(Aluno[] A) {
        int n = A.length;
        int MAX = 120;
        Aluno[] B = new Aluno[n];
        int[] C = new int[MAX + 1];

        for (int i = 0; i < n; i++) {   // c1   n
            C[A[i].creditos]++;         // c2   n
        }

        for (int i = 1; i <= MAX; i++) { // c3   120
            C[i] = C[i] + C[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) { // c4   n
            int cred = A[i].creditos;
            int pos = C[cred] - 1;
            B[pos] = A[i];
            C[cred]--;
        }
        // T(n) = c1*n + c2*n + c3*120 + c4*n = Θ(n)
        return B;
    }

    // ---------- RADIX SORT (base 10) ----------
    static Aluno[] ordenaMatricula(Aluno[] A) {
        int n = A.length;
        Aluno[] B = new Aluno[n];

        for (int d = 5; d >= 0; d--) {             // c1   6 (constante)
            B = countingSortMatricula(A, d);       // c2   6 chamadas de O(n)
            A = B;                                 // c3   6
        }

        // T(n) = 6 * O(n) = Θ(n)
        return B;
    }

    static Aluno[] countingSortMatricula(Aluno[] A, int d) {
        int n = A.length;
        Aluno[] B = new Aluno[n];
        int[] C = new int[10];

        // Etapa 1: contagem de frequências
        for (int j = 0; j < n; j++) {                      // c1   n
            int digito = (int) A[j].matricula.charAt(d) - '0';
            C[digito]++;
        }

        // Etapa 2: soma acumulada
        for (int i = 1; i < 10; i++) {                     // c2   9
            C[i] = C[i] + C[i - 1];
        }

        // Etapa 3: construção estável (trás → frente)
        for (int j = n - 1; j >= 0; j--) {                 // c3   n
            int digito = (int) A[j].matricula.charAt(d) - '0';
            int pos = C[digito] - 1;
            B[pos] = A[j];
            C[digito]--;
        }

        // T(n) = c1*n + c2*9 + c3*n = Θ(n)
        return B;
    }

    static void imprime(Aluno[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.printf("%-15s%-15s%10d\n", A[i].matricula, A[i].nome, A[i].creditos);
        }
        System.out.print("\n\n");
    }
}
