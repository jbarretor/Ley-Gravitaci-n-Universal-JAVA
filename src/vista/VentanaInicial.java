package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;

import modelo.LeyGravitacional;

import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

public class VentanaInicial extends JFrame implements ActionListener, KeyListener{

	private JPanel contentPane;
	private JTextField txtM;
	private JTextField txtR;
//	private JTextField txtG;
	private JButton btnCalcular;
	private JPanel panel_planeta;
	private JLabel lblPlaneta;
	private JLabel lblNewLabel;
	private JTextField txtExp;
	
	private LeyGravitacional lG;
	private JLabel lable;
	private JLabel lable2;
	private JLabel lblPosicionEnOrbita;
	private JTextField txtPosicion;
	private JPanel panel_datos;
	private JLabel lblNombre;
	private JPanel panel_resultado;
	private JLabel lblGravedad;

	public VentanaInicial() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("../Ley Gravitacional/img/Solar System.jpg"));
		setBackground(Color.BLACK);
		setResizable(false);
		setTitle("Ley Gravitacional");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 315);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		panel_datos = new JPanel();
		panel_datos.setBackground(Color.BLACK);
		panel_datos.setBounds(12, 13, 546, 257);
		contentPane.add(panel_datos);
		panel_datos.setLayout(null);
		
		JLabel lblM = new JLabel("Masa del Planeta (kg)");
		lblM.setForeground(Color.WHITE);
		lblM.setBounds(12, 24, 190, 16);
		panel_datos.add(lblM);
		
		JLabel lblDistanciaEntreLos = new JLabel("Radio del Planeta (km)");
		lblDistanciaEntreLos.setForeground(Color.WHITE);
		lblDistanciaEntreLos.setBounds(298, 24, 201, 16);
		panel_datos.add(lblDistanciaEntreLos);
		
		JLabel lblConstanteDeGravitacion = new JLabel("Constante de Gravitacion Universal");
		lblConstanteDeGravitacion.setForeground(Color.WHITE);
		lblConstanteDeGravitacion.setBounds(298, 121, 201, 16);
		panel_datos.add(lblConstanteDeGravitacion);
		
		txtM = new JTextField();
		txtM.setBorder(null);
		txtM.setColumns(10);
		txtM.setBounds(12, 53, 92, 22);
		panel_datos.add(txtM);
		
		txtR = new JTextField();
		txtR.setBorder(null);
		txtR.setColumns(10);
		txtR.setBounds(298, 51, 225, 22);
		panel_datos.add(txtR);
		
		JTextField txtG = new JTextField();
		txtG.setForeground(Color.BLACK);
		txtG.setBorder(null);
		txtG.setText("6,67 x 10^-11");
		txtG.setBackground(Color.WHITE);
		txtG.setEditable(false);
		txtG.setColumns(10);
		txtG.setBounds(298, 150, 225, 22);
		panel_datos.add(txtG);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(187, 207, 155, 25);
		btnCalcular.addActionListener(this);
		
		txtPosicion = new JTextField();
		txtPosicion.setBorder(null);
		txtPosicion.setColumns(10);
		txtPosicion.setBounds(12, 150, 225, 22);
		panel_datos.add(txtPosicion);
		
		txtExp = new JTextField();
		txtExp.setBorder(null);
		txtExp.setBounds(155, 53, 82, 22);
		panel_datos.add(txtExp);
		txtExp.setColumns(10);
		panel_datos.add(btnCalcular);
		
		txtExp.addKeyListener(this);
		txtR.addKeyListener(this);
		txtM.addKeyListener(this);
		txtPosicion.addKeyListener(this);
		
		lblNewLabel = new JLabel("x 10^");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(116, 56, 41, 16);
		panel_datos.add(lblNewLabel);
		
		lblPosicionEnOrbita = new JLabel("Posicion en la que Orbita al Sist. Solar");
		lblPosicionEnOrbita.setForeground(Color.WHITE);
		lblPosicionEnOrbita.setBounds(12, 121, 225, 16);
		panel_datos.add(lblPosicionEnOrbita);
		
		JLabel lblDatos = new JLabel();
		lblDatos.setBounds(0, 0, 546, 257);
		panel_datos.add(lblDatos);
		
		cargarImagen(lblDatos, "../Ley Gravitacional/img/sistemasolar.gif/");
		
		panel_planeta = new JPanel();
		panel_planeta.setBackground(Color.BLACK);
		panel_planeta.setBorder(null);
		panel_planeta.setBounds(12, 283, 261, 261);
		contentPane.add(panel_planeta);
		panel_planeta.setLayout(new BorderLayout(0, 0));
		
		lblPlaneta = new JLabel("");
		lblPlaneta.setHorizontalAlignment(SwingConstants.CENTER);
		panel_planeta.add(lblPlaneta);
		
		panel_resultado = new JPanel();
		panel_resultado.setBackground(Color.BLACK);
		panel_resultado.setBounds(285, 283, 273, 261);
		contentPane.add(panel_resultado);
		panel_resultado.setLayout(null);
		
		lable = new JLabel("El Planeta es: ");
		lable.setForeground(Color.WHITE);
		lable.setVerticalAlignment(SwingConstants.TOP);
		lable.setFont(new Font("Tahoma", Font.BOLD, 22));
		lable.setBounds(12, 40, 249, 36);
		panel_resultado.add(lable);
		
		lable2 = new JLabel("Su Gravedad es de: ");
		lable2.setForeground(Color.WHITE);
		lable2.setVerticalAlignment(SwingConstants.TOP);
		lable2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lable2.setBounds(12, 152, 249, 36);
		panel_resultado.add(lable2);
		
		lblNombre = new JLabel("");
		lblNombre.setVerticalAlignment(SwingConstants.TOP);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNombre.setBounds(12, 87, 249, 36);
		panel_resultado.add(lblNombre);
		
		lblGravedad = new JLabel("");
		lblGravedad.setVerticalAlignment(SwingConstants.TOP);
		lblGravedad.setForeground(Color.WHITE);
		lblGravedad.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblGravedad.setBounds(12, 194, 249, 36);
		panel_resultado.add(lblGravedad);
	}
	
	private void cargarImagen(JLabel lable, String img) {
		File fichero = new File(img);
		
		ImageIcon icon = new ImageIcon(fichero.getAbsolutePath());

		Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lable.getWidth(), lable.getHeight(), Image.SCALE_DEFAULT));

		lable.setText(null);

		lable.setIcon(icono);		
	}
	
	private void cacular() {
		if (!txtM.getText().toString().equals("") && !txtR.getText().toString().equals("") && !txtExp.getText().toString().equals("") && !txtPosicion.getText().toString().equals("")) {
			setBounds(100, 100, 588, 604);
			setLocationRelativeTo(null);
			lG = new LeyGravitacional(txtM.getText().toString(), txtR.getText().toString(), txtExp.getText().toString());
			lblGravedad.setText(String.valueOf(lG.gravedad()));
			lblNombre.setText(lG.planeta(txtPosicion.getText().toString()));
			cargarImagen(lblPlaneta, lG.img(txtPosicion.getText().toString()));
		} else {
			JOptionPane.showMessageDialog(this, "No pueden existir campos vacios", "Campo(s) Vacio(s)", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		cacular();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getSource().equals(txtM) || e.getSource().equals(txtR) || e.getSource().equals(txtExp) || e.getSource().equals(txtPosicion)) {
			char enter = e.getKeyChar();
			if (enter == '\n') {
				cacular();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getSource().equals(txtM)) {
			char caracter = e.getKeyChar();
			if ((caracter < '0' || caracter > '9') && (caracter != '.')) {
				e.consume();
			}
		} else if (e.getSource().equals(txtR) || e.getSource().equals(txtExp)) {
			char caracter = e.getKeyChar();
			if ((caracter < '0' || caracter > '9')) {
				e.consume();
			}
		} else if (e.getSource().equals(txtPosicion)) {
			char caracter = e.getKeyChar();
			if ((caracter < '0' || caracter > '8')) {
				e.consume();
			}
		}
	}
}
