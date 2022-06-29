package com.example.demo1;

public class Account {
    private int id;
    private String user;
    private String pass;
    private String mail;

    public Account() {
    }

    public Account(int id, String user, String pass, String mail) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.mail = mail;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", user=" + user + ", pass=" + '}';
    }




}
