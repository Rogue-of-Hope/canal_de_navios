package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ControleNavio implements ActionListener{
	private JLabel navio1, navio2;
	private JLabel cancelaFechada1, cancelaFechada2;
	private JLabel cancelaAberta1, cancelaAberta2;
	private JLabel telaTitulo;
	private JButton btnIniciar;
	
	private Semaphore semaforo = new Semaphore(1);
	
	public ControleNavio(JLabel navio1, JLabel navio2,
			JLabel cancelaFechada1, JLabel cancelaFechada2, 
			JLabel cancelaAberta1, JLabel cancelaAberta2,
			JLabel telaTitulo, JButton btnIniciar) {
		
		this.navio1 = navio1;
		this.navio2 = navio2;
		
		this.cancelaFechada1 = cancelaFechada1;
		this.cancelaFechada2 = cancelaFechada2;
		
		this.cancelaAberta1 = cancelaAberta1;
		this.cancelaAberta2 = cancelaAberta2;
		
		this.telaTitulo = telaTitulo;
		this.btnIniciar = btnIniciar;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		telaTitulo.setVisible(false);
		btnIniciar.setVisible(false);
		
		ThreadSemaforo ts1 = new ThreadSemaforo(navio1, cancelaFechada1, cancelaAberta1,
				semaforo, telaTitulo, btnIniciar, 1);
		
		ThreadSemaforo ts2 = new ThreadSemaforo(navio2, cancelaFechada2, cancelaAberta2,
				semaforo, telaTitulo, btnIniciar, 2);
		
		ts1.start();
		ts2.start();
	}
	
}