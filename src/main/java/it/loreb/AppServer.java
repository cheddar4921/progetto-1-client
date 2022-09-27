package it.loreb;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServer {
    ServerSocket serverSocket;
    Socket clientSocket;
    String recievedStr;
    String serverStr;
    BufferedReader clientInput;
    DataOutputStream clientOutput;

    AppServer()
    {
        System.out.println("Server started!" + "\n");
    }

    void setPortAndWait(int port)
    {
        System.out.println("Setting port..." + "\n");
        try 
        {
            serverSocket = new ServerSocket(port);
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong while initiating the server's socket!" + "\n");
            System.out.println(e.getMessage());
        }

        try
        {
            System.out.println("Port set! Waiting for a client..." + "\n")
            clientSocket = serverSocket.accept();
            serverSocket.close();
            clientInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            clientOutput = new DataOutputStream(clientSocket.getOutputStream());
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong in waiting for the client." + "\n");
            System.out.println(e.getMessage());
        }
    }

    void comunicate()
    {
        try {
            System.out.println("Waiting string from client..." + "\n");
            recievedStr = clientInput.readLine();    
            System.out.println("Recieved the following line from client: " + recievedStr + "\n");
            System.out.println("Sending success message to client. " + "\n");
            clientOutput.writeBytes("Success!" + "\n");
            System.out.println("Server is done.  Thank you so much!" + "\n");
            clientSocket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
