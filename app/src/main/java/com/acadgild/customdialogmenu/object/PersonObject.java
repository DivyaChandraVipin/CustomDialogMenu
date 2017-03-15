package com.acadgild.customdialogmenu.object;

/**
 * Created by DivyaVipin on 3/14/2017.
 */

public class PersonObject {
    public PersonObject()
    {

    }
    public PersonObject(int  id,String name,int phoneno,String dateOfBirth)
    {
        this.id=id;
        this.name=name;
        this.phoneno=phoneno;
        this.dateOfBirth=dateOfBirth;
    }
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(int phoneno) {
        this.phoneno = phoneno;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    private int phoneno;
    private String dateOfBirth;
}
