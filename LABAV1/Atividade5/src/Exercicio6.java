import java.util.concurrent.TimeUnit;

public class Exercicio6 {
	public static void main(String[] args) {
		double inicio1, fim1, tempo1;
		double inicio2, fim2, tempo2;
		System.out.printf("%5s%20s%10s%20s%10s\n","n", "pot1", "tempo1", "pot2", "tempo2");
		System.out.println("-----------------------------------------------------------------");
		for (int n = 1; n <= 30; n++) {
			inicio1 = System.currentTimeMillis();
			int pot1 = potencia1(2, n);
			fim1 = System.currentTimeMillis();
			tempo1 = fim1 - inicio1;
			inicio2 = System.currentTimeMillis();
			int pot2 = potencia2(2, n);
			fim2 = System.currentTimeMillis();
			tempo2 = fim2 - inicio2;
			System.out.printf("%5d%20d%10.0f%20d%10.0f\n", n, pot1, tempo1, pot2, tempo2);
		}
	}

	static int potencia1 (int a, int n) {
		int total = 1;					// c1  1
		for (int i = 1; i <= n; i++) {	// c2  n+1
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			total = total * a;		    // c3  n
		}	
		return total;					// c4  1
		// T(n) = c2*(n+1) + c3*n + (c1+c4)  =>  Θ(n)
	}
	
	static int potencia2 (int a, int n) {
		if (n == 0) {
			return 1;
		} else {
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int aux = potencia2 (a, n/2);
			if (n % 2 == 0) {
				return aux * aux;
			} else {
				return aux * aux * a;
			}
		}
	}	
}
