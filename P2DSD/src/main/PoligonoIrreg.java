package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PoligonoIrreg implements Comparator<PoligonoRegular> {
	private List<Coordenada> vertices;

	public PoligonoIrreg() {

		vertices = new ArrayList<Coordenada>();
	}

	public void anadeVertice(Coordenada c) {
		vertices.add(c);
	}

	public void imprimeVertices() {
		for (Coordenada coordenada : vertices) {
			System.out.println("V:" + coordenada.toString());
		}
	}

	public List<Coordenada> getVertices() {
		return vertices;
	}

	@Override
	public int compare(PoligonoRegular o1, PoligonoRegular o2) {
		// TODO Auto-generated method stub
		return (int) (o1.obtieneArea() - o2.obtieneArea());
	}

	@Override
	public String toString() {
		return "PoligonoIrreg [vertices=" + vertices + "]";
	}

}
