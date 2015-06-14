package friedman.memoryManager;

import java.util.Scanner;

public class MainMemory {
	private int totalBytes;
	private char[][] memory;

	public MainMemory(int totalBytes) {
		this.totalBytes = totalBytes;
		int rows = totalBytes / 128;
		this.memory = new char[rows][128];

		for (int i = 0; i < memory.length; i++) {
			for (int j = 0; j < memory[i].length; j++) {
				memory[i][j] = '-';
			}
		}
	}

	public boolean allocate(Integer processID, int numBytes) {
		boolean allocated = false;
		int counter = 0;
		int numBytesLeft = numBytes;

		for (int i = 0; i < memory.length; i++) {
			for (int j = 0; j < memory[i].length; j++) {
				if (memory[i][j] == '-') {
					counter++;
				}
			}
		}

		if (counter >= numBytes) {
			for (int i = 0; i < memory.length; i++) {
				for (int j = 0; j < memory[i].length; j++) {
					if (memory[i][j] == '-') {
						memory[i][j] = processID.toString().charAt(0);
						numBytesLeft--;
					}
				}
			}
			allocated = true;
		} else {
			allocated = false;
		}

		return allocated;
	}

	public void free(Integer processID) {
		for (int i = 0; i < memory.length; i++) {
			for (int j = 0; j < memory[i].length; j++) {
				if (memory[i][j] == processID.toString().charAt(0)) {
					memory[i][j] = '-';
				}
			}
		}
	}

	public String print() {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < memory.length; i++) {
			for (int j = 0; j < memory[i].length; j++) {
				b.append(memory[i][j]);
			}
			b.append("\n");
		}
		return b.toString();
	}

	public static void main(String args[]) {
		Scanner console = new Scanner(System.in);
		int total = 0;
		
		do {
			System.out.println("Please enter total number of bytes (must be divisible by 128)");
			total = console.nextInt();
		} while (total % 128 != 0);

		MainMemory mm = new MainMemory(total);

		char menu = ' ';
		do {
			System.out.println("Enter \n     A - allocate memory \n     F - free space\n     P - print\n     E - exit");
			menu = console.next().charAt(0);

			switch (menu) {
			case 'a':
			case 'A':
				int processID = -1;
				do {
					System.out.println("Enter the processID (#0-9) for allocation");
					processID = console.nextInt();
				} while (processID < 0 || processID > 9);

				System.out.println("Enter total number of bytes to allocate to memory");
				int numBytes = console.nextInt();

				if (mm.allocate(processID, numBytes) == false) {
					System.out.println("Sorry! can't allocate memory!");
				} else {
					System.out.println("Memory allocated to ProcessID #"+processID);
				}
				break;
			case 'f':
			case 'F':
				do {
					System.out.println("Enter the process ID #0-9) to free space");
					processID = console.nextInt();
				} while (processID < 0 || processID > 9);

				mm.free(processID);
				System.out.println("ProcessID #"+processID+" has been removed");
				break;

			case 'p':
			case 'P':
				System.out.println(mm.print());
				break;

			case 'e':
			case 'E':
				System.out.println("Exit");
				break;
			default:
				System.out.println("Choose A,F,P or E");
			}
		} while (menu != 'E');

	}

}