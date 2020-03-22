package com.capgemini.onlinewallet.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;

import com.capgemini.onlinewallet.exception.InvalidNameException;
import com.capgemini.onlinewallet.exception.InvalidPasswordException;
import com.capgemini.onlinewallet.exception.InvalidPhoneNumberException;
import com.capgemini.onlinewallet.exception.NegativeBalanceException;
import com.capgemini.onlinewallet.exception.NullException;
import com.capgemini.onlinewallet.exception.ValidationException;
import com.capgemini.onlinewallet.service.OnlineWalletServiceImplementation;

public class ServiceTest {
	@Test
	public void checkName()
	{
		assertThrows(NullException.class,()->{new OnlineWalletServiceImplementation().checkName(null);});
	}
   
@Test
public void checkNameTest()
   {
	   assertThrows(InvalidNameException.class,()->{new OnlineWalletServiceImplementation().checkName("123abc");});
   }
   @Test
	public void checkPhoneNumber()
   {
	   assertThrows(NullException.class,()->{new OnlineWalletServiceImplementation().checkPhoneNumber(null);});
   }
   @Test
	public void checkPhoneNumberTest()
   {
	   assertThrows(ValidationException.class,()->{new OnlineWalletServiceImplementation().checkPhoneNumber("12345");});
   }
   @Test
	public void checkPhoneNumberTest1()
   {
	   assertThrows(InvalidPhoneNumberException.class,()->{new OnlineWalletServiceImplementation().checkPhoneNumber("abcdefg87378");});
   }
   @Test
	public void checkPassword()
   {
	   assertThrows(NullException.class,()->{new OnlineWalletServiceImplementation().checkPassword(null);});
   }
   @Test
	public void checkPasswordTest()
   {
	   assertThrows(ValidationException.class,()->{new OnlineWalletServiceImplementation().checkPassword("aru");});
   }
   @Test
	public void checkPasswordTest1()
   {
	   assertThrows(InvalidPasswordException.class,()->{new OnlineWalletServiceImplementation().checkPassword("aru1234");});
   }
   
   
	

}

