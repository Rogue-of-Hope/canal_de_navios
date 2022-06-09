package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import controller.ControleNavio;

public class Principal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel painel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 5, 700, 720);
		setResizable(false);
		
		painel = new JPanel();
		
		setContentPane(painel);
		
		painel.setLayout(null);

		JLabel telaTitulo = new JLabel();
		telaTitulo.setBounds(0, 0, 700, 700);
		telaTitulo.setIcon(new ImageIcon("img/tela_de_titulo.png"));
		
		JButton btnIniciar = new JButton();
		btnIniciar.setBounds(160, 350, 410, 67);
		btnIniciar.setBackground(Color.white);
		
		JLabel nomeBotao = new JLabel();
		nomeBotao.setIcon(new ImageIcon("img/iniciar.png"));
		
		btnIniciar.add(nomeBotao);
		btnIniciar.setOpaque(false);
		btnIniciar.setBorderPainted(false);
		
		painel.add(btnIniciar);
		painel.add(telaTitulo);
		
		
		JLabel cancelaFechada1 = new JLabel();
		cancelaFechada1.setIcon(new ImageIcon("img/cancelas/fechadas/cancela_fechada1.png"));
		cancelaFechada1.setBounds(235, 185, 128, 43);
		
		painel.add(cancelaFechada1);
		
		JLabel cancelaFechada2 = new JLabel();
		cancelaFechada2.setIcon(new ImageIcon("img/cancelas/fechadas/cancela_fechada2.png"));
		cancelaFechada2.setBounds(495, 250, 43, 128);
		
		painel.add(cancelaFechada2);
		
		
		JLabel cancelaAberta1 = new JLabel();
		cancelaAberta1.setIcon(new ImageIcon("img/cancelas/abertas/cancela_aberta1.png"));
		cancelaAberta1.setBounds(215, 80, 43, 128);
		
		cancelaAberta1.setVisible(false);
		painel.add(cancelaAberta1);
		
		JLabel cancelaAberta2 = new JLabel();
		cancelaAberta2.setIcon(new ImageIcon("img/cancelas/abertas/cancela_aberta2.png"));
		cancelaAberta2.setBounds(515, 235, 128, 43);
		
		cancelaAberta2.setVisible(false);
		painel.add(cancelaAberta2);
		
		
		JLabel fundo = new JLabel();
		fundo.setBounds(0, 0, 700, 700);
		fundo.setIcon(new ImageIcon("img/oceano.png"));
		
		
		JLabel navio1 = new JLabel();
		navio1.setIcon(new ImageIcon("img/navios/navio1.png"));
		navio1.setBounds(283, 51, 91, 125);
		
		painel.add(navio1);
		
		JLabel navio2 = new JLabel();
		navio2.setIcon(new ImageIcon("img/navios/navio2.png"));
		navio2.setBounds(561, 272, 115, 91);
		
		painel.add(navio2);

		painel.add(fundo);
		
		ControleNavio cc = new ControleNavio(navio1, navio2,
				cancelaFechada1, cancelaFechada2,
				cancelaAberta1, cancelaAberta2,
				telaTitulo, btnIniciar);
		
		btnIniciar.addActionListener(cc);
		
	}

}