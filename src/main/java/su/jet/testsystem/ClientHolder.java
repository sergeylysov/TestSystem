/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.jet.testsystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sergey
 */
public class ClientHolder {
    
    private ClientHolder() {
    }
    private List<Client> list = new ArrayList<Client>();
    public Client getClient(){
        if (list.isEmpty()){
            return null;
        }else {
            Client client = list.get(0);
            list.remove(0);
            return client;}
    }
    public void addClient(Client client){
        list.add(client);
    }
    public static ClientHolder getInstance() {
        return ClientHolderHolder.INSTANCE;
    }
    
    private static class ClientHolderHolder {

        private static final ClientHolder INSTANCE = new ClientHolder();
    }
}
