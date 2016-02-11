import java.io.IOException;
import java.util.Scanner;

/*
 * Clase Principal:(Menú de modos de juego)
 * Por Ish Milan
 * V0.3
 */
public class main {
public static Scanner sc= new Scanner(System.in);
public static void printIntro() throws InterruptedException{
	System.out.print("\033[H\033[2J");//NO BORRAR: En eclipse no limpia la pantalla, en la consola sí 
	System.out.flush();
	Thread.sleep(200);
	System.err.println("\n"+
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
"       ~M!M                       JAVA                    IMP\n\n\n\n");
	Thread.sleep(200);
}
public static void main(String[] args) throws IOException, InterruptedException {
	String opc = "1";
	do {
	printIntro();
	System.out.print("Bienvenido a PokemonJava.\n¿Qué desea hacer?\n1)batalla\t2)torneo\t3)historia\t4)salir\n->");
	opc=sc.next().toLowerCase().substring(0, 1);
	Batalla b = new Batalla(); 
	switch (opc) {
		case "1": b.main();break;
		case "2": break;
		case "3": break;
		case "4": break;
		default:
			System.out.println("Error al introducir opción. Pulse intro para continuar");
			System.in.read();
			break;
	}
	} while (opc.equals("4")==false);
	}

}
