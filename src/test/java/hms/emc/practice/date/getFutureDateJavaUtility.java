package hms.emc.practice.date;

import com.tyss.genericUtilities.JavaUtility;

public class getFutureDateJavaUtility {

	public static void main(String[] args) {
		JavaUtility javautility = new JavaUtility();
		System.out.println(javautility.addOrSubstractDate("11_09_2008", 8));
		System.out.println(javautility.addCurrentDate(20));
		System.out.println(javautility.addOrSubstractDate(15));
	}

}
