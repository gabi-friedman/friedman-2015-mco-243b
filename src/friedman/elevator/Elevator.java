package friedman.elevator;

public class Elevator {

	private int currentFloor;
	private int requestedFloor;
	
	public boolean isInUse(){
		return requestedFloor > 0;
	}
	
	public void setRequestedFloor(int requestedFloor){
		synchronized(this){
			while(isInUse()){
				this.requestedFloor = requestedFloor;

			}
		}
			}
}
