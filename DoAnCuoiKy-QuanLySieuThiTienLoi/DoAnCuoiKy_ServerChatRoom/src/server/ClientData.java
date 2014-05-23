/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Skys
 */
public class ClientData {
   public Map _lstMapSocket = new HashMap();
   public Map _lstMapName = new HashMap();
   public void addSocket(Socket s,String strName){
       _lstMapSocket.put(strName,s);
       _lstMapName.put(s, strName);
   }
   public void removeAll(){
       _lstMapName.clear();
       _lstMapSocket.clear();
   }
   public void removeSocket(String strName){
       _lstMapName.remove(_lstMapSocket.get(strName));
       _lstMapSocket.remove(strName);
   }
   public void sendMessage(String strName,String strMess){
      Object[] arrName =  _lstMapName.values().toArray();
       for(int i=0;i<arrName.length;i++){
           if(((String)arrName[i]).compareTo(strName)==0) continue;
           try{
               BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(((Socket)_lstMapSocket.get(arrName[i])).getOutputStream()));
               writer.write(strName+"\n");
               writer.write(strMess+"\n");
               writer.flush();
           }catch(Exception ex){
               //removeSocket((String)arrName[i]);
           }
       }
   }
}
