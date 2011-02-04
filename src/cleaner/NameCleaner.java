package cleaner;
import enums.ReleaseQuality;


public class NameCleaner {
	public String name="";
	public int year;
	public String releaseQuality="";
	private boolean DEBUG=true;
	private boolean quality_cleaned = false;
	private boolean year_cleaned = false;
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
		string=string.replace('{',' ');
		string=string.replace('}',' ');
		string=string.replaceAll("  "," ");
		String [] aux= string.split(" ");

		if(hasYearOnName(aux)){
			for (int i=0; i!=aux.length && (!quality_cleaned || year==0);i++){
				aux[i]=aux[i].trim();
				aux[i]=aux[i].toLowerCase();
				if(aux[i]!=""){
					if (!isYear(aux[i])){
						if (!isReleaseQuality(aux[i]) && !quality_cleaned){
							name=name+aux[i]+" ";
						}else{
							if (isReleaseQuality(aux[i])){
								releaseQuality=aux[i]; 
								//								i++;
								quality_cleaned = true;
							}
						}
					}else
						year=Integer.parseInt(aux[i]);
				}
			}
		}else{
			//clean name without year
			System.out.println("Haven't Year.");
			for (int i=0; i!=aux.length && !quality_cleaned;i++){
				aux[i]=aux[i].trim();
				aux[i]=aux[i].toLowerCase();
				if( !isReleaseQuality(aux[i]) && !quality_cleaned){
					name = name + aux[i]+" ";
				}else{
					releaseQuality=aux[i];
					quality_cleaned = true;
				}
			}
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