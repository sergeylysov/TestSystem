/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.jet.testsystem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.jws.WebService;
import javax.jws.WebMethod;



/**
 *
 * @author sergey
 */
@WebService(serviceName = "TestWebService")
public class TestWebService {

    /**
     * This is a sample web service operation
     */
   
   
//    @WebMethod(operationName = "process")
//    public String process(@WebParam(name = "name") String txt) {
//        return "Hello " + txt + " !";
//    }
    @WebMethod(operationName = "addClient")
    public String addClient(Client client) {
        System.out.println("SOAP addClient called");
        Pattern pattern = Pattern.compile("[0-9]{16}", Pattern.CASE_INSENSITIVE);
        if(client.getAccount().length()>16||client.getAccount().length()<16){
            System.out.println("<>16");
            return "Ошибка ввода номера счета: введите 16 цифр";
            
        } 
        Matcher matcher = pattern.matcher(client.getAccount());
        if(!matcher.find()){
            return "Ошибка ввода номера счета: введите 16 цифр";
        }
        Pattern patternBalance = Pattern.compile("^\\d+$", Pattern.CASE_INSENSITIVE);
        matcher = patternBalance.matcher(client.getBalance());
        if(!matcher.find()){
            return "Ошибка ввода баланса: введите целое число";
        }
        Pattern patternPhone = Pattern.compile("^\\+[0-9]{11}$", Pattern.CASE_INSENSITIVE);
         matcher = patternPhone.matcher(client.getPhone());
         if(!matcher.find()){
            return "Ошибка ввода номера телефона: некорректный формат";
        }
        ClientHolder.getInstance().addClient(client);
        return "Client "+ client.getSurname()+" "+client.getFirstname()+" add success";
    }
     @WebMethod(operationName = "getClient")
    public Client getClient() {
        System.out.println("SOAP getClient called");
        Client client = ClientHolder.getInstance().getClient();
        return client;
    }
}
