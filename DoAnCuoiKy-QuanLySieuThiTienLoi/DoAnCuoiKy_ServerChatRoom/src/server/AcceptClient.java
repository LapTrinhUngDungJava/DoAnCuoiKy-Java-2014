/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author Skys
 */
public class AcceptClient implements Runnable{
    private Socket _Socket;
    private String _strName;
    private Thread _t;
    private boolean _bStop = false;
    private BufferedReader reader;
    private BufferedWriter writer;
    private PropertyChangeSupport _eVent = new PropertyChangeSupport(this);
    private PropertyChangeSupport _eVentExit = new PropertyChangeSupport(this);
    public void addClientSendMessEvent(PropertyChangeListener lsn){
        _eVent.addPropertyChangeListener(lsn);
    }
    public void removeClientSendMessEvent(PropertyChangeListener lsn){
        _eVent.removePropertyChangeListener(lsn);
    }
    public void addClientExitEvent(PropertyChangeListener lsn){
        _eVentExit.addPropertyChangeListener(lsn);
    }
    public void removeClientExitEvent(PropertyChangeListener lsn){
        _eVentExit.removePropertyChangeListener(lsn);
    }
    public Socket getSocket() {
        return _Socket;
    }

    public void setSocket(Socket _Socket) {
        this._Socket = _Socket;
    }

    public AcceptClient(Socket socket,String strName) {
        _strName = strName;
        _Socket = socket;
        try{
           reader = new BufferedReader(new InputStreamReader(_Socket.getInputStream()));
           writer = new BufferedWriter(new OutputStreamWriter(_Socket.getOutputStream()));
        }catch(Exception ex){
            
        }
        _t = new Thread((Runnable) this);
        _t.start();
    }
    
    @Override
    public void run() {
        String strDemo = "";
        while(true){
            if(_bStop) return;
            try{
               strDemo = reader.readLine(); 
               if(strDemo.equals("-Exit-")){
                   _bStop = true;
                   _eVentExit.firePropertyChange(_strName, null, null);
                   return;
               }
               _eVent.firePropertyChange(_strName, null, strDemo);
            }catch(Exception ex){
                
            }
        }
    }
}
