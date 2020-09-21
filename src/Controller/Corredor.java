package Controller;

import java.util.concurrent.Semaphore;

public class Corredor extends Thread {
	
	int idPessoas;
	private static int posChegada;
	private static int posSaida;
	private Semaphore semaforo;
	
	public Corredor(int idPessoas, Semaphore semaforo) {
		this.idPessoas = idPessoas;
		this.semaforo = semaforo;
		
	}
	
	@Override
	public void run() {
		pessoasAndando();
		try {
			semaforo.acquire();	
			chegouPorta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();	
			cruzouPorta();
		}
	}	
	
	private void pessoasAndando() {
		int distTotal = 200;
		int distPercorrida = 0;
		int deslocamento = (int) ((Math.random() * 2) + 4);;
		int tempo = 1000;
		while (distPercorrida < distTotal) {
			distPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("#" + idPessoas + " já andou " + distPercorrida + "m.");
		}
		posChegada++;		
	}	
	
	private void chegouPorta() {
		System.out.println("#" + idPessoas +" " + posChegada+ "o. a chegar ");
		int tempo = (int) ((Math.random() * 1001) + 1000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
	private void cruzouPorta() {		
		posSaida++;
		System.out.println("#" + idPessoas +" "+ posSaida+"o. a abrir e Cruzar a Porta");
	}

	
}
