/*
 * Juego de Batallas 1vs1 de Pokemon
 * Por Ish Milan
 * V1.1
 */


public class batalla1vs1 {

	public static void main(String[] args) {
		Pokemon p1=new Pokemon();
		Pokemon p2=new Pokemon();
		p1.setTipo();
		p1.setNombre();
		p1.setAtaques();
		System.out.println(p1.getN()+" es de tipo "+p1.getTipo());
		p1.printStatus();
		p2.setTipo();
		p2.setNombre();
		p2.setAtaques();
		System.out.println(p2.getN()+" es de tipo "+p2.getTipo());
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
			System.out.print(p2.getN());
		}else{
			System.out.print(p1.getN());
		}
		
	}

}
