    /*
     * Eddie Tang
     * et354@drexel.edu
     * CS338:GUI, Assignment [2], Program [1]
     */

public class Menu {
	private String[] list;
	private String concatInfo;

	public Menu(){
		concatInfo = "";

	}
	public String save(String... values){
		list = values;
		
		for(int i = 0; i<list.length; i++)
		{
			concatInfo = concatInfo + list[i];
			if(i != list.length-1){
				concatInfo = concatInfo + ",";
			}
		}
		return concatInfo;
	}
	
	//gets overridden
	public String[] load(String data){
		return data.split(",");
	}
}
