package controller;

import java.awt.Rectangle;
import java.util.Random;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JLabel;


public class ThreadSemaforo extends Thread{
	private JLabel navio, cancelaFechada, cancelaAberta;
	private JLabel telaTitulo;
	private JButton btnIniciar;
	private int op;
	private static int aux;
	
	private Semaphore semaforo;
	
	public ThreadSemaforo(JLabel navio, JLabel cancelaFechada, JLabel cancelaAberta,
			Semaphore semaforo, JLabel telaTitulo, JButton btnIniciar, int op) {
		
		this.navio = navio;
		this.cancelaFechada = cancelaFechada;
		this.cancelaAberta = cancelaAberta;
		this.semaforo = semaforo;
		this.telaTitulo = telaTitulo;
		this.btnIniciar = btnIniciar;
		this.op = op;
		
	}
	
	public void run() {
		executa();
		if(aux == 2) {
		telaTitulo.setVisible(true);
		btnIniciar.setVisible(true);
		aux = 0;
		}
	}
	
	public void executa() {
		try {

			semaforo.acquire();
			acionanavio();
			
		}  catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			semaforo.release();
		}
		aux ++;
	}
	
	public void acionanavio() {
		Rectangle posicao;
		posicao = navio.getBounds();
		int aux = 0;
		Random random = new Random();
		
		switch(op){
			case 1:
				cancelaFechada.setVisible(false);
				cancelaAberta.setVisible(true);
				while(aux<2) {
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						// TODO: handle exception
					}
					if(aux == 1) {
						posicao.y = (posicao.y)+(random.nextInt(2));
						if(posicao.y >= 46) {
							aux = 2;
						}
					}
					posicao.y = (posicao.y)+(random.nextInt(5));
					navio.setBounds(posicao);
					if(posicao.y >= 800) {
						posicao.y = -100;
						aux = 1;
					}
					
				}
				
				cancelaFechada.setVisible(true);
				cancelaAberta.setVisible(false);
				
				break;
			case 2:
				cancelaFechada.setVisible(false);
				cancelaAberta.setVisible(true);
				
				while(aux<2) {
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						// TODO: handle exception
					}
					if(aux == 1) {
						posicao.x = (posicao.x)-(random.nextInt(2));
						if(posicao.x <= 560) {
							aux = 2;
						}
					}
					posicao.x = (posicao.x)-(random.nextInt(5));
					navio.setBounds(posicao);
					if(posicao.x <= -100) {
						posicao.x = 800;
						aux = 1;
					}
					
				}
				
				cancelaFechada.setVisible(true);
				cancelaAberta.setVisible(false);
				
				break;
		}
	}
}