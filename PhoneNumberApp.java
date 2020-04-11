package emailApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PhoneNumberApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String filename = "";
		File file = new File(filename);
		String[] phoneNums = new String[9];
		String phoneNum = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
		for (int i = 0; i<phoneNums.length; i++){
			
			
				phoneNums[i] = br.readLine();
				}	
				br.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Error: file not found");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
	
		
		// valid number
			//10 digits long
			//area code cannot start in 0 or 9
			// there can be 911 inthe phone
		
		
		try{
			if (phoneNum.length() != 10){
				throw new TenDigitsException(phoneNum);
			}
			if ((phoneNum.substring(0,1).equals ("0")) || (phoneNum.substring(0,1).equals("9"))){
				throw new AreaCodeException(phoneNum);
			}
			//checking for 911
			for(int n = 0; n<phoneNum.length(); n++){
				if(phoneNum.substring(n, n+1).equals("9")){
					if (phoneNum.substring(n, n+ 3).equals("11")){
						throw new EmergencyException(phoneNum);
					}
				}
				
			}
			
			
			System.out.println(phoneNum);
		} catch(TenDigitsException e){
			System.out.println("Error: phone number is not 10 digits");
		} catch (AreaCodeException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: phone number has invalid area code");
			e.printStackTrace();
		} catch (EmergencyException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR: Invalid 911 found");
			e.printStackTrace();
		}
		
		finally{
			
		}

	}

}





class TenDigitsException extends Exception{
	String num;
	TenDigitsException(String num){
		this.num = num;
		
	}
	public String toString(){
		return("TenDigitsException" + num);
	}
}
class AreaCodeException extends Exception{

	public AreaCodeException(String phoneNum) {
		// TODO Auto-generated constructor stub
	}
	
}

class EmergencyException extends Exception{
	String num;
	EmergencyException(String num){
		this.num = num;
	}
	public String toString(String phoneNum) {
		return ("Emergency Exception: "+phoneNum);
		// TODO Auto-generated constructor stub
	}
	
}