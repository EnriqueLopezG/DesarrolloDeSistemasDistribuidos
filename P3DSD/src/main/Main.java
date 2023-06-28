package main;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws Exception {

		// int time1 =Integer.valueOf(args[0]);
		int n = 16;
		int options = 5;

		File curpsFile = new File("curps.txt");

		Map<Integer, String> politicP = getPoliticP();

		if (!curpsFile.exists()) {
			curpsFile.createNewFile();
		}
		while (true) {
			for (int i = 0; i < n; i++) {
				FileWriter fw = new FileWriter(curpsFile, true);
				int flag = 1;
				String curp = "";
				while (flag != 0) {
					curp = getCURP();
					
					int year = Integer.valueOf(curp.substring(4, 6));
					//System.out.println(curp.substring(4, 6));
					// System.out.println(year);
					if (year >= 0 && year < 5) {
						
						flag = 0;
					}
					if (year > 45 && year <= 99) {
						
						flag = 0;
					}

				}
				int numero = (int) (Math.random() * options + 1);
				// System.out.println(numero);

				fw.write(curp + "," + politicP.get(numero) + "\n");
				fw.close();

			}
			System.out.println("CURPS GENERADOS");
			Thread.sleep(1500);
			
		}

	}

	static Map<Integer, String> getPoliticP() {
		Map<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "PT");
		hm.put(2, "PRI");
		hm.put(3, "PAN");
		hm.put(4, "MORENA");
		hm.put(5, "MOV NAJ");

		return hm;
	}

	static String getCURP()

	{

		String Letra = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		String Numero = "0123456789";

		String Sexo = "HM";

		String Entidad[] = { "AS", "BC", "BS", "CC", "CS", "CH", "CL", "CM", "DF", "DG", "GT", "GR", "HG", "JC", "MC",
				"MN", "MS", "NT", "NL", "OC", "PL", "QT", "QR", "SP", "SL", "SR", "TC", "TL", "TS", "VZ", "YN", "ZS" };

		int indice;

		StringBuilder sb = new StringBuilder(18);

		for (int i = 1; i < 5; i++) {

			indice = (int) (Letra.length() * Math.random());

			sb.append(Letra.charAt(indice));

		}

		// cero a 5 del 2000
		// 43 - 99 1900;

		for (int i = 5; i < 11; i++) {

			indice = (int) (Numero.length() * Math.random());

			sb.append(Numero.charAt(indice));

		}

		indice = (int) (Sexo.length() * Math.random());

		sb.append(Sexo.charAt(indice));

		sb.append(Entidad[(int) (Math.random() * 32)]);

		for (int i = 14; i < 17; i++) {

			indice = (int) (Letra.length() * Math.random());

			sb.append(Letra.charAt(indice));

		}

		for (int i = 17; i < 19; i++) {

			indice = (int) (Numero.length() * Math.random());

			sb.append(Numero.charAt(indice));

		}

		return sb.toString();

	}
}
