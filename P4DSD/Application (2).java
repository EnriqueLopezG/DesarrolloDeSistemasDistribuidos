/*
DESARROLLO DE SISTEMAS DISTRIBUIDOS
PROYECTO #4
ENRIQUE LOPEZ GONZALEZ
4CM13
2019630371


*/


import java.util.Arrays;
import java.util.List;

public class Application {
    // Cadenas que corresponden a direcciones de endpoints
    private static  String WORKER_ADDRESS_1;
    private static  String WORKER_ADDRESS_2;
    private static  String WORKER_ADDRESS_3;
    public static void main(String[] args) {
        Aggregator aggregator = new Aggregator(); // Instancia objeto aggregator
        // Cadenas correspondientes a factores que se multiplicarán

        WORKER_ADDRESS_1="http://"+args[0]+"/searchtoken";
        WORKER_ADDRESS_2="http://"+args[1]+"/searchtoken";
        WORKER_ADDRESS_3="http://"+args[2]+"/searchtoken";

        //System.out.println(WORKER_ADDRESS_1+","+WORKER_ADDRESS_2+","+WORKER_ADDRESS_3);

        String[] tasks = Arrays.copyOfRange(args, 3, args.length);

        System.out.println(Arrays.toString(tasks));
    
        // Se encarga de enviar las tareas a los trabajadores
        List<String> results = aggregator.sendTasksToWorkers(Arrays.asList(WORKER_ADDRESS_1, WORKER_ADDRESS_2,WORKER_ADDRESS_3),
                Arrays.asList(tasks));
        // Recibe e imprime resultados
        for (String result : results) {
            System.out.println(result);
        }
    }
}
