package view;

import java.util.concurrent.Semaphore;

import controller.ThreadsServidorSemaforo;

public class Main {

	public static void main(String[] args) {
			int permissao = 3;
			Semaphore semaforo = new Semaphore(permissao);
			
			for ( int i = 0; i < 21; i++) {
				ThreadsServidorSemaforo m = new ThreadsServidorSemaforo(i, semaforo);
				m.start();
			}
			
		
		
		
	}

}
