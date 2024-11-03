package ezwallet;
public class user {
	private int uid;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String nic;
    private int pin;
    private double balance;
    private double totalOutcome;
    private double totalIncome;



    public user(int uid,String firstName, String lastName, String email, String mobile, String nic, int pin, double balance) {
       this.uid = uid;
    	this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.nic = nic;
        this.pin = pin;
        this.balance = balance;
    }

    public void setBalance(double b)
    {
    	this.balance = b;
    }
    
    public void setTotalIncome(double totalIncomeAmount) {
        this.totalIncome = totalIncomeAmount;
    }
    
    public void setTotalOutcome(double totalOutcomeAmount) {
        this.totalOutcome = totalOutcomeAmount;
    }
    
    
    //getters
    public int getId() {
        return uid;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getNic() {
        return nic;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }
    
    public double getOutcome() {
        return totalOutcome;
    }
    
    public double getIncome() {
        return totalIncome;
    }
    
    
}
