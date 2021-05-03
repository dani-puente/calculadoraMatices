// DANIEL PUENTE TRECEÑO, 1º DAM
import java.util.Scanner;
public class CalculadoraMatrices {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean operacionValida = true;
		while (operacionValida == true) {
			System.out.println("Selecciona operacion: ");
			System.out.println("1. Suma.");
			System.out.println("2. Producto de un escalar por una matriz.");
			System.out.println("3. Producto.");
			System.out.println("4. Transponer.");
			System.out.println("5. Diagonal principal de una matriz.");
			System.out.println("6. Comprobar si es simetrica.");
			System.out.println("7. Potencia de una matriz cuadrada.");
			System.out.println("8. Resta.");
			System.out.println("9. Salir.");
			int operacion = sc.nextInt();
			if (operacion < 1 || operacion > 9) {
				System.out.println("Operacion no válida, vuelve a introducir un número");
			} else {
				switch (operacion) {
				case 1:
					boolean comprobado = false;
					int[][] A = null;
					int[][] B = null;
					while (comprobado == false) {
						A = crearYRellenarMatriz();
						B = crearYRellenarMatriz();

						if (A.length != B.length || A[0].length != B[0].length) {
							System.out.println("Introduce unas matrices validas.");

						} else {
							comprobado = true;
						}
					}
					imprimir(sumar(A, B));
					break;
				case 2:
					int[][] C = crearYRellenarMatriz();
					int escalar = sc.nextInt();
					imprimir(matrizPorEscalar(C, escalar));
					break;
				case 3:
					boolean sePuedeMultiplicar = false;
					while (sePuedeMultiplicar == false) {
						int[][] D = crearYRellenarMatriz();
						int[][] E = crearYRellenarMatriz();
						int colD = D[0].length;
						int filE = E.length;
						if (colD != filE) {
							System.out.println("No se pueden multiplicar, introduce otras matrices: ");
						} else {
							sePuedeMultiplicar = true;
							imprimir(multiplicar(D, E));
						}
					}

					break;
				case 4:
					int[][] F = crearYRellenarMatriz();
					imprimir(transponer(F));
					break;
				case 5:
					System.out.println("No implementado.");
					break;
				case 6:
					int[][] H = crearYRellenarMatriz();
					esSimetrica(H);
					break;
				case 7:
					int[][] I = crearYRellenarMatriz();
					int exp = sc.nextInt();
					imprimir(potencia(I, exp));
					break;
				case 8:
					int [][] J = crearYRellenarMatriz();
					int [][] K = crearYRellenarMatriz();
					imprimir (resta(J,K));
					break;
				case 9:
					operacionValida = false;
					break;

				}

			}
		}

	}

	public static int[][] crearYRellenarMatriz() {
		Scanner sc = new Scanner(System.in);
		int[][] matriz = null;
		System.out.println("Define la matriz:");
		System.out.println("Numero de filas: ");
		int filas = sc.nextInt();
		System.out.println("Numero de columnas: ");
		int columnas = sc.nextInt();
		matriz = new int[filas][columnas];
		System.out.println("Rellena la matriz: ");
		for (int i = 0; i < matriz.length; i++) {
			System.out.println("Fila " + (i + 1) + ": ");
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = sc.nextInt();
			}
		}
		return matriz;
	}

	public static void imprimir(int[][] A) {
		for (int x = 0; x < A.length; x++) {
			System.out.print("|");
			for (int y = 0; y < A[x].length; y++) {
				System.out.print(A[x][y]);
				if (y != A[x].length - 1)
					System.out.print("\t");
			}
			System.out.println("|");
		}
	}

	public static int[][] sumar(int[][] A, int[][] B) {

		int[][] suma = new int[A.length][B[0].length];

		for (int x = 0; x < suma.length; x++) {
			for (int y = 0; y < suma[x].length; y++) {
				suma[x][y] = A[x][y] + B[x][y];
			}
		}
		return suma;
	}

	public static int[][] matrizPorEscalar(int[][] A, int escalar) {
		for (int x = 0; x < A.length; x++) {
			for (int y = 0; y < A[x].length; y++) {
				A[x][y] = escalar * A[x][y];
			}
		}
		return A;
	}

	public static int[][] multiplicar(int[][] A, int[][] B) {
		int filA = A.length;
		int colB = B[0].length;

		int[][] multipl = new int[filA][colB];
		for (int x = 0; x < multipl.length; x++) {
			for (int y = 0; y < multipl[x].length; y++) {
				for (int z = 0; z < filA; z++) {
					multipl[x][y] += A[x][z] * B[z][y];
				}
			}
		}

		return multipl;

	}

	public static int[][] transponer(int[][] A) {
		int[][] traspu = new int[A[0].length][A.length];

		for (int x = 0; x < A.length; x++) {
			for (int y = 0; y < A[x].length; y++) {
				traspu[y][x] = A[x][y];
			}
		}

		return traspu;

	}

	public static boolean esSimetrica(int[][] A) {
		boolean aDevolver;
		int[][] simetrica = transponer(A);
		if (simetrica.equals(A)) {
			aDevolver = true;
		} else {
			aDevolver = false;
		}
		return aDevolver;
	}

	public static int[][] potencia(int[][] A, int exp) {
		int[][] potencia = new int[A.length][A[0].length];
		return potencia;
	}

	public static int[][] resta(int[][] A, int[][] B) {
		int[][] resta = new int[A.length][B[0].length];
		for (int x = 0; x < resta.length; x++) {
			for (int y = 0; y < resta[x].length; y++) {
				resta[x][y] = A[x][y] - B[x][y];
			}
		}
		return resta;
	}

}