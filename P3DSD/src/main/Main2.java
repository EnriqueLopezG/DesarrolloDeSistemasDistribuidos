package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Main2 {
	/**
	 * @param args
	 * @throws Exception
	 */
	/**
	 * @param args
	 * @throws Exception
	 */
	/**
	 * @param args
	 * @throws Exception
	 */
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		File curps = new File("curps.txt");

		if (!curps.exists()) {
			System.out.println("File does not exist");
		}

		while (true) {

			BufferedReader br = new BufferedReader(new FileReader(curps));
			String line;
			Map<String, Integer> hm = new HashMap<String, Integer>();
			int votes = 0;
			while ((line = br.readLine()) != null) {

				String lineArray[] = line.split(",");

				String option = lineArray[1];

				if (!hm.containsKey(option)) {
					hm.put(option, 1);
					votes++;
				} else {
					hm.put(option, hm.get(option) + 1);
					votes++;
				}

			}

			//int votes = 0;

			//System.out.println(hm.toString());

			/*for (Integer clave : hm.keySet()) {
				int valor = hm.get(clave);
				votes += valor;
			}*/
			 //System.out.println(votes);
			System.out.println("		0					50					100");
			System.out.println("		|					 |					 |");
			for (String clave : hm.keySet()) {
				int naste = hm.get(clave) * 82 / votes;

				System.out.print(clave + "		:		");
				for (int i = 0; i < naste; i++) {
					System.out.print("*");
				}

				System.out.println();
			}
			br.close();
			Thread.sleep(3000);
		}
	}
}