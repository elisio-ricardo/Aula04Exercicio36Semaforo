package View;

import java.util.concurrent.Semaphore;

import Controller.Corredor;



public class PrincipalEx36Semaforos {

	public static void main(String[] args) {

			int permissoes = 1;
			Semaphore semaforo = new Semaphore(permissoes);
			
			for(int idPessoas = 0; idPessoas<4; idPessoas++) {
				Thread tPessoas = new Corredor(idPessoas, semaforo);
				tPessoas.start();
			}
	}

}
