package controller;

import java.util.concurrent.Semaphore;

public class ThreadsServidorSemaforo extends Thread {

	private int id;
	private Semaphore semaforo;
	private static int posicao;

	public ThreadsServidorSemaforo(int idcarro, Semaphore permissao) {
		id = idcarro;
		semaforo = permissao;
	}

	@Override
	public void run() {
		Solicitacao(id);

	}

	private void Solicitacao(int id) {
		if (id % 3 == 1) {
			for (int i = 0; i < 2; i++) {
				Calculos(id);
				System.out.println("Calculo do #" +id + "Terminou ");
				try {
					semaforo.acquire();
					Tranzacao(id);
					System.out.println("Tranzação do #" +id + "Terminou ");
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					semaforo.release();
				}
			}
			posicao++;
			System.out.println("Solicitação do #" +id+ " Terminou em " +posicao +"°");
		} else if (id % 3 == 2) {
			for (int i = 0; i < 3; i++) {
				Calculos(id);
				System.out.println("Calculo do #" +id + "Terminou ");
				try {
					semaforo.acquire();
					Tranzacao(id);
					System.out.println("Tranzação do #" +id + "Terminou ");
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					semaforo.release();
				}
			}
			posicao++;
			System.out.println("Solicitação do #" +id+ " Terminou em " +posicao +"°");
		} else if (id % 3 == 0) {
			for (int i = 0; i < 2; i++) {
				Calculos(id);
				System.out.println("Calculo do #" +id + "Terminou ");
				try {
					semaforo.acquire();
					Tranzacao(id);
					System.out.println("Tranzação do #" +id + "Terminou ");
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					semaforo.release();
				}
			}
			posicao++;
			System.out.println("Solicitação do #" +id+ " Terminou em " +posicao +"°");
		}
	}

	private void Calculos(int id) {
		if (id % 3 == 1) {
			int tempo = (int) Math.random() * 1001 + 200;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if (id % 3 == 2) {
			int tempo = (int) Math.random() * 1501 + 500;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if (id % 3 == 0) {
			int tempo = (int) Math.random() * 2001 + 1000;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void Tranzacao(int id) {
		if (id % 3 == 1) {
			int tempo = 1000;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if (id % 3 == 2) {
			int tempo = 1500;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if (id % 3 == 0) {
			int tempo = 1500;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
