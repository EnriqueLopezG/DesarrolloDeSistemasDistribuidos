/*
DESARROLLO DE SISTEMAS DISTRIBUIDOS
PROYECTO #4
ENRIQUE LOPEZ GONZALEZ
4CM13
2019630371


*/
import networking.WebClient;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutionException;
public class Aggregator {
    private WebClient webClient;
    public Aggregator() {
        this.webClient = new WebClient();
    }
    public List<String> sendTasksToWorkers(List<String> workersAddresses, List<String> tasks) {

        int nOfTask = tasks.size();

        CompletableFuture<String>[] futures = new CompletableFuture[workersAddresses.size()];
        for (int i = 0; i < workersAddresses.size(); i++) {
            String workerAddress = workersAddresses.get(i);
            String task = tasks.get(i);
            System.out.println("Al servidor " + workerAddress + " se le asignó la tarea " + task + "\n");
            byte[] requestPayload = task.getBytes();
            futures[i] = webClient.sendTask(workerAddress, requestPayload);
        }
        List<String> results = new ArrayList<String>();
        for(int i = 3;  i < nOfTask; i++){

        
        boolean bandera = true;
        while (bandera) {
            for (int j = 0; j < 3; j++) {
                if (true == futures[j].isDone()) {
                try {
                        System.out.println(futures[j].get());
                    } catch (InterruptedException e) {              
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                     }
                    futures[j] = new CompletableFuture();
                    futures[j] = webClient.sendTask(workersAddresses.get(j), tasks.get(i).getBytes());
                     System.out.println("Al servidor " + workersAddresses.get(j) + " se le asignó la tarea " + tasks.get(i) + "\n");
                    bandera = false;
                    break;
                }
            }
        }
        }
  
        for (int i = 0; i < 3; i++) {
            System.out.println(futures[i].join());
        }
   
        return results;
    }
}