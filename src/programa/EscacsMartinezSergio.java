package programa;

import java.util.HashMap;

import Teclat.*;

public class EscacsMartinezSergio {

	public static void main(String[] args) {

		// DEFINICIÓ DEL TAULER
		int qFiles;
		int qColumnes;
		boolean seleccionar = true;
		final char MOVIMENTS = 'X';
		int opcio = 0;
		char eixir = ' ';
		final char BUIT = ' ';
		char peça = ' ';

		// VECTOR PER A GUARDAR LES LLETRES I MOSTRAR LES COLUMNES AMB AQUESTES
		char[] lletra = new char[9 + 1];

		// INTRODUIM LES LLETRES EN EL VECTOR
		lletra[1] = 'A';
		lletra[2] = 'B';
		lletra[3] = 'C';
		lletra[4] = 'D';
		lletra[5] = 'E';
		lletra[6] = 'F';
		lletra[7] = 'G';
		lletra[8] = 'H';
		lletra[9] = 'I';

		// HASHMAP PER A LES COLUMNES
		HashMap<Character, Integer> numeros = new HashMap<Character, Integer>();

		// INTRODUIM LES LLETRES COM A CLAU I EL SEU VALOR EN NÚMERO
		numeros.put('A', 1);
		numeros.put('B', 2);
		numeros.put('C', 3);
		numeros.put('D', 4);
		numeros.put('E', 5);
		numeros.put('F', 6);
		numeros.put('G', 7);
		numeros.put('H', 8);
		numeros.put('I', 9);

		qFiles = Teclat.lligInt("QUANTES FILES TINDRÀ EL TAULER: ", 5, 9);

		qColumnes = Teclat.lligInt("QUANTES COLUMNES TINDRÀ EL TAULER", 5, 9);

		char Tauler[][] = new char[qFiles + 1][qColumnes + 1];

		for (int i = 1; i <= qFiles; i++) {
			for (int j = 1; j <= qColumnes; j++) {
				Tauler[i][j] = BUIT;

			}

		}

		// BUCLE PRINCIPAL ------------------------------------

		int fila;
		int colint;
		char colchar; // aquesta definició s'utilitza per l'hora de posar peça o mostrar moviment amb
						// lletres en les columnes
		while (seleccionar == true) {

			// MOSTREM EL TAULER
			// TAULER COLUMNES AMB NÚMEROS (es pot posar amb comentari i utilitzar amb
			// lletres)

			System.out.println();
			System.out.println("//////////////////////////////////////////");
			System.out.println();
			System.out.print(" ");
			for (colint = 1; colint <= qColumnes; colint++) {

				System.out.print(" " + colint);
			}

			System.out.println(" ");
			for (fila = 1; fila <= qFiles; fila++) {
				System.out.print(fila);
				for (colint = 1; colint <= qColumnes; colint++) {
					System.out.print(" " + Tauler[fila][colint]);

				}
				System.out.println(" ");
			}

			System.out.print(" ");
			for (colint = 1; colint <= qColumnes; colint++) {

				System.out.print(" " + colint);
			}
			System.out.println();

			// TAULER COLUMNES AMB LLETRES -----------------------------------

//			for (colint = 1; colint <= qColumnes; colint++) {
//				System.out.print(" " + lletra[colint]);
//
//			}
//
//			System.out.println(" ");
//			for (fila = 1; fila <= qFiles; fila++) {
//				System.out.print(fila);
//				for (colint = 1; colint <= qColumnes; colint++) {
//					System.out.print(" " + Tauler[fila][colint]);
//
//				}
//				System.out.println(" ");
//			}
//
//			for (colint = 1; colint <= qColumnes; colint++) {
//				System.out.print(" " + lletra[colint]);
//			}

			// MOSTREM EL MENÚ ----------------------------------------
			System.out.println();
			System.out.println("//////////////////////////////////////////");
			Pantalla.titol("ET MOSTRE EL SEGÜENT MENÚ");
			System.out.println("1- Posar una peça.");
			System.out.println("2- Mostrar els moviments d'una peça.");
			System.out.println("3- Esborrar els moviments.");
			System.out.println("4- Esborrar el tauler (Peces i Moviments).");
			System.out.println("5- Eixir.");
			System.out.println();
			Pantalla.titolet("SELECCIONA UNA DE LE OPCIONS ANTERIORS: ");

			// SENTÈNCIA SWITCH PER A SELECCIONAR OPCIÓ
			opcio = Teclat.lligInt("Tria una opció: ", 1, 5);

			switch (opcio) {
			case 1:

				peça = Teclat.lligChar("SELECCIONA TIPUS DE PEÇA: Torre, Alfil, Dama, Rei, Cavall o Peó:", "tadcrp");

				System.out.println("EN QUINA COORDENADA VOLS DEIXAR LA PEÇA??");

				fila = Teclat.lligInt("Nº de FIla: ", 1, qFiles);

				// COLUMNA ON DEIXAR UNA PEÇA AMB ENTERS-----------------------------

				colint = Teclat.lligInt("Nº Columna: ", 1, qColumnes);

				// COLUMNA ON DEIXAR UNA PEÇA AMB LLETRES (està per defecte amb números, es pot
				// utilitzar també amb lletres)

//				colchar = Teclat.lligChar("Lletra columna: ", "abcdefghi");
//				colint = numeros.get(colchar);

				Tauler[fila][colint] = peça;
				break;

			// DEMANENM COORDENADES DE ALGUNA DE LES PECES QUE HI HA EN EL TAULER
			case 2:
				System.out.println("DIS-ME LES COORDENADES DE LA PEÇA, LA QUAL VOLS MOSTRAR ELS MOVIMENTS: ");
				fila = Teclat.lligInt("Nº Fila: ", 1, qFiles);

				// PER A DEMANAR COLUMNA DE LA POSICIÓ D'UNA PEÇA AMB ENTERS (es pot demanar
				// també amb lletres, al igual que per a demanar columna)

				colint = Teclat.lligInt("Nº COlumna: ", 1, qColumnes);

				// PER A DEMANAR COLUMNA DE LA POSICIÓ D'UNA PEÇA AMB LLETRES

//				colchar = Teclat.lligChar("LLetra Columna: ", "abcdefghi");
//				colint = numeros.get(colchar);

				// SENTÈNCIA SWITCH PER A MOSTRAR POSSIBLES MOVIMENTS
				switch (Tauler[fila][colint]) {

				// MOVIMENTS DEL REI -----------------------------------------------------
				case 'R':

					if (fila - 1 >= 1 && colint - 1 >= 1) {
						if (Tauler[fila - 1][colint - 1] == BUIT) {
							Tauler[fila - 1][colint - 1] = MOVIMENTS;
						}

					}
					if (fila + 1 <= qFiles && colint + 1 <= qColumnes) {
						if (Tauler[fila + 1][colint + 1] == BUIT) {
							Tauler[fila + 1][colint + 1] = MOVIMENTS;
						}

					}
					if (fila - 1 >= 1 && colint + 1 <= qColumnes) {
						if (Tauler[fila - 1][colint + 1] == BUIT) {
							Tauler[fila - 1][colint + 1] = MOVIMENTS;
						}

					}
					if (fila + 1 <= qFiles && colint - 1 >= 1) {
						if (Tauler[fila + 1][colint - 1] == BUIT) {
							Tauler[fila + 1][colint - 1] = MOVIMENTS;
						}

					}
					if (colint - 1 >= 1) {
						if (Tauler[fila][colint - 1] == BUIT) {
							Tauler[fila][colint - 1] = MOVIMENTS;
						}

					}
					if (colint + 1 <= qColumnes) {
						if (Tauler[fila][colint + 1] == BUIT) {
							Tauler[fila][colint + 1] = MOVIMENTS;
						}

					}
					if (fila - 1 >= 1) {
						if (Tauler[fila - 1][colint] == BUIT) {
							Tauler[fila - 1][colint] = MOVIMENTS;
						}

					}
					if (fila + 1 <= qFiles) {
						if (Tauler[fila + 1][colint] == BUIT) {
							Tauler[fila + 1][colint] = MOVIMENTS;
						}

					}
					break;

				// MOVIMENTS DE LA TORRE ------------------------------------------
				case 'T':

					for (int c = colint - 1; c >= 1; c--) {
						if (Tauler[fila][c] != BUIT && Tauler[fila][c] != MOVIMENTS) {
							break;
						}
						Tauler[fila][c] = MOVIMENTS;

					}
					for (int c = colint + 1; c <= qColumnes; c++) {
						if (Tauler[fila][c] != BUIT && Tauler[fila][c] != MOVIMENTS) {
							break;
						}
						Tauler[fila][c] = MOVIMENTS;

					}
					for (int f = fila - 1; f >= 1; f--) {
						if (Tauler[f][colint] != BUIT && Tauler[f][colint] != MOVIMENTS) {
							break;
						}
						Tauler[f][colint] = MOVIMENTS;

					}
					for (int f = fila + 1; f <= qFiles; f++) {
						if (Tauler[f][colint] != BUIT && Tauler[f][colint] != MOVIMENTS) {
							break;
						}
						Tauler[f][colint] = MOVIMENTS;
					}
					break;

				// MOVIMENTS DEL ÀLFIL --------------------------------------------------
				case 'A':

					for (int f = fila - 1, c = colint - 1; f >= 1 && c >= 1; f--, c--) {
						if (Tauler[f][c] != BUIT && Tauler[f][c] != MOVIMENTS) {
							break;
						}
						Tauler[f][c] = MOVIMENTS;
					}
					for (int f = fila + 1, c = colint + 1; f <= qFiles && c <= qColumnes; f++, c++) {
						if (Tauler[f][c] != BUIT && Tauler[f][c] != MOVIMENTS) {
							break;
						}
						Tauler[f][c] = MOVIMENTS;
					}
					for (int f = fila - 1, c = colint + 1; f >= 1 && c <= qFiles; f--, c++) {
						if (Tauler[f][c] != BUIT && Tauler[f][c] != MOVIMENTS) {
							break;
						}
						Tauler[f][c] = MOVIMENTS;
					}
					for (int f = fila + 1, c = colint - 1; f <= qFiles && c >= 1; f++, c--) {
						if (Tauler[f][c] != BUIT && Tauler[f][c] != MOVIMENTS) {
							break;
						}
						Tauler[f][c] = MOVIMENTS;
					}
					break;

				// MOVIMENTS DEL LA DAMA -----------------------------------------------
				case 'D':
					for (int f = fila - 1, c = colint - 1; f >= 1 && c >= 1; f--, c--) {
						if (Tauler[f][c] != BUIT && Tauler[f][c] != MOVIMENTS) {
							break;
						}
						Tauler[f][c] = MOVIMENTS;
					}
					for (int f = fila + 1, c = colint + 1; f <= qFiles && c <= qColumnes; f++, c++) {
						if (Tauler[f][c] != BUIT && Tauler[f][c] != MOVIMENTS) {
							break;
						}
						Tauler[f][c] = MOVIMENTS;
					}
					for (int f = fila - 1, c = colint + 1; f >= 1 && c <= qFiles; f--, c++) {
						if (Tauler[f][c] != BUIT && Tauler[f][c] != MOVIMENTS) {
							break;
						}
						Tauler[f][c] = MOVIMENTS;
					}
					for (int f = fila + 1, c = colint - 1; f <= qFiles && c >= 1; f++, c--) {
						if (Tauler[f][c] != BUIT && Tauler[f][c] != MOVIMENTS) {
							break;
						}
						Tauler[f][c] = MOVIMENTS;
					}

					for (int c = colint - 1; c >= 1; c--) {
						if (Tauler[fila][c] != BUIT && Tauler[fila][c] != MOVIMENTS) {
							break;
						}
						Tauler[fila][c] = MOVIMENTS;

					}
					for (int c = colint + 1; c <= qColumnes; c++) {
						if (Tauler[fila][c] != BUIT && Tauler[fila][c] != MOVIMENTS) {
							break;
						}
						Tauler[fila][c] = MOVIMENTS;

					}
					for (int f = fila - 1; f >= 1; f--) {
						if (Tauler[f][colint] != BUIT && Tauler[f][colint] != MOVIMENTS) {
							break;
						}
						Tauler[f][colint] = MOVIMENTS;

					}
					for (int f = fila + 1; f <= qFiles; f++) {
						if (Tauler[f][colint] != BUIT && Tauler[f][colint] != MOVIMENTS) {
							break;
						}
						Tauler[f][colint] = MOVIMENTS;
					}
					break;

				// MOVIMENTS DEL CAVALL--------------------------------------------------
				case 'C':
					// COMPROBANT EL INDEX DEL TAULER, QUE ESTIGA BUIT I FER EL MOVIMENT
					
//					if (fila + 1 <= qFiles && colint - 2 >= 1) {
//						if (Tauler[fila + 1][colint - 2] == BUIT) {
//							Tauler[fila + 1][colint - 2] = MOVIMENTS;
//						}
//
//					}
//					if (fila + 2 <= qFiles && colint - 1 >= 1) {
//						if (Tauler[fila + 2][colint - 1] == BUIT) {
//							Tauler[fila + 2][colint - 1] = MOVIMENTS;
//						}
//
//					}
//					if (fila - 1 >= 1 && colint - 2 >= 1) {
//						if (Tauler[fila - 1][colint - 2] == BUIT) {
//							Tauler[fila - 1][colint - 2] = MOVIMENTS;
//						}
//
//					}
//					if (fila - 2 >= 1 && colint - 1 >= 1) {
//						if (Tauler[fila - 2][colint - 1] == BUIT) {
//							Tauler[fila - 2][colint - 1] = MOVIMENTS;
//						}
//
//					}
//					if (fila - 2 >= 1 && colint + 1 <= qColumnes) {
//						if (Tauler[fila - 2][colint + 1] == BUIT) {
//							Tauler[fila - 2][colint + 1] = MOVIMENTS;
//						}
//
//					}
//					if (fila - 1 >= 1 && colint + 2 <= qColumnes) {
//						if (Tauler[fila - 1][colint + 2] == BUIT) {
//							Tauler[fila - 1][colint + 2] = MOVIMENTS;
//						}
//
//					}
//					if (fila + 1 <= qFiles && colint + 2 <= qColumnes) {
//						if (Tauler[fila + 1][colint + 2] == BUIT) {
//							Tauler[fila + 1][colint + 2] = MOVIMENTS;
//						}
//
//					}
//					if (fila + 2 <= qFiles && colint + 1 <= qColumnes) {
//						if (Tauler[fila + 2][colint + 1] == BUIT) {
//							Tauler[fila + 2][colint + 1] = MOVIMENTS;
//						}
//
//					}
//					break;

					// MOVIMENTS DEL CAVAL (Tractant els possibles errors)
					
					try {
						if (Tauler[fila + 1][colint - 2] == BUIT) {
							Tauler[fila + 1][colint - 2] = MOVIMENTS;
						}

					} catch (ArrayIndexOutOfBoundsException e) {

					}
					try {
						if (Tauler[fila + 2][colint - 1] == BUIT) {
							Tauler[fila + 2][colint - 1] = MOVIMENTS;
						}

					} catch (ArrayIndexOutOfBoundsException e) {

					}
					try {
						if (Tauler[fila - 1][colint - 2] == BUIT) {
							Tauler[fila - 1][colint - 2] = MOVIMENTS;
						}

					} catch (ArrayIndexOutOfBoundsException e) {

					}
					try {
						if (Tauler[fila - 2][colint - 1] == BUIT)
							Tauler[fila - 2][colint - 1] = MOVIMENTS;

					} catch (ArrayIndexOutOfBoundsException e) {

					}
					try {
						if (Tauler[fila - 2][colint + 1] == BUIT)
							Tauler[fila - 2][colint + 1] = MOVIMENTS;

					} catch (ArrayIndexOutOfBoundsException e) {

					}
					try {
						if (Tauler[fila - 1][colint + 2] == BUIT)
							Tauler[fila - 1][colint + 2] = MOVIMENTS;

					} catch (ArrayIndexOutOfBoundsException E) {

					}
					try {
						if (Tauler[fila + 1][colint + 2] == BUIT)
							Tauler[fila + 1][colint + 2] = MOVIMENTS;

					} catch (ArrayIndexOutOfBoundsException e) {

					}
					try {
						if (Tauler[fila + 2][colint + 1] == BUIT)
							Tauler[fila + 2][colint + 1] = MOVIMENTS;

					} catch (ArrayIndexOutOfBoundsException e) {

					}
					break;

				// MOVIMENTS DEL PEÓ (he imaginat que el peó va cap a dalt. Si el peó està en la
				// fila de la seua posició inicial, mostra els 2 possibles moviments)
				case 'P':
					if (fila == qFiles - 1) {
						if (fila - 2 >= 1) {
							if (Tauler[fila - 2][colint] == BUIT) {
								Tauler[fila - 2][colint] = MOVIMENTS;

							}
							if (fila - 1 >= 1) {
								if (Tauler[fila - 1][colint] == BUIT) {
									Tauler[fila - 1][colint] = MOVIMENTS;
								}
							}

						}

					} else {
						if (Tauler[fila - 1][colint] == BUIT) {
							Tauler[fila - 1][colint] = MOVIMENTS;
						}

					}

				}
				break;

			// ESBORRAR MOVIMENTS
			case 3:
				int totalMarquesBorrades = 0;
				System.out.println();
				for (int i = 1; i <= qFiles; i++) {
					for (int j = 1; j <= qFiles; j++) {
						if (Tauler[i][j] == MOVIMENTS) {
							totalMarquesBorrades++;
							Tauler[i][j] = BUIT;
						}
					}
				}
				Pantalla.titolet("¡¡¡MOVIMENTS ESBORRATS!!!");
				System.out.println();
				Pantalla.titolet("S'han esborrat un total de: " + totalMarquesBorrades + " marques.");
				break;
				
			// ESBORRAR PECES I MOVIMENTS
			case 4:
				System.out.println();
				Pantalla.titolet("¡¡¡PECES I MOVIMENTS ESBORRATS!!!");

				for (int i = 1; i <= qFiles; i++) {
					for (int j = 1; j <= qColumnes; j++) {
						Tauler[i][j] = BUIT;
					}
				}
				break;

			// EIXIR DEL PROGRAMA
			case 5:
				eixir = Teclat.lligChar("Tecleja 's' o 'S' per a eixir: ");
				if (eixir == 's' || eixir == 'S') {
					seleccionar = false;
				}
				break;

			}

		}
		System.out.println();
		System.out.println("ADEU");

	}
}
