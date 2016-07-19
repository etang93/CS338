    /*
     * Eddie Tang
     * et354@drexel.edu
     * CS338:GUI, Assignment [2], Program [1]
     */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class Model {

	Menu menu;
	Vector<Integer> trackingList; //used to differentiate between flight, train, car
	public Model(){
		trackingList = new Vector<Integer>();
	}
	
	public String createSave(Menu menuType, String...components){
		
		return menuType.save(components);
	}
	//poops the data with the associated menu type back 
	public ArrayList<String> loadData(int selectedIndex, String selectedValue){
		
		int menuType = trackingList.get(selectedIndex);
		if(menuType == 0)
		{
			menu = new FlightMenu();
			String[] tmp = menu.load(selectedValue);
			ArrayList<String> real = new ArrayList<String>(Arrays.asList(tmp));
			real.add("Flight");
			return real;
		}
		else if(menuType == 1)
		{
			menu = new TrainMenu();
			String[] tmp = menu.load(selectedValue);
			ArrayList<String> real = new ArrayList<String>(Arrays.asList(tmp));
			real.add("Train");
			return real;
			
		}
		else if (menuType == 2)
		{
			menu = new CarMenu();
			String[] tmp = menu.load(selectedValue);
			ArrayList<String> real = new ArrayList<String>(Arrays.asList(tmp));
			real.add("Car");
			return real;
		}
		
		return null;
	}
	//returns the type of menu the selected index is
	public int getType(int index){
		return trackingList.get(index);
	}
	
	public void addToTrackingList(int val){
		/*
		 * Airplane = 0
		 * Train = 1
		 * Car = 2
		 */
		trackingList.add(val);
	}
	
	public void removeFromTrackingList(int val)
	{
		trackingList.remove(val);
	}
}
