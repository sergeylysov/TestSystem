/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.jet.testsystem;

/**
 *
 * @author sergey
 */
public class Client {
    private String firstname;
    private String Surname;
    private String Secondname;
    private String balance;
    private String account;
    private String phone;

    public Client(){};
    public Client(String firstname, String Surname, String Secondname, String balance, String account, String phone) {
        this.firstname = firstname;
        this.Surname = Surname;
        this.Secondname = Secondname;
        this.balance = balance;
        this.account = account;
        this.phone = phone;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getSecondname() {
        return Secondname;
    }

    public void setSecondname(String Secondname) {
        this.Secondname = Secondname;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}
