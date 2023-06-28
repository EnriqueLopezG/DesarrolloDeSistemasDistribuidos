package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JComponent;

public class Main {

	public static void main(String[] args) throws Exception {
		
		args[0]="4";
		
		List<PoligonoRegular> l1 = new ArrayList<PoligonoRegular>();
		for (int i = 0; i < Integer.valueOf(args[0]); i++) {
			int nLados = (int) (Math.random() * (3 - 10 + 1) + 10);
			PoligonoRegular poligono = new PoligonoRegular(nLados);
			l1.add(poligono);

		}

		Draw draw = new Draw(l1);
		draw.setVisible(true);
		
		Thread.sleep(3000);

		draw.limpiar();
		draw.repaint();

		draw.setTraslated(true);
		List<PoligonoRegular> aux1 = new ArrayList<PoligonoRegular>();

		Collections.sort(l1, new PoligonoIrreg());
		for (int i = 0; i < l1.size(); i++) {
			draw.limpiar();
			for (int j = 0; j <= i; j++) {
				draw.agregarElemento(l1.get(j));
			}
			draw.repaint();
			aux1 = new ArrayList<PoligonoRegular>();
			Thread.sleep(2000);

		}
	}
}
