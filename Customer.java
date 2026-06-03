// make class for the customer's data
public class Customer{

// make the name of the person's name, email and phone number 
private String custoName; 
private String email; 
private String phoneNum;

// make constructor again to find the name of the person, email and the phoneNum 
public Customer(String custoName,String email,String phoneNum){

this.custoName = custoName;
this.email = email;
this.phoneNum = phoneNum;
    } 

// use the getters to get the information for outside classes 
public String getCustoName() { return custoName; }
public String getEmail() { return email; }
public String getPhoneNum() { return phoneNum; }



}