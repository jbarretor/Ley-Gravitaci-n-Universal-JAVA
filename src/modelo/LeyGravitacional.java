package modelo;

public class LeyGravitacional {
	
	private static final double G = (6.67 * Math.pow(10, -11));
	private double m, r, exponente;
	
	
	public LeyGravitacional(String m, String r, String exponente) {
		this.m = Double.parseDouble(m)*1000;
		this.r = Double.parseDouble(r);
		this.exponente = Double.parseDouble(exponente);
	}

	public double gravedad() {
		return G * ((m * Math.pow(10, exponente))/Math.pow(r, 2));
	}
	
	public String planeta(String posicion) {
		String nombre = "";
		int pos = Integer.parseInt(posicion);
		switch (pos) {
		case 0:
			nombre = "Sol";
			break;
		case 1:
			nombre = "Mercurio";
			break;
		case 2:
			nombre = "Venus";
			break;
		case 3:
			nombre = "Tierra";
			break;
		case 31:
			nombre = "Luna";
			break;
		case 4:
			nombre = "Marte";
			break;
		case 5:
			nombre = "Jupiter";
			break;
		case 6:
			nombre = "Saturno";
			break;
		case 7:
			nombre = "Urano";
			break;
		case 8:
			nombre = "Neptuno";
			break;
		default:
			nombre = "Desconocido";
			break;
		}
		return nombre;
	}
	
	public String img(String posicion) {
		String dir = "";
		int pos = Integer.parseInt(posicion);
		switch (pos) {
		case 0:
			dir = "../Ley Gravitacional/img/sol.gif";
			break;
		case 1:
			dir = "../Ley Gravitacional/img/mercurio.gif";
			break;
		case 2:
			dir = "../Ley Gravitacional/img/venus.gif";
			break;
		case 3:
			dir = "../Ley Gravitacional/img/tierra.gif";
			break;
		case 31:
			dir = "../Ley Gravitacional/img/luna.gif";
			break;
		case 4:
			dir = "../Ley Gravitacional/img/marte.gif";
			break;
		case 5:
			dir = "../Ley Gravitacional/img/jupiter.gif";
			break;
		case 6:
			dir = "../Ley Gravitacional/img/saturno.gif";
			break;
		case 7:
			dir = "../Ley Gravitacional/img/urano.gif";
			break;
		case 8:
			dir = "../Ley Gravitacional/img/neptuno.gif";
			break;
		default:
			dir = "../Ley Gravitacional/img/n.gif";
			break;
		}
		return dir;
	}
}
