package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

	public static void main(String[] args) throws Exception {

		List<PoligonoRegular> l1 = new ArrayList<PoligonoRegular>();

		PoligonoRegular r1 = new PoligonoRegular(3);
		l1.add(r1);

		PoligonoRegular r2 = new PoligonoRegular(4);
		l1.add(r2);

		PoligonoRegular r3 = new PoligonoRegular(5);
		l1.add(r3);

		PoligonoRegular r4 = new PoligonoRegular(10);
		l1.add(r4);

		Collections.sort(l1, new PoligonoIrreg());
/*
		Draw draw = new Draw(l1);
		draw.setVisible(true);


		Thread.sleep(3000);

		draw.limpiar();
		draw.repaint();
		
		draw.setTraslated(true);
		List<PoligonoRegular> aux1 = new ArrayList<PoligonoRegular>();
		
		for (int i = 0; i < l1.size(); i++) {
			draw.limpiar();
			for (int j = 0; j <= i; j++) {
				draw.agregarElemento(l1.get(j));
			}
			draw.repaint();
			aux1 = new ArrayList<PoligonoRegular>();
			Thread.sleep(2000);

		}
		*/
		for (PoligonoRegular poligonoRegular : l1) {
			System.out.println(poligonoRegular.toString());
			System.out.println("area: "+poligonoRegular.obtieneArea());
			
		}

	}
}
