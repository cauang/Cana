import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Exercicio4{
	public static void main(String[] args) {
		int n = 1000;
		int[] A;
		A = criaVetorAleatorio(n);
		double inicio, fim, tempo;
		inicio = System.currentTimeMillis();
		metodo(A, n);
		fim = System.currentTimeMillis();
		tempo = fim - inicio;
		System.out.printf("Tempo: %1.0f", tempo);
	}

	static double metodo (int[] vetor, int n) {
		double v = 1;					//c1         1
		for (int i = 0; i < n; i++) {	//c2         N+1
			try {						
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			v = v * vetor[i];		//c3         N
				//T(n) = O(n) ---- LINEAR		
			if (v == 0) {
				return 0;
			}
		}
		return v;
	}
	
	static int[] criaVetorAleatorio (int n) {
		Random randomGenerator = new Random();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = randomGenerator.nextInt(100);
		}
		return A;
	}
}
