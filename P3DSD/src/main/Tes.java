package main;

import java.util.HashMap;
import java.util.Map;

public class Tes {
	public static void main(String[] args) {
		Map<String, Map<String, Integer>> hm2 = new HashMap<String, Map<String, Integer>>();
		Map<String, Integer> hm3 = new HashMap<String, Integer>();
		
		hm3.put("AGUASCALIENTES", 0);
		hm2.put("AS", hm3);
		hm3.clear();
		
		hm3.put("BAJA CALIFORNIA SUR", 0);
		hm2.put("BS", hm3);
		
		hm3.clear();
		hm3.put("COAHUILA", 0);
		hm2.put("CL", hm3);
		
		hm3.clear();
		hm3.put("DISTRITO FEDERAL", 0);
		hm2.put("DF", hm3);
		
		hm3.clear();
		hm3.put("GUANAJUATO", 0);
		hm2.put("GT", hm3);
		
		hm3.clear();
		hm3.put("HIDALGO", 0);
		hm2.put("HG", hm3);
		
		hm3.clear();
		hm3.put("MÉXICO", 0);
		hm2.put("MC", hm3);
		
		hm3.clear();
		hm3.put("MORELOS", 0);
		hm2.put("MS", hm3);
		
		hm3.clear();
		hm3.put("NUEVO LEÓN", 0);
		hm2.put("NL", hm3);
		
		hm3.clear();
		hm3.put("PUEBLA", 0);
		hm2.put("PL", hm3);
		
		hm3.clear();
		hm3.put("QUINTANA ROO", 0);
		hm2.put("QR", hm3);
		
		hm3.clear();
		hm3.put("SINALOA", 0);
		hm2.put("SL", hm3);
		
		hm3.clear();
		hm3.put("TABASCO", 0);
		hm2.put("TC", hm3);
		
		hm3.clear();
		hm3.put("TLAXCALA", 0);
		hm2.put("TL", hm3);
		
		hm3.clear();
		hm3.put("YUCATÁN", 0);
		hm2.put("YN", hm3);
		
		hm3.clear();
		hm3.put("NACIDO EN EL EXTRANJERO", 0);
		hm2.put("NE", hm3);
		
		hm3.clear();
		hm3.put("BAJA CALIFORNIA", 0);
		hm2.put("BC", hm3);
		
		hm3.clear();
		hm3.put("COLIMA", 0);
		hm2.put("CM", hm3);
		
		hm3.clear();
		hm3.put("CHIHUAHUA", 0);
		hm2.put("CH", hm3);
		
		hm3.clear();
		hm3.put("DURANGO", 0);
		hm2.put("DG", hm3);
		
		hm3.clear();
		hm3.put("GUERRERO", 0);
		hm2.put("GR", hm3);
		
		hm3.clear();
		hm3.put("JALISCO", 0);
		hm2.put("JC", hm3);
		
		hm3.clear();
		hm3.put("MICHOACÁN", 0);
		hm2.put("MN", hm3);
		
		hm3.clear();
		hm3.put("NAYARIT", 0);
		hm2.put("NT", hm3);
		
		hm3.clear();
		hm3.put("OAXACA", 0);
		hm2.put("OC", hm3);
		
		hm3.clear();
		hm3.put("QUERÉTARO", 0);
		hm2.put("QT", hm3);
		
		hm3.clear();
		hm3.put("SAN LUIS POTOSÍ", 0);
		hm2.put("SP", hm3);
		
		hm3.clear();
		hm3.put("SONORA", 0);
		hm2.put("SR", hm3);
		
		hm3.clear();
		hm3.put("VERACRUZ", 0);
		hm2.put("VZ", hm3);
		
		hm3.clear();
		hm3.put("ZACATECAS", 0);
		hm2.put("ZS", hm3);
		
		
		System.out.println(hm2);
	}
}
