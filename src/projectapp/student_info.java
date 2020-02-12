/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapp;


public class student_info {
    
    private int index;
    private String fname;
    private String lname;
    private String id;
    private String username;
    private String password;
    private String email;
    private String address;
    private String mobile_no; 
    
    
    public student_info(int index, String fname, String lname, String id, String username, String password, String email, String address, String mobile_no)
    {
        this.index = index;
        this.fname = fname;
        this.lname = lname;
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.mobile_no = mobile_no;
    }
    
    public int getIndex()
    {
        return index;
    }
    
    public String getFname()
    {
        return fname;
    }
    
    public String getLname()
    {
        return lname;
    }
    
    public String getId()
    {
        return id;
    }
    public String getUsername()
    {
        return username;
    }
    public String getPassword()
    {
        return password;
    }
    public String getEmail()
    {
        return email;
    }
    public String getAddress()
    {
        return address;
    }
    public String getMobile_no()
    {
        return mobile_no;
    }
    
}


