/*
 * Juego de Batallas 1vs2 CPU de Pokemon
 * Por Enrique Bonilla
 * V1.0
 */
import java.util.Scanner;

public class batalla1vs2CPU {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean victoria=false;
		int ataque=0;
		System.out.println("Vas a luchar contra dos pokémon");
		
		Pokemon p1 = new Pokemon();
		Pokemon p2 = new Pokemon();
		Pokemon p3 = new Pokemon();
		
		p1.setTipo();
		p1.setNombre();
		p1.setAtaques();
		p1.caracteristicas();
		
		p2.setTipoRandom((int)(Math.random()*4));
		p2.setNombre();
		p2.setAtaques();
		
		p3.setTipoRandom((int)(Math.random()*4));
		p3.setNombre();
		p3.setAtaques();
 
		System.out.println("¡Estás luchando contra! "+p2.nombre+" y "+p3.nombre);
		do{
		if(p1.vida>0){
		System.out.println("¿A cuál vas a atacar?");
		if(p2.vida>0){
		System.out.println("1. "+p2.nombre);}
		if(p3.vida>0){
		System.out.println("2. "+p3.nombre);}
		ataque = scan.nextInt();
		p1.atacar(p1.tipo);
		if (ataque==1) {
			System.out.println("\nVida de "+p2.nombre+" = "+p2.perderV(p1.ataque));
		}else{
			System.out.println("\nVida de "+p3.nombre+" = "+p3.perderV(p1.ataque));
			}
		}
		if(p2.vida>0){
		System.out.println("\nAtaque de "+p2.nombre);
		ataque=(int)(Math.random()*2+1);
		p2.atacarRandom(p2.tipo);
		if (ataque==1) {
			System.out.println("Vida de "+p1.nombre+" = "+p1.perderV(p2.ataque));
		}else{
			System.out.println("Vida de "+p3.nombre+" = "+p3.perderV(p2.ataque));
			}
		}
		if(p3.vida>0){
		System.out.println("\nAtaque de "+p3.nombre);
		p3.atacarRandom(p3.tipo);
		ataque=(int)(Math.random()*2+1);
		if (ataque==1) {
			System.out.println("Vida de "+p1.nombre+" = "+p1.perderV(p3.ataque));
		}else{
			System.out.println("Vida de "+p2.nombre+" = "+p2.perderV(p3.ataque));
			}
		}
		//Condiciones para ver si salimos del bucle teniendo un ganador o no
		if (p1.vida>0 && p2.vida<=0 && p3.vida<=0 || p1.vida<=0 && p2.vida>0 && p3.vida<=0 || p1.vida<=0 && p2.vida<=0 && p3.vida>0 ) {
			victoria=true;
		}
		
		}while(victoria==false);
		if(p1.vida>0){
			System.out.println("¡Enhorabuena, has ganado!");
		}else{
			System.out.println("Siento que hayas perdido, esos dos se han cebado contra tí...");
		}
		scan.close();
	}

}
