package main;

public class PoligonoRegular extends PoligonoIrreg {

	private double angulo;
	private int numeroVertices;

	public PoligonoRegular(int numeroVertices) {
		this.numeroVertices = numeroVertices;

		int radio = (int) (Math.random() * (50 - 200 + 1) + 200);
		System.out.println("radio:" + radio);
		int x = (int) (Math.random() * (300 - 1450 + 1) + 1350);
		int y = (int) (Math.random() * (300 - 750 + 1) + 750);
		this.angulo = 360 / numeroVertices;
		if (numeroVertices == 3) {
			double l = radio * Math.sqrt(3);
			this.anadeVertice(new Coordenada(x, y + (Math.sqrt(3) / 3) * l));
			this.anadeVertice(new Coordenada(x - (l / 2), y - (Math.sqrt(3) / 6) * l));
			this.anadeVertice(new Coordenada(x + (l / 2), y - (Math.sqrt(3) / 6) * l));
		} else {
			if (numeroVertices == 4) {
				this.anadeVertice(new Coordenada(x + radio, y + radio));
				this.anadeVertice(new Coordenada(x + radio, y - radio));
				this.anadeVertice(new Coordenada(x - radio, y - radio));
				this.anadeVertice(new Coordenada(x - radio, y + radio));
			} else {
				double[] thetas = new double[numeroVertices];

				for (int i = 1; i <= thetas.length; i++) {
					thetas[i - 1] = (float) i / numeroVertices * Math.PI * 2;
					this.anadeVertice(
							new Coordenada(radio * Math.cos(thetas[i - 1]) + x, radio * Math.sin(thetas[i - 1]) + y));
				}
			}
		}
	}

	public double obtieneArea() {
		double area = 0;
		double l = Math.sqrt(Math.pow(this.getVertices().get(0).x - this.getVertices().get(1).x, 2)
				+ Math.pow(this.getVertices().get(0).y - this.getVertices().get(1).y, 2));
		System.out.println("lado:" + l);
		if (this.numeroVertices == 3) {
			area = (Math.sqrt(3) / 4) * (l * l);
			return area;
		} else {
			if (this.numeroVertices == 4) {
				area = l * l;
				return area;
			} else {

				area = (this.numeroVertices * (l * l)) / (4.0 * Math.tan((Math.PI / this.numeroVertices)));
				return area;
			}
		}
	}

	@Override
	public String toString() {
		return "PoligonoRegular [angulo=" + angulo + ", numeroVertices=" + numeroVertices + "]";
	}

}