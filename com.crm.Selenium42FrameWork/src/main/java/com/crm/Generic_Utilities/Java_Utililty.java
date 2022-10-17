package com.crm.Generic_Utilities;

import java.util.Random;

public class Java_Utililty 
{
	/**this is to avoid Duplicate value
	 * 
	 * @return
	 * author Lohith
	 */
	public int getRanDomNum()
	{
		Random ran=new Random();
		int RanNum = ran.nextInt(1000);
		return RanNum;		
	}
}

