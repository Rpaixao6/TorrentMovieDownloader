package cleaner;
import enums.ReleaseQuality;


public class NameCleaner {
	public String name="";
	public int year;
	public String releaseQuality="";
	private boolean DEBUG=true;
	public boolean cleaned=false;

	public void clean(String string, boolean DEBUG){
		this.DEBUG=DEBUG;
		//replace '.' with ' '
		//The.Green.Hornet.2010.TS.XViD-T0XiC-iNK
		//TODO Implement a switch
		String[] aux1=string.split("/");
		string= aux1[aux1.length-1];
		string=string.replace('[', ' ');
		string=string.replace(']', ' ');
		string=string.replace('_', ' ');
		string=string.replace('-', ' ');
		string=string.replace('.', ' ');
		string=string.replace('(', ' ');
		string=string.replace(')', ' ');
		string=string.replaceAll("  "," ");
		String [] aux= string.split(" ");
		
		if(hasYearOnName(aux)){
			for (int i=0; i!=aux.length;i++){
				aux[i]=aux[i].trim();
				if(aux[i]!=""){
					if (!isYear(aux[i]))
						if (year ==0)
							name=name+aux[i]+" ";
						else{
							aux[i]=aux[i].toLowerCase();
							if (isReleaseQuality(aux[i])){
								releaseQuality=aux[i]; 
								i=aux.length-1;
							}
						}
					else
						year=Integer.parseInt(aux[i]);
				}
			}
		}else{
			System.out.println("NAO HA ANO");
		}
	
		if(!name.equals("") && year!=0 && !releaseQuality.equals("") )
			cleaned=true;
	}

	private boolean hasYearOnName(String[] aux) {
		for(int i= 0 ; i != aux.length;i++){
			if(isYear(aux[i]))return true;
		}
		return false;
	}

	private boolean isReleaseQuality(String string) {
		string=string.trim();
		try{
			ReleaseQuality.valueOf(string); //checks if string is present in enum ReleaseQuality
			return true;
		}
		catch (Exception e){
			if (DEBUG){
			System.out.println("ERROR - Release Quality format not right");
			System.out.println(string);
			}
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
			if (DEBUG){
			System.out.println("ERROR - Year Format not right");
			System.out.println(string);
			}
			return false;
		}
		return false;
	}
}