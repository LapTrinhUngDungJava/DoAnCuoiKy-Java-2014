/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientchatroom;

import java.net.Socket;

/**
 *
 * @author Skys
 */
public class AcceptServer implements Runnable{
    
    private Socket _socket;

    public AcceptServer(Socket socket) {
        _socket = socket;
    }
    @Override
    public void run() {
        
    }
    
}
