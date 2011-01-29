
public class NameCleaner {
	public String name="";
	public int year;
	public String releaseQuality="";

	public void clean(String string){
		//replace '.' with ' '
		//The.Green.Hornet.2010.TS.XViD-T0XiC-iNK
		//TODO Implement a switch
		string=string.replace('.', ' ');
		string=string.replace('(', ' ');
		string=string.replace(')', ' ');
		String [] aux= string.split(" ");

		for (int i=0; i!=aux.length;i++){
			aux[i]=aux[i].trim();
			if(aux[i]!=""){
			if (!isYear(aux[i]))
				if (year ==0)
					name=name+aux[i]+" ";
				else{
					if (isReleaseQuality(aux[i])){
					releaseQuality=aux[i]; 
					i=aux.length-1;
					}
				}
			else
				year=Integer.parseInt(aux[i]);
		}
		}
	}
	
	private boolean isReleaseQuality(String string) {
		string=string.trim();
		try{
			ReleaseQuality.valueOf(string); //checks if string is present in enum ReleaseQuality
			return true;
		}
		catch (Exception e){
			System.out.println("ERROR - Release Quality format not right");
			System.out.println(string);
		return false;
		}
	}

	private boolean isYear(String string) {
		string=string.trim();
		// Check if String is number
		try{
			if (string.length()==4){ //Checks if number has 4 digits.
			Integer.parseInt(string);
			return true;
			}
		}
		catch (Exception e){
			System.out.println("ERROR - Year Format not right");
			System.out.println(string);
			return false;
		}
	return false;
	}
}