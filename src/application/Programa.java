package application;

import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class Programa {
	
	 public static void main(String[] args) {
		 
		 
		 Scanner sc = new Scanner(System.in);
		 PartidaXadrez partidaXadrez = new PartidaXadrez();
		 
		 while(true) {
		 	IU.printTabuleiro(partidaXadrez.getPecas());
		 	System.out.println();
		 	System.out.print("Origem: ");
		 	PosicaoXadrez origem = IU.lerPosicaoXadrez(sc);
		 	
		 	System.out.println();
		 	System.out.print("Alvo: ");
		 	PosicaoXadrez alvo = IU.lerPosicaoXadrez(sc);
		 	
		 	PecaXadrez pecaCapturada = partidaXadrez.executarMovimentoXadrez(origem, alvo);
		 }
		
	}
	 
}


