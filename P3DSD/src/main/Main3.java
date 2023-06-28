package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) throws Exception {

		File curps = new File("curps.txt");
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new FileReader(curps));
		String line;
		Map<String, Map<String, Integer>> hm;

		if (!curps.exists()) {
			System.out.println("File does not exist");
		}

		int opcion = 1;

		while (opcion != 5) {
			System.out.println("*******ELIGE UNA OPCION*****");
			System.out.println("1.Votos totales por sexo");
			System.out.println("2.Votos por cada estado de la republica");
			System.out.println("3.Votos realizados por cuidadanos de x edad");
			System.out.println("4.Votos que van por cada partido");
			System.out.println("5.Salir");

			opcion = sc.nextInt();

			if (!(opcion > 5)) {
				switch (opcion) {
				case 1:
					br = new BufferedReader(new FileReader(curps));
					line = "";
					hm = getgenres();

					while ((line = br.readLine()) != null) {

						String lineArray[] = line.split(",");
						String curp = lineArray[0];
						Map<String, Integer> hmaux = new HashMap<String, Integer>();

						hmaux = hm.get(curp.charAt(10) + "");

						Iterator<Entry<String, Integer>> iter = hmaux.entrySet().iterator();
						Entry<String, Integer> entrada = iter.next();

						hmaux.put(entrada.getKey(), entrada.getValue() + 1);
						hm.put(curp.charAt(10) + "", hmaux);

					}

					for (Map<String, Integer> ob : hm.values()) {
						Iterator<Entry<String, Integer>> iter = ob.entrySet().iterator();
						Entry<String, Integer> entrada = iter.next();
						System.out.println("Votos de " + entrada.getKey() + ":" + entrada.getValue());
					}

					System.out.println("Presione enter para continuar...");
					sc.nextLine();
					sc.nextLine();

					break;

				case 2: // Botos por estado de la republica

					br = new BufferedReader(new FileReader(curps));
					line = "";
					hm = getStates();

					while ((line = br.readLine()) != null) {

						String lineArray[] = line.split(",");
						String curp = lineArray[0];

						//System.out.println(curp);

						Map<String, Integer> hmaux = new HashMap<String, Integer>();
						hmaux = hm.get(curp.substring(11, 13));

						Iterator<Entry<String, Integer>> iter = hmaux.entrySet().iterator();
						Entry<String, Integer> entrada = iter.next();

						hmaux.put(entrada.getKey(), entrada.getValue() + 1);
						hm.put(curp.charAt(10) + "", hmaux);

					}

					for (Map<String, Integer> ob : hm.values()) {
						Iterator<Entry<String, Integer>> iter = ob.entrySet().iterator();
						Entry<String, Integer> entrada = iter.next();
						System.out.println("Votos de " + entrada.getKey() + ":" + entrada.getValue());
					}
					System.out.println("Presione enter para continuar...");
					sc.nextLine();
					sc.nextLine();
					break;

				case 3: /// Votos a los partidos
					br = new BufferedReader(new FileReader(curps));
					line = "";
					int cont = 0;

					System.out.println("Ingrese la edad que desea saber cuantos han votado");
					int ageaux = sc.nextInt();

					while ((line = br.readLine()) != null) {

						String lineArray[] = line.split(",");
						String curp = lineArray[0];
						int yearaux = Integer.valueOf(curp.substring(4, 6));
						int year = 0;

						if (yearaux >= 0 && yearaux < 5) {
							year = 2000 + yearaux;
						}

						if (yearaux > 45 && yearaux <= 99) {
							year = 1900 + yearaux;
						}

						LocalDate currentDate = LocalDate.now();

						LocalDate birthday = LocalDate.of(year, 1, 1);

						int age = Period.between(birthday, currentDate).getYears();

						if (age == ageaux) {
							cont++;
						}

					}
					System.out.println(cont + " Persona(s) de edad " + ageaux + " han votado");
					System.out.println("Presione enter para continuar...");
					sc.nextLine();
					sc.nextLine();
					break;
					
				case 4:
					Map<String, Integer> hm4 = new HashMap<String, Integer>();
					br = new BufferedReader(new FileReader(curps));
					line = "";
					hm4 = getPoliticP();

					while ((line = br.readLine()) != null) {

						String lineArray[] = line.split(",");
						String politicP= lineArray[1];
						
						hm4.put(politicP, hm4.get(politicP)+1);

					}

					for (Map.Entry<String, Integer> entry : hm4.entrySet()) {
			            System.out.println(entry.getKey() + " tiene " + entry.getValue()+ " votos.");
			        }

					System.out.println("Presione enter para continuar...");
					sc.nextLine();
					sc.nextLine();

					break;

				}
			} else {
				System.out.println("La opcion no existe, escoga una existente");
			}
		}

	}
	
	static Map<String, Integer> getPoliticP() {
		Map<String, Integer> hm = new HashMap<String, Integer>();
		hm.put( "PT",0);
		hm.put( "PRI",0);
		hm.put( "PAN",0);
		hm.put("MORENA",0);
		hm.put("MOV NAJ",0);

		return hm;
	}

	static Map<String, Map<String, Integer>> getgenres() {
		Map<String, Map<String, Integer>> hm = new HashMap<String, Map<String, Integer>>();
		Map<String, Integer> subHm = new HashMap<String, Integer>();

		subHm.put("Hombres", 0);
		hm.put("H", subHm);

		subHm = new HashMap<String, Integer>();

		subHm.put("Mujeres", 0);
		hm.put("M", subHm);

		return hm;

	}

	static Map<String, Map<String, Integer>> getStates() {
		Map<String, Map<String, Integer>> hm = new HashMap<String, Map<String, Integer>>();
		Map<String, Integer> subHm = new HashMap<String, Integer>();

		subHm.put("AGUASCALIENTES", 0);
		hm.put("AS", subHm);
		subHm = new HashMap<String, Integer>();

		subHm.put("BAJA CALIFORNIA SUR", 0);
		hm.put("BS", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("CAMPECHE", 0);
		hm.put("CC", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("COAHUILA", 0);
		hm.put("CL", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("TAMAULIPAS", 0);
		hm.put("TS", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("CHIAPAS", 0);
		hm.put("CS", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("DISTRITO FEDERAL", 0);
		hm.put("DF", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("GUANAJUATO", 0);
		hm.put("GT", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("HIDALGO", 0);
		hm.put("HG", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("MÉXICO", 0);
		hm.put("MC", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("MORELOS", 0);
		hm.put("MS", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("NUEVO LEÓN", 0);
		hm.put("NL", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("PUEBLA", 0);
		hm.put("PL", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("QUINTANA ROO", 0);
		hm.put("QR", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("SINALOA", 0);
		hm.put("SL", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("TABASCO", 0);
		hm.put("TC", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("TLAXCALA", 0);
		hm.put("TL", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("YUCATÁN", 0);
		hm.put("YN", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("NACIDO EN EL EXTRANJERO", 0);
		hm.put("NE", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("BAJA CALIFORNIA", 0);
		hm.put("BC", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("COLIMA", 0);
		hm.put("CM", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("CHIHUAHUA", 0);
		hm.put("CH", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("DURANGO", 0);
		hm.put("DG", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("GUERRERO", 0);
		hm.put("GR", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("JALISCO", 0);
		hm.put("JC", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("MICHOACÁN", 0);
		hm.put("MN", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("NAYARIT", 0);
		hm.put("NT", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("OAXACA", 0);
		hm.put("OC", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("QUERÉTARO", 0);
		hm.put("QT", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("SAN LUIS POTOSÍ", 0);
		hm.put("SP", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("SONORA", 0);
		hm.put("SR", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("VERACRUZ", 0);
		hm.put("VZ", subHm);

		subHm = new HashMap<String, Integer>();
		subHm.put("ZACATECAS", 0);
		hm.put("ZS", subHm);

		return hm;
	}
}
