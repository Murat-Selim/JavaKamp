package InterfaceAbstractDemo;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		Customer customer =new Customer(1,"Murat","Selim","12345678912",new Date(1994));
	    
		BaseCustomerManager customerManager = new NeroCustomerManager();
	    customerManager.save(customer);
	}

}
