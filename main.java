import java.io.IOException;
import java.util.Scanner;

/*
 * Clase Principal:(Men� de modos de juego)
 * Por Ish Milan
 * V0.3
 */
public class main {
public static Scanner sc= new Scanner(System.in);
public static void main(String[] args) throws IOException {
	String opc = "1";
	do {
		System.out.print("\033[H\033[2J");
		System.out.println(
"                                     .::.\n"+
"                                   .;:**'\n"+
"                                   `\n"+
"  .:XHHHHk.            db.        .;;.     dH  MX\n"+
"oMMMMMMMMMMM          ~MM  dMMP :MMMMMR   MMM  MR       ~MRMN\n"+
"QMMMMMb  \"MMX          MMMMMMP !MX' :M~   MMM MMM  .oo.  XMMM 'MMM\n"+
"   `MMMM.  )M> :X!Hk.  MMMM    XMM.o\"  .  MMMMMMM X?XMMM  MMM>!MMP\n"+
"    'MMMb.dM! XM M'?M  MMMMMX.` MMMMMMMM~ MM MMM XM `\" MX  MMXXMM\n"+
"    ~MMMMM~   XMM. .XM XM`\"MMMb. ~*?**~ .MMX M t MMbooMM XXMMMMMP\n"+
"      ?MMM>   YMMMMMM! MM   `?MMRb.    `\"\"\"   !L\"MMMMM  XM IMMM\n"+
"       MMMX   \"MMMM\"   MM       ~%:           !Mh.\"\"\"  dMI IMMP\n"+
"       'MMM.                                               IMX\n"+
"       ~M!M                                               IMP\n\n\n\n");
	System.out.print("Bienvenido a PokemonJava.\n�Qu� desea hacer?\n1)batalla\t2)torneo\t3)hiatoria\t4)salir\n->");
	opc=sc.next().toLowerCase().substring(0, 1);
	batalla1vs1 b = new batalla1vs1(); 
	switch (opc) {
		case "1": b.main();break;
		case "2": break;
		case "3": break;
		case "4": break;
		default:
			System.out.println("Error al introducir opci�n. Pulse intro para continuar");
			System.in.read();
			break;
	}
	} while (opc.equals("4")==false);
	}

}
