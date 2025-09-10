import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Exercicio5 {
	public static void main(String[] args) {

		int[] A;
		double inicio1, fim1, tempo1;
		double inicio2, fim2, tempo2;

		System.out.printf("%5s%10s%10s%10s%10s\n","n", "soma1", "tempo1", "soma2", "tempo2");
		System.out.println("---------------------------------------------");
		for (int n = 1; n <= 50; n++) {
			A = criaVetorAleatorio(n);
			inicio1 = System.currentTimeMillis();
			int soma1 = soma1(A, n);
			fim1 = System.currentTimeMillis();
			tempo1 = fim1 - inicio1;
			inicio2 = System.currentTimeMillis();
			int soma2 = soma2(A, 0, n-1);
			fim2 = System.currentTimeMillis();
			tempo2 = fim2 - inicio2;
			System.out.printf("%5d%10d%10.0f%10d%10.0f\n", n, soma1, tempo1, soma2, tempo2);
		}
	}

	static int soma1 (int[] vetor, int n) {
		int total = 0;		 			// c1		  1
		for (int i = 0; i < n; i++) { 	// c2	    n+1
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			total = total + vetor[i]; 	// c3 	  n
		}
		return total;					// c4	  1
		// T(n) = c2*(n+1) + c3*n + (c1+c4)  =>  Θ(n)
	}
	
	static int soma2 (int[] vetor, int i, int f) {
		if (i == f) {					// c1	 2n-1
			return vetor[i];			// c2	 n
		} else {
			int m = (i+f) / 2;			// c3	 n-1	
			try {
				TimeUnit.MILLISECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return soma2(vetor, i, m) + soma2(vetor, m+1, f); // c4		n-1
			// T(n) = a*(2n-1) + b*(n-1) + d*n  = Θ(n)
		}
	}
	static int[] criaVetorAleatorio (int n) {
		Random randomGenerator = new Random();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = randomGenerator.nextInt(100*n);
		}
		return A;
	}

}
