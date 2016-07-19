    /*
     * Eddie Tang
     * et354@drexel.edu
     * CS338:GUI, Assignment [2], Program [1]
     */
public class TripTracker {

	public static void main(String[] args){
		//View view = new View();
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run(){
				new Controller();
			}
		});
	}
}
