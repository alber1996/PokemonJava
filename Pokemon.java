/*
 * Clase generadora de Pokemon
 * Por Ish Milan
 * V1.7
 */


import java.util.Scanner;

public class Pokemon {
	private Scanner sc = new Scanner(System.in);
//ATRIBUTOS:
	public String nombre;
	public String tipo;
	public double vida=Math.random()*100+150;
	public double vidaPerdida=0;
	public double ataque;
	public String mov1;
	public String mov2;
	public String mov3;
	public int pp1=6;
	public boolean cpu=false;
//METODOS:
	public void setTipo(boolean b){//El usuario define el tipo para el pokemon
		String t;
		if (b==true) {
			cpu=true;
		}
		if (cpu==false) {
			System.out.print("Tipo: \n  P(planta)\tF(fuego) \n  A(agua)\tL(lucha) \n  E(eléctrico)\tN(normal)\nSeleccione el tipo deseado: ");
			t=sc.next().toLowerCase().substring(0, 1);
		} else {
			String[] genTi ={"p","f","a","l","e","n"};
			t=genTi[(int)(Math.random()*6)];
		}
		switch (t) {
			case "p": tipo="planta"; break;
			case "f": tipo="fuego"; break;
			case "a": tipo="agua"; break;
			case "l": tipo="lucha"; break;
			case "e": tipo="eléctrico"; break;
			default: tipo="normal"; break;
		}
	}
	public void setNombre(){//Genera el nombre del pokemon de un array(6x6) a partir del tipo elegido
		String[][] nombres = {{"Emboar","Magmortar","Charizard","Typlosion","Blaziken","Flareon"},//FUEGO
		{"Giaragos","Kyogre","Blastoise","Lapras","Feraligart","Vaporeon"},//AGUA
		{"Torterra","Venusaur","Serpentrior","Cacturne","Celebi","Meganium"},//PLANTA
		{"Snorlak","Raticate","Slowking","Porygon","Linoone","Pidgey"},//NORMAL
		{"HitmonLee","HitmonChan","Machamp","Lucario","Throh","Sawk"},//LUCHA
		{"Pikachu","Jolteon","Pluse","Minun","Electabuzz","Zapdos"}};//ELECTRICO
		switch (tipo){
			case "fuego": nombre=nombres[0][(int)(Math.random()*6)];break;
			case "agua": nombre=nombres[1][(int)(Math.random()*6)];break;
			case "planta": nombre=nombres[2][(int)(Math.random()*6)];break;
			case "lucha": nombre=nombres[4][(int)(Math.random()*6)];break;
			case "eléctrico": nombre=nombres[5][(int)(Math.random()*6)];break;
			default: nombre=nombres[3][(int)(Math.random()*6)];break;
		}
	}
	public void setAtaques(){//Genera los ataques del pokemon de un array(6x6) a partir del tipo elegido
		String[][] movimientos = {{"Colmillo ígneo","Ascuas","Llamarada","Lanzallamas","Giro fuego","Puño fuego"},//FUEGO
		{"Rayo burbuja","Burbuja","Surf","Hidrobomba","Pistola agua","Salpicadura"},//AGUA
		{"Megaagotar","Látigo cepa","Llueve hojas","Tormenta floral","Hoja afilada","Danza pétalo"},//PLANTA
		{"Doble bofetón","Ataque furia","Destructor","Alboroto","Placaje","Arañazo"},//NORMAL
		{"Demolición","Golpe alto","Golpe karate","Puño certero","Patada baja","Patada salto"},//LUCHA
		{"Impactrueno","Rayo","Trueno","Colmillo rayo","Chispa","Puño trueno"}};//ELECTRICO
		int random=(int)(Math.random()*3+1);
		int t;
		switch (tipo) {
			case "fuego": t=0;break;
			case "agua": t=1;break;
			case "planta": t=2;break;
			case "lucha": t=4;break;
			case "eléctrico": t=5;break;
			default: t=3;break;
		}
		mov1=movimientos[t][0];
		mov2=movimientos[t][random];
		mov3=movimientos[t][random+2];
	}
	public double perderV(double at){//Pierde tantos puntos de vida como se le pasen como parametro
		vida-=at;
		vidaPerdida+=at;
		return vida;
	}
	public void printStatus(){//Imprime los puntos de vida del pokemon
		System.out.printf("\n%s tiene %.2f puntos de vida.\n\n",this.nombre,this.vida);
	}
	public double atacar(String tipEn){//Realiza la acción de atacar generando el daño del ataque
		int m;
		if (cpu==false) {
			System.out.println(this.nombre+":\n(1)"+this.mov1+"\t(2)"+this.mov2+"\t(3)"+this.mov3);
			m = sc.nextInt();
		} else {
			m=(int)(Math.random()*2+1);
		}
		String mov;
		if (m==1){
			mov=mov1;
		}else{
			if (m==2) {
				mov=mov2;				
			}else{
				mov=mov3;
			}
		}
		if (mov=="Megaagotar"){
			ataque=Math.random()*25+10;
			double rec=Math.random()*10+10;
			if (rec<=vidaPerdida){
				vida+=rec;
				vidaPerdida-=rec;
			}else{
				rec=vidaPerdida;
				vidaPerdida=0;
			}
			printStatus();
		}else{
			if (tipo.equals("fuego")&&tipEn.equals("planta") ||
				tipo.equals("agua")&&tipEn.equals("fuego")||
				tipo.equals("planta")&&tipEn.equals("agua")||
				tipo.equals("lucha")&&tipEn.equals("normal")||
				tipo.equals("eléctrico")&&tipEn.equals("agua")) {
						ataque=Math.random()*60+10;
			}else{
				if (tipo.equals("planta")&&tipEn.equals("fuego") ||
					tipo.equals("fuego")&&tipEn.equals("agua")||
					tipo.equals("agua")&&tipEn.equals("planta")||
					tipo.equals("lucha")&&tipEn.equals("lucha")) {
								ataque=Math.random()*20+5;
				}else{
					ataque=Math.random()*40+10;
				}
			}
		}
		System.out.printf("\n%s ha usado %s que inflinge %.2f de daño.",this.nombre,mov,this.ataque);
		return ataque;
	}

}
