/*
DESARROLLO DE SISTEMAS DISTRIBUIDOS
PROYECTO #4
ENRIQUE LOPEZ GONZALEZ
4CM13
2019630371


*/

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class WebServer {

    private static final String STATUS_ENDPOINT = "/status";
    private static final String SEARCHTOKEN_ENDPOINT = "/searchtoken";
    private final int port;
    private HttpServer server;
    public static void main(String[] args) {
        int serverPort = 8080;
        if (args.length == 1) {
            serverPort = Integer.parseInt(args[0]);
        }
        WebServer webServer = new WebServer(serverPort);
        webServer.startServer();
        System.out.println("Servidor escuchando en el puerto "+serverPort);
    }
    public WebServer(int port) {
        this.port = port;
    }
    public void startServer() {
        try {
            this.server = HttpServer.create(new InetSocketAddress(port), 0);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        HttpContext statusContext = server.createContext(STATUS_ENDPOINT);
        HttpContext searchTokenContext = server.createContext(SEARCHTOKEN_ENDPOINT);
        statusContext.setHandler(this::handleStatusCheckRequest);
        searchTokenContext.setHandler(this::handleTaskRequest);
        server.setExecutor(Executors.newFixedThreadPool(8));
        server.start();
    }
    private void handleTaskRequest(HttpExchange exchange) throws IOException {
        if (!exchange.getRequestMethod().equalsIgnoreCase("post")) {
            exchange.close();
            return;
        }
        Headers headers = exchange.getRequestHeaders();
        if (headers.containsKey("X-Test") && headers.get("X-Test").get(0).equalsIgnoreCase("true")) {
            String dummyResponse = "123\n";
            sendResponse(dummyResponse.getBytes(), exchange);
            return;
        }
        boolean isDebugMode = false;
        if (headers.containsKey("X-Debug") && headers.get("X-Debug").get(0).equalsIgnoreCase("true")) {
            isDebugMode = true;
        }
        long startTime = System.nanoTime();
        byte[] requestBytes = exchange.getRequestBody().readAllBytes();
        String opc = exchange.getRequestURI().toString();
        byte[] responseBytes = calculateResponse(requestBytes, opc);
        long finishTime = System.nanoTime();
        if (isDebugMode) {
            String debugMessage = String.format("La operación tomó %d nanosegundos", finishTime - startTime);
            exchange.getResponseHeaders().put("X-Debug-Info", Arrays.asList(debugMessage));
        }
        sendResponse(responseBytes, exchange);
    }



    private byte[] calculateResponse(byte[] requestBytes, String opc) {
        String bodyString = new String(requestBytes);
        System.out.println("Palabra recibida:"+bodyString);
        

        int cont =0; 

        
		File file = new File("BIBLIA_COMPLETA.txt");

	
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String palabra = scanner.next().toLowerCase();
               // System.out.println(palabra);
                if (palabra.toLowerCase().equals(bodyString.toLowerCase())) {
					cont++;
				} 
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }
            System.out.println("El numero de ocurrencias es: " + bodyString  + "::"+cont +"\n");
        return String.format("El numero de ocurrencias es: " + bodyString  + "::"+cont +"\n").getBytes();
        
    }
    private void handleStatusCheckRequest(HttpExchange exchange) throws IOException {
        if (!exchange.getRequestMethod().equalsIgnoreCase("get")) {
            exchange.close();
            return;
        }
        String responseMessage = "El servidor está vivo\n";
        sendResponse(responseMessage.getBytes(), exchange);
    }
    private void sendResponse(byte[] responseBytes, HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(200, responseBytes.length);
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(responseBytes);
        outputStream.flush();
        outputStream.close();
        exchange.close();
    }
}