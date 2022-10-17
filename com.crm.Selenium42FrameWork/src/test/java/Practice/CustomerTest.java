package Practice;

import org.testng.annotations.Test;


public class CustomerTest
{
	@Test
	public void createCustomerTest()
	{
		System.out.println("customer details created");
	}
	@Test
	public void modifyCustomerTest()
	{
		System.out.println("customer details modified");
	}
	@Test
	public void deleteCustomerTest()
	{
		System.out.println("customer details deleted");
	}
}

