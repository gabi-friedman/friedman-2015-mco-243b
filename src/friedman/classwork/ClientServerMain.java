package friedman.classwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientServerMain {
	public static void main(String args[]) {
		try {
			String line;
			// child process that runs dir and gives back the results

			//String temp = "cmd.exe /c echo %cd%";

			String runClient = "java -cp ./bin friedman.classwork.Client";
			String runServer = "java -cp ./bin friedman.classwork.Server";

			Process process1 = Runtime.getRuntime().exec(runClient);
			Process process2 = Runtime.getRuntime().exec(runServer);
			BufferedReader input1 = new BufferedReader(new InputStreamReader(process2.getInputStream()));
			while ((line = input1.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}