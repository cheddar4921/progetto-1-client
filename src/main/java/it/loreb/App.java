package it.loreb;


public class App 
{
    public static void main( String[] args )
    {
        AppServer server = new AppServer();
        server.setPortAndWait(6789);
        server.comunicate();
    }
}
