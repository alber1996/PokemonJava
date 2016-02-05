/*
 * Clase generadora de Pokemon
 * Por Ish Milan
 * V1.5
 */


import java.util.Scanner;

public class Pokemon {
	private Scanner sc = new Scanner(System.in);
	private String nombre;
	public String tipo;
	public double vida=Math.random()*100+100;
	public double ataque;
	public String mov1;
	public String mov2;
	public String mov3;
	public void setTipo(){
		System.out.print("Tipo: \nP(planta) \nF(fuego) \nA(agua) \nN(normal)");
		System.out.print("Seleccione el tipo deseado: ");
		String t=sc.next().toLowerCase().substring(0, 1);
		switch (t) {
		case "p":
			tipo="planta";
			break;
		case "f":
			tipo="fuego";
			break;
		case "a":
			tipo="agua";
			break;
		case "n":
			tipo="normal";
			break;
		default:
			tipo="normal";
			break;
		}
	}
	public String getTipo(){
		return tipo;
	}
	public void setNombre(){
		String [][] tipos1 = new String[4][6];
		//Fuego
		tipos1[0][0]="Emboar";
		tipos1[0][1]="Magmortar";
		tipos1[0][2]="Charizard";
		tipos1[0][3]="Typlosion";
		tipos1[0][4]="Blaziken";
		tipos1[0][5]="Flareon";
		//Agua
		tipos1[1][0]="Giaragos";
		tipos1[1][1]="Kyogre";
		tipos1[1][2]="Blastoise";
		tipos1[1][3]="Lapras";
		tipos1[1][4]="Feraligart";
		tipos1[1][5]="Vaporeon";
		//Planta
		tipos1[2][0]="Torterra";
		tipos1[2][1]="Venusaur";
		tipos1[2][2]="Serpentrior";
		tipos1[2][3]="Cacturne";
		tipos1[2][4]="Celebi";
		tipos1[2][5]="Meganium";
		//Normal
		tipos1[3][0]="Snorlak";
		tipos1[3][1]="Raticate";
		tipos1[3][2]="Slowking";
		tipos1[3][3]="Porygon";
		tipos1[3][4]="Linoone";
		tipos1[3][5]="Pidgey";
		switch (tipo){
			case "fuego" : nombre= tipos1[0][(int)(Math.random()*6)];break;
			case "agua" : nombre= tipos1[1][(int)(Math.random()*6)];break;
			case "planta" : nombre= tipos1[2][(int)(Math.random()*6)];break;
			case "normal" : nombre= tipos1[3][(int)(Math.random()*6)];break;
		}
	}
	public String getN(){
		return nombre;
	}
	public void setAtaques(){
		String[][] movimientos = new String[4][5];
		//Fuego
		movimientos[0][0]="Ascuas";
		movimientos[0][1]="Llamarada";
		movimientos[0][2]="Lanzallamas";
		movimientos[0][3]="Colmillo Ígneo";
		movimientos[0][4]="Puño fuego";
		//Agua
		movimientos[1][0]="Rayo burbuja";
		movimientos[1][1]="Burbuja";
		movimientos[1][2]="Surf";
		movimientos[1][3]="Hidrobomba";
		movimientos[1][4]="Salpicadura";
		//Planta
		movimientos[2][0]="Megaagotar";
		movimientos[2][1]="Látigo cepa";
		movimientos[2][2]="Llueve hojas";
		movimientos[2][3]="Tormenta floral";
		movimientos[2][4]="Hoja afilada";
		//Normal
		movimientos[3][0]="Placaje";
		movimientos[3][1]="Destructor";
		movimientos[3][2]="Alboroto";
		movimientos[3][3]="Doble bofetón";
		movimientos[3][4]="Arañazo";
		int random=(int)(Math.random()*3+1);
		switch (tipo) {
		case "fuego":
			mov1=movimientos[0][0];
			mov2=movimientos[0][random];
			mov3=movimientos[0][random+1];break;
		case "agua":
			mov1=movimientos[1][0];
			mov2=movimientos[1][random];
			mov3=movimientos[1][random+1];break;
		case "planta":
			mov1=movimientos[2][0];
			mov2=movimientos[2][random];
			mov3=movimientos[2][random+1];break;
		default: 
			mov1=movimientos[3][0];
			mov2=movimientos[3][random];
			mov3=movimientos[3][random+1];break;
		}
		
	}
	public double perderV(double at){
		vida-=at;
		return vida;
	}
	public void printStatus(){
		System.out.printf("\n%s tiene %.2f puntos de vida.\n\n",this.nombre,this.vida);
	}
	public double atacar(String tipEn){
		System.out.println("Los ataques de "+this.nombre+" son :\n(1)"+this.mov1+"\t(2)"+this.mov2+"\t(3)"+this.mov3);
		int m = sc.nextInt();
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
			vida+=Math.random()*10+10;
			printStatus();
		}else{
			if (tipo.equals("fuego")&&tipEn.equals("planta") ||
				tipo.equals("agua")&&tipEn.equals("fuego")||
				tipo.equals("planta")&&tipEn.equals("agua")) {
						ataque=Math.random()*60+10;
			}else{
				if (tipo.equals("planta")&&tipEn.equals("fuego") ||
						tipo.equals("fuego")&&tipEn.equals("agua")||
						tipo.equals("agua")&&tipEn.equals("planta")) {
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
