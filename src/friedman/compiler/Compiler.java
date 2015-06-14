package friedman.compiler;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Compiler {

	public static void main(String[] args) {
		try {
			
			Scanner file = new Scanner(new File("./file.txt"));
			String[] cmds = new String[256];
			String cmd = "";
			int loc;
			int ct = 0;
			String temp;

			for (int i = 0; i < cmds.length; i++) {
				cmds[i] = "0";
			}

			do {
				cmd = file.next();
				switch (cmd) {
				case "//":
					file.nextLine();
					break;
				case "LD":
					cmds[ct++] = "0";
					loc = file.nextInt();
					temp = Integer.toHexString(loc);
					if (temp.length() > 1) {
						cmds[ct++] = String.valueOf(temp.charAt(0));
						cmds[ct++] = String.valueOf(temp.charAt(1));
					} else {
						cmds[ct++] = "0";
						cmds[ct++] = String.valueOf(temp.charAt(0));
					}
					file.nextLine();
					break;
				case "ST":
					cmds[ct++] = "1";
					loc = file.nextInt();
					temp = Integer.toHexString(loc);
					if (temp.length() > 1) {
						cmds[ct++] = String.valueOf(temp.charAt(0));
						cmds[ct++] = String.valueOf(temp.charAt(1));
					} else {
						cmds[ct++] = "0";
						cmds[ct++] = String.valueOf(temp.charAt(0));
					}
					file.nextLine();
					break;
				case "SWP":
					cmds[ct++] = "2";
					file.nextLine();
					break;
				case "ADD":
					cmds[ct++] = "3";
					file.nextLine();
					break;
				case "INC":
					cmds[ct++] = "4";
					file.nextLine();
					break;
				case "DEC":
					cmds[ct++] = "5";
					file.nextLine();
					break;
				case "BZ":
					cmds[ct++] = "6";
					loc = file.nextInt();
					temp = Integer.toHexString(loc);
					if (temp.length() > 1) {
						cmds[ct++] = String.valueOf(temp.charAt(0));
						cmds[ct++] = String.valueOf(temp.charAt(1));
					} else {
						cmds[ct++] = "0";
						cmds[ct++] = String.valueOf(temp.charAt(0));
					}
					file.nextLine();
					break;
				case "BR":
					cmds[ct++] = "7";
					loc = file.nextInt();
					temp = Integer.toHexString(loc);
					if (temp.length() > 1) {
						cmds[ct++] = String.valueOf(temp.charAt(0));
						cmds[ct++] = String.valueOf(temp.charAt(1));
					} else {
						cmds[ct++] = "0";
						cmds[ct++] = String.valueOf(temp.charAt(0));
					}
					file.nextLine();
					break;
				case "STP":
					cmds[ct++] = "8";
					file.nextLine();
					break;
				case "DATA":
					int where = file.nextInt();
					String what = Integer.toHexString(file.nextInt());
					if (what.length() > 1) {
						cmds[where++] = String.valueOf(what.charAt(0));
						cmds[where] = String.valueOf(what.charAt(1));
					} else {
						cmds[where++] = "0";
						cmds[where] = String.valueOf(what.charAt(0));
					}
					file.nextLine();
					break;
				}
			} while (file.hasNext());

			for (int i = 0; i < cmds.length; i++) {
				System.out.print(cmds[i].toUpperCase());
			}
			
			file.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		

	}
}