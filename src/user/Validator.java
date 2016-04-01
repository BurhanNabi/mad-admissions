package user;

import java.time.LocalDate;

public class Validator {
	
	public static boolean hasOnlyDigits(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}
	
	public static boolean validateTextFields(String[] ar) {
		for (String s : ar)
			if( s.length() == 0)return false;
		return true;
	}
	
	public boolean validateTextField(String str) {
		return (str.length() == 0);
	}
	
	public static double extractNum(String str) {
		return Double.parseDouble(str);
	}
	
	public static boolean validateDate(LocalDate date) {
		if(date.compareTo(LocalDate.now()) > 0 ) {
			return false;
		}
		return true;
	}

//	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
//		System.out.println(hasOnlyDigits("1234"));
//		System.out.println((int)extractNum("1234"));
//		System.out.println( Applicant.generateEnrollmentId());
//		File file = new File("Try");
//		if(file.exists()) {
//			try {
//				System.out.println(new File(".").getCanonicalPath());
//				
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		else {
//			file.mkdirs();
//		}
//		
//		ObjectInputStream oin = new ObjectInputStream(
//		new FileInputStream("DATA/Applicants/20150025"));
//		Applicant prev = (Applicant) oin.readObject();
//		System.out.println("My Name is :" + prev.getPersonalDetails().name);
//		oin.close();
//		System.out.println(prev.PG);
//		System.out.println("PG: " + prev.getPGDetails());
//		LocalDate d = prev.getTimeOfSubmit();
//		System.out.println((d==null));
//		System.out.println( d );
//	}
	
	
}
