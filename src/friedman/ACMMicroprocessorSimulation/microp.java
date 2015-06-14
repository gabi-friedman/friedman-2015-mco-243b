package friedman.ACMMicroprocessorSimulation;

import java.util.Scanner;

public class microp {

	public static void main(String[] args){

		Scanner console = new Scanner(System.in);
		char[] w = console.nextLine().toCharArray();
		String[] whole = new String[w.length];
		for(int i = 0; i < w.length; i++){
			whole[i] = String.valueOf(w[i]);
		}
		String word;
		String hi;
		String lo;
		int loc = 0;
		String regA = "";
		String regB = "";
		int ct = 0;

		do{
			if((whole[ct].equals(6) && regA.equals(0))|| whole[ct].equals(7)){
				word = whole[ct];
			}
			else{
				word = whole[ct];
				ct++;
			}
			

			switch(word){
			case "0":{
				hi = whole[ct];
				ct++;
				lo = whole[ct];
				ct++;
				loc = Integer.parseInt(hi+lo,16);
				regA = whole[loc].toUpperCase();
				break;
			}
			case "1":{
				hi = whole[ct];
				ct++;
				lo = whole[ct];
				ct++;
				loc = Integer.parseInt(hi+lo,16);
				whole[loc] = regA;
				break;
			}
			case "2":{
				String temp = regA;
				regA = regB.toUpperCase();
				regB = temp.toUpperCase();
				break;
			}
			case "3":{				
				int sumDec = Integer.parseInt(regA, 16); 
				if(!regB.equals("")){
					sumDec+=Integer.parseInt(regB, 16);
				}
				String sumHex = Integer.toHexString(sumDec);
				if(sumHex.length() > 1){
					regA = String.valueOf(sumHex.charAt(1)).toUpperCase();
					regB = String.valueOf(sumHex.charAt(0)).toUpperCase();
				}
				else{
					regA = String.valueOf(sumHex.charAt(0)).toUpperCase();
					regB = "0";
				}
				break;
			}
			case "4":{
				int temp = Integer.parseInt(regA,16);
				if(temp == 15){
					temp = 0;
				}
				else{
					temp++;				
				}
				regA = Integer.toHexString(temp).toUpperCase();	
				break;
			}
			case "5":{
				int temp = Integer.parseInt(regA,16);
				if(temp == 0){
					temp = 15;
				}
				else{
					temp--;				
				}
				regA = Integer.toHexString(temp).toUpperCase();	
				break;
			}
			case "6":{
				if(regA.equals("0")){
					hi = whole[ct];
					ct++;
					lo = whole[ct];
					ct++;
					loc = Integer.parseInt(hi+lo,16);
					ct = loc;
				}
				else{
					loc+=3;
				}
				break;
			}
			case "7":{
				hi = whole[ct];
				ct++;
				lo = whole[ct];
				ct++;
				loc = Integer.parseInt(hi+lo,16);
				ct = loc;
				break;
			}
			case "8":{
				for(int i = 0; i < whole.length; i++){
					System.out.print(whole[i]);
				}
				System.exit(0);
				break;
			}
			}
		}while(true);

	}

}
