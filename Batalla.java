/*
 * Juego de Batallas 1vs1 de Pokemon
 * Por Ish Milan
 * V1.1
 */

import java.io.IOException;
import java.util.Scanner;

public class Batalla {
	public static Scanner sc= new Scanner(System.in);
	public void b1vs1(boolean cpu1,boolean cpu2) throws InterruptedException{
		main.printIntro();
		Pokemon p1=new Pokemon();
		Pokemon p2=new Pokemon();
		p1.setTipo(cpu1);
		p1.setNombre();
		p1.setAtaques();
		System.out.println(p1.nombre+" es de tipo "+p1.tipo);
		p1.printStatus();
		p2.setTipo(cpu2);
		p2.setNombre();
		p2.setAtaques();
		System.out.println(p2.nombre+" es de tipo "+p2.tipo);
		p2.printStatus();
		boolean victoria=false;
		while(victoria==false){
			if(p1.vida>=0){
				p2.perderV(p1.atacar(p2.tipo));
				p2.printStatus();
			}
			if(p2.vida>=0){
				p1.perderV(p2.atacar(p1.tipo));
				p1.printStatus();
			}
			if(p1.vida<=0 || p2.vida<=0) victoria=true;
		}
		System.out.print("\nVictoria para ");
		if (p1.vida<=0) {
			System.out.print(p2.nombre+" ¡Lo siento!");
		}else{
			System.out.print(p1.nombre+" ¡Enhorabuena!");
		}
	}
	public void b2vs2(boolean cpu1,boolean cpu2) throws InterruptedException{
		main.printIntro();
		Pokemon p1=new Pokemon();
		Pokemon p2=new Pokemon();
		Pokemon p3=new Pokemon();
		Pokemon p4=new Pokemon();
		p1.setTipo(cpu1);
		p1.setNombre();
		p1.setAtaques();
		p2.setTipo(cpu1);
		p2.setNombre();
		p2.setAtaques();
		System.out.println(p1.nombre+" es de tipo "+p1.tipo);
		p1.printStatus();
		System.out.println(p2.nombre+" es de tipo "+p2.tipo);
		p2.printStatus();
		p3.setTipo(cpu2);
		p3.setNombre();
		p3.setAtaques();
		p3.setTipo(cpu2);
		p3.setNombre();
		p3.setAtaques();
		System.out.println(p3.nombre+" es de tipo "+p3.tipo);
		p3.printStatus();
		System.out.println(p4.nombre+" es de tipo "+p4.tipo);
		p4.printStatus();/*
		boolean victoria=false;
		while(victoria==false){
			if(p1.vida>=0){
				p2.perderV(p1.atacar(p2.tipo));
				p2.printStatus();
			}
			if(p2.vida>=0){
				p1.perderV(p2.atacar(p1.tipo));
				p1.printStatus();
			}
			if(p1.vida<=0 || p2.vida<=0) victoria=true;
		}
		System.out.print("\nVictoria para ");
		if (p1.vida<=0) {
			System.out.print(p2.nombre+" ¡Lo siento!");
		}else{
			System.out.print(p1.nombre+" ¡Enhorabuena!");
		}*/
	}
	public void main() throws IOException, InterruptedException {
		String opc="1";
		do {
			
			System.out.print("\n¿Qué desea hacer?\n1)1vs1\t\t2)1vs1(CPU)\t3)1vs2(CPU)\t4)1vs1vs1"
					+ "\n5)2vs2\t\t6)2vs2(CPU)\t7)3vs3\t\t8)3vs3(CPU)\n\t\t\t  0)salir\n->");
		opc=sc.next().toLowerCase().substring(0, 1);
		switch (opc) {
			case "1": b1vs1(false,false);break;
			case "2": b1vs1(false,true);break;
			case "3": break;
			case "4": break;
			case "5": break;
			case "6": break;
			case "7": break;
			case "8": break;
			case "0": System.out.print("\033[H\033[2J"); break;
			default:
				System.out.print("Error al introducir opción. ");
				break;
		}
		System.out.println("Pulse intro para continuar");
		System.in.read();
		} while (opc.equals("0")==false);
	}

}
