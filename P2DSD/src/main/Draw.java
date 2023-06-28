package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Draw extends JFrame {

	private List<PoligonoRegular> regPoligonos;
	private boolean isTraslated = false;

	public void setTraslated(boolean isTraslated) {
		this.isTraslated = isTraslated;
	}

	public Draw(List<PoligonoRegular> regPoligonos) {
		this.regPoligonos = regPoligonos;
		setSize(1600, 1200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Panel p = new Panel();
		add(p);
	}

	public void limpiar() {
		this.regPoligonos = new ArrayList<PoligonoRegular>();
	}

	public void agregarElemento(PoligonoRegular poligono) {
		this.regPoligonos.add(poligono);
	}

	private class Panel extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			g.setColor(Color.red);

			for (PoligonoRegular poligonoRegular : regPoligonos) {
				Polygon poligono = new Polygon();

				if (!isTraslated) {
					for (Coordenada c : poligonoRegular.getVertices()) {
						poligono.addPoint((int) c.abcisa(), (int) c.ordenada());
					}
				} else {
					PoligonoRegular aux = new PoligonoRegular(7);
					int x = getWidth()/2;
					int y = getHeight()/2;
					int radio;
					double l = Math.sqrt(Math
							.pow(poligonoRegular.getVertices().get(0).x - poligonoRegular.getVertices().get(1).x, 2)
							+ Math.pow(
									poligonoRegular.getVertices().get(0).y - poligonoRegular.getVertices().get(1).y,
									2));
					if (poligonoRegular.getVertices().size() == 3) {
						
						radio = (int) (l * Math.sqrt(3));
						aux.anadeVertice(new Coordenada(x, y + (Math.sqrt(3) / 3) * l));
						aux.anadeVertice(new Coordenada(x - (l / 2), y - (Math.sqrt(3) / 6) * l));
						aux.anadeVertice(new Coordenada(x + (l / 2), y - (Math.sqrt(3) / 6) * l));
					} else {
						radio = (int) (l/2);
						if (poligonoRegular.getVertices().size() == 4) {
							aux.anadeVertice(new Coordenada(x + radio, y + radio));
							aux.anadeVertice(new Coordenada(x + radio, y - radio));
							aux.anadeVertice(new Coordenada(x - radio, y - radio));
							aux.anadeVertice(new Coordenada(x - radio, y + radio));
						} else {
							double[] thetas = new double[poligonoRegular.getVertices().size()];
							
							radio = (int)(l/(2*Math.sin(Math.PI/poligonoRegular.getVertices().size())));
							System.out.println("Radio2:"+radio);
							System.out.println("lado2:"+l);
							
							for (int i = 1; i <= thetas.length; i++) {
								thetas[i - 1] = (float) i / poligonoRegular.getVertices().size() * Math.PI * 2;
								aux.anadeVertice(new Coordenada(radio * Math.cos(thetas[i - 1]) + x,
										radio * Math.sin(thetas[i - 1]) + y));
							}
						}

					}
					for (Coordenada c : aux.getVertices()) {
						poligono.addPoint((int) c.abcisa(), (int) c.ordenada());
					}

				}

				g.drawPolygon(poligono);

			}

		}
	}
}
