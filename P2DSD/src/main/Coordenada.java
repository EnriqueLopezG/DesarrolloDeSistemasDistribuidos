package main;

import java.text.DecimalFormat;

public class Coordenada {

	DecimalFormat format1 = new DecimalFormat("0.00");
	double x, y;
	int magnitud;

	public Coordenada(double x, double y) {

		this.x = x;

		this.y = y;

		magnitud = (int) Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));

	}

	public double abcisa() {
		return x;
	}

	public double ordenada() {
		return y;
	}

	public double getMagnitud() {
		return magnitud;
	}

	@Override

	public String toString() {

		return "(" + format1.format(x) + "," + format1.format(y) + "):" + format1.format(magnitud);

	}

}