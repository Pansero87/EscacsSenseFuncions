package programa;

import Teclat.*;

public class EscacsMartinezSergioTryCatch {

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

		qFiles = Teclat.lligInt("QUANTES FILES TINDRÀ EL TAULER??:");
		while (qFiles < 5 || qFiles > 9) {
			qFiles = Teclat.lligInt("Ha d'estar entre 5 i 9, torna a teclejar:");
		}

		qColumnes = Teclat.lligInt("QUANTES COLUMNES TINRÀ EL TAULER??:");
		while (qColumnes < 5 || qColumnes > 9) {
			qColumnes = Teclat.lligInt("Ha d'estar entre 5 i 9, torna a teclejar:");
		}

		char Tauler[][] = new char[qFiles + 1][qColumnes + 1];

		for (int i = 1; i <= qFiles; i++) {
			for (int j = 1; j <= qColumnes; j++) {
				Tauler[i][j] = BUIT;

			}

		}

		// BUCLE PRINCIPAL ------------------------------------

		int fila = 0;
		int columna = 0;
		while (seleccionar == true) {

			// MOSTREM EL TAULER
			// TAULER COLUMNES AMB NÚMEROS

			System.out.println();
			System.out.println("//////////////////////////////////////////");
			System.out.println();
			System.out.print(" ");
			for (columna = 1; columna <= qColumnes; columna++) {

				System.out.print(" " + columna);
			}

			System.out.println(" ");
			for (fila = 1; fila <= qFiles; fila++) {
				System.out.print(fila);
				for (columna = 1; columna <= qColumnes; columna++) {
					System.out.print(" " + Tauler[fila][columna]);

				}
				System.out.println(" ");
			}

			System.out.print(" ");
			for (columna = 1; columna <= qColumnes; columna++) {

				System.out.print(" " + columna);
			}
			System.out.println();

			// TAULER COLUMNES AMB LLETRES -----------------------------------

			// for (columna = 1; columna <= qColumnes; columna++) {
			// System.out.print(" " + lletra[columna]);
			//
			// }
			//
			// System.out.println(" ");
			// for (fila = 1; fila <= qFiles; fila++) {
			// System.out.print(fila);
			// for (columna = 1; columna <= qColumnes; columna++) {
			// System.out.print(" " + Tauler[fila][columna]);
			//
			// }
			// System.out.println(" ");
			// }
			//
			// for (columna = 1; columna <= qColumnes; columna++) {
			// System.out.print(" " + lletra[columna]);
			// }

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

				peça = Teclat.lligChar("SELECCIONA TIPUS DE PEÇA: Torre, Alfil, Dama, Rei Cavall o Peó:", "tadcrp");

				System.out.println("EN QUINA COORDENADA VOLS DEIXAR LA PEÇA??");

				fila = Teclat.lligInt("Nº de FIla: ", 1, qFiles);
				columna = Teclat.lligInt("Nº Columna: ", 1, qColumnes);
				Tauler[fila][columna] = peça;
				break;

			// DEMANENM COORDENADES DE ALGUNA DE LES PECES QUE HI HA EN EL TAULER
			case 2:
				System.out.println("DIS-ME LES COORDENADES DE LA PEÇA, LA QUAL VOLS MOSTRAR ELS MOVIMENTS: ");
				fila = Teclat.lligInt("Nº Fila: ", 1, qFiles);
				columna = Teclat.lligInt("Nº COlumna", 1, qColumnes);

				// SENTÈNCIA SWITCH PER A MOSTRAR POSSIBLES MOVIMENTS

				switch (Tauler[fila][columna]) {

				// MOVIMENTS DEL REI -----------------------------------------------------
				case 'R':
					if (fila - 1 >= 1 && columna - 1 >= 1) {
						if (Tauler[fila - 1][columna - 1] == BUIT) {
							Tauler[fila - 1][columna - 1] = MOVIMENTS;
						}

					}
					if (fila + 1 <= qFiles && columna + 1 <= qColumnes) {
						if (Tauler[fila + 1][columna + 1] == BUIT) {
							Tauler[fila + 1][columna + 1] = MOVIMENTS;
						}

					}
					if (fila - 1 >= 1 && columna + 1 <= qColumnes) {
						if (Tauler[fila - 1][columna + 1] == BUIT) {
							Tauler[fila - 1][columna + 1] = MOVIMENTS;
						}

					}
					if (fila + 1 <= qFiles && columna - 1 >= 1) {
						if (Tauler[fila + 1][columna - 1] == BUIT) {
							Tauler[fila + 1][columna - 1] = MOVIMENTS;
						}

					}
					if (columna - 1 >= 1) {
						if (Tauler[fila][columna - 1] == BUIT) {
							Tauler[fila][columna - 1] = MOVIMENTS;
						}

					}
					if (columna + 1 <= qColumnes) {
						if (Tauler[fila][columna + 1] == BUIT) {
							Tauler[fila][columna + 1] = MOVIMENTS;
						}

					}
					if (fila - 1 >= 1) {
						if (Tauler[fila - 1][columna] == BUIT) {
							Tauler[fila - 1][columna] = MOVIMENTS;
						}

					}
					if (fila + 1 <= qFiles) {
						if (Tauler[fila + 1][columna] == BUIT) {
							Tauler[fila + 1][columna] = MOVIMENTS;
						}
						
						
						
						// MOVIMENTS DEL REI AM 2 BUCLES RECORRENT UNA XICOTETA MATRIU

//						for (int f = -1; f <= 1; f++) {
//							for (int c = -1; c <= 1; c++) {
//								if (Tauler[fila + f][colint + c] != BUIT && Tauler[fila + f][colint + c] != MOVIMENTS) {
	//
//								} else {
//									if (fila + f >= 1 && fila + f <= qFiles && colint + c >= 1 && colint + c <= qColumnes) {
//										Tauler[fila + f][colint + c] = MOVIMENTS;
//									}
//								}
//							}
	//
//						}
//						break;
						
						
						
						

					}
					break;

				// MOVIMENTS DE LA TORRE ------------------------------------------
				case 'T':

					for (int c = columna - 1; c >= 1; c--) {
						if (Tauler[fila][c] != BUIT && Tauler[fila][c] != MOVIMENTS) {
							break;
						}
						Tauler[fila][c] = MOVIMENTS;

					}
					for (int c = columna + 1; c <= qColumnes; c++) {
						if (Tauler[fila][c] != BUIT && Tauler[fila][c] != MOVIMENTS) {
							break;
						}
						Tauler[fila][c] = MOVIMENTS;

					}
					for (int f = fila - 1; f >= 1; f--) {
						if (Tauler[f][columna] != BUIT && Tauler[f][columna] != MOVIMENTS) {
							break;
						}
						Tauler[f][columna] = MOVIMENTS;

					}
					for (int f = fila + 1; f <= qFiles; f++) {
						if (Tauler[f][columna] != BUIT && Tauler[f][columna] != MOVIMENTS) {
							break;
						}
						Tauler[f][columna] = MOVIMENTS;
					}
					break;

				// MOVIMENTS DEL ÀLFIL --------------------------------------------------
				case 'A':

					for (int f = fila - 1, c = columna - 1; f >= 1 && c >= 1; f--, c--) {
						if (Tauler[f][c] != BUIT && Tauler[f][c] != MOVIMENTS) {
							break;
						}
						Tauler[f][c] = MOVIMENTS;
					}
					for (int f = fila + 1, c = columna + 1; f <= qFiles && c <= qColumnes; f++, c++) {
						if (Tauler[f][c] != BUIT && Tauler[f][c] != MOVIMENTS) {
							break;
						}
						Tauler[f][c] = MOVIMENTS;
					}
					for (int f = fila - 1, c = columna + 1; f >= 1 && c <= qFiles; f--, c++) {
						if (Tauler[f][c] != BUIT && Tauler[f][c] != MOVIMENTS) {
							break;
						}
						Tauler[f][c] = MOVIMENTS;
					}
					for (int f = fila + 1, c = columna - 1; f <= qFiles && c >= 1; f++, c--) {
						if (Tauler[f][c] != BUIT && Tauler[f][c] != MOVIMENTS) {
							break;
						}
						Tauler[f][c] = MOVIMENTS;
					}
					break;

				// MOVIMENTS DEL LA DAMA -----------------------------------------------
				case 'D':
					for (int f = fila - 1, c = columna - 1; f >= 1 && c >= 1; f--, c--) {
						if (Tauler[f][c] != BUIT && Tauler[f][c] != MOVIMENTS) {
							break;
						}
						Tauler[f][c] = MOVIMENTS;
					}
					for (int f = fila + 1, c = columna + 1; f <= qFiles && c <= qColumnes; f++, c++) {
						if (Tauler[f][c] != BUIT && Tauler[f][c] != MOVIMENTS) {
							break;
						}
						Tauler[f][c] = MOVIMENTS;
					}
					for (int f = fila - 1, c = columna + 1; f >= 1 && c <= qFiles; f--, c++) {
						if (Tauler[f][c] != BUIT && Tauler[f][c] != MOVIMENTS) {
							break;
						}
						Tauler[f][c] = MOVIMENTS;
					}
					for (int f = fila + 1, c = columna - 1; f <= qFiles && c >= 1; f++, c--) {
						if (Tauler[f][c] != BUIT && Tauler[f][c] != MOVIMENTS) {
							break;
						}
						Tauler[f][c] = MOVIMENTS;
					}

					for (int c = columna - 1; c >= 1; c--) {
						if (Tauler[fila][c] != BUIT && Tauler[fila][c] != MOVIMENTS) {
							break;
						}
						Tauler[fila][c] = MOVIMENTS;

					}
					for (int c = columna + 1; c <= qColumnes; c++) {
						if (Tauler[fila][c] != BUIT && Tauler[fila][c] != MOVIMENTS) {
							break;
						}
						Tauler[fila][c] = MOVIMENTS;

					}
					for (int f = fila - 1; f >= 1; f--) {
						if (Tauler[f][columna] != BUIT && Tauler[f][columna] != MOVIMENTS) {
							break;
						}
						Tauler[f][columna] = MOVIMENTS;

					}
					for (int f = fila + 1; f <= qFiles; f++) {
						if (Tauler[f][columna] != BUIT && Tauler[f][columna] != MOVIMENTS) {
							break;
						}
						Tauler[f][columna] = MOVIMENTS;
					}
					break;

				// MOVIMENTS DEL CAVALL--------------------------------------------------
				case 'C':
					try {
						if (Tauler[fila + 1][columna - 2] == BUIT) {
							Tauler[fila + 1][columna - 2] = MOVIMENTS;
						}

					} catch (ArrayIndexOutOfBoundsException e) {

					}
					try {
						if (Tauler[fila + 2][columna - 1] == BUIT) {
							Tauler[fila + 2][columna - 1] = MOVIMENTS;
						}

					} catch (ArrayIndexOutOfBoundsException e) {

					}
					try {
						if (Tauler[fila - 1][columna - 2] == BUIT) {
							Tauler[fila - 1][columna - 2] = MOVIMENTS;
						}

					} catch (ArrayIndexOutOfBoundsException e) {

					}
					try {
						if (Tauler[fila - 2][columna - 1] == BUIT)
							Tauler[fila - 2][columna - 1] = MOVIMENTS;

					} catch (ArrayIndexOutOfBoundsException e) {

					}
					try {
						if (Tauler[fila - 2][columna + 1] == BUIT)
							Tauler[fila - 2][columna + 1] = MOVIMENTS;

					} catch (ArrayIndexOutOfBoundsException e) {

					}
					try {
						if (Tauler[fila - 1][columna + 2] == BUIT)
							Tauler[fila - 1][columna + 2] = MOVIMENTS;

					} catch (ArrayIndexOutOfBoundsException E) {

					}
					try {
						if (Tauler[fila + 1][columna + 2] == BUIT)
							Tauler[fila + 1][columna + 2] = MOVIMENTS;

					} catch (ArrayIndexOutOfBoundsException e) {

					}
					try {
						if (Tauler[fila + 2][columna + 1] == BUIT)
							Tauler[fila + 2][columna + 1] = MOVIMENTS;

					} catch (ArrayIndexOutOfBoundsException e) {

					}
					break;

				// MOVIMENTS DEL PEÓ -------------------------------------
				case 'P':
					if (fila == 8) {
						if (fila - 2 >= 1) {
							if (Tauler[fila - 2][columna] == BUIT) {
								Tauler[fila - 2][columna] = MOVIMENTS;

							}
							if (fila - 1 >= 1) {
								if (Tauler[fila - 1][columna] == BUIT) {
									Tauler[fila - 1][columna] = MOVIMENTS;
								}
							}

						}

					} else {
						if (Tauler[fila - 1][columna] == BUIT) {
							Tauler[fila - 1][columna] = MOVIMENTS;
						}

					}

				}
				break;
			case 3:
				System.out.println();
				System.out.println("-------------------------");
				System.out.println("¡¡¡MOVIMENTS ESBORRATS!!!");
				System.out.println("-------------------------");
				for (int i = 1; i <= qFiles; i++) {
					for (int j = 1; j <= qFiles; j++) {
						if (Tauler[i][j] == MOVIMENTS) {
							Tauler[i][j] = BUIT;
						}
					}
				}
				break;

			case 4:
				System.out.println(" ");
				System.out.println("---------------------------------");
				System.out.println("¡¡¡PECES I MOVIMENTS ESBORRATS!!!");
				System.out.println("---------------------------------");
				for (int i = 1; i <= qFiles; i++) {
					for (int j = 1; j <= qColumnes; j++) {
						Tauler[i][j] = BUIT;
					}
				}
				break;
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
