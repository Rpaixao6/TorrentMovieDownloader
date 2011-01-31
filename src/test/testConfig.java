package test;

import java.io.File;
import java.io.IOException;

import config.ConfigurationsFile;

public class testConfig {
	private static final String FILENAME = "config.xml";
	private static final boolean DEBUG = false;
	public static void main(String args[]){
		new testConfig().test();
	}

	private void test() {
		//inicializcao
		ConfigurationsFile configFile = new ConfigurationsFile();
		ConfigurationIOFILE configIO =new ConfigurationIOFILE();
		File f= new File(FILENAME);
		if(DEBUG)
			System.out.println("DEBUG - Config file exists? "+ f.exists());

		//tentar criar ficheiro xml de config.
		if(DEBUG)
			System.out.println("DEBUG - Trying to create config file.");
		if (!f.exists()){
			try {
				configIO.createFile();
			} catch (IOException e) {
				if(DEBUG)
					System.out.println("DEBUG - ERROR - Could not create file.");
			}
		}else{
			
			configFile=configIO.loadFile(configFile);
		}

		//Print configs
		System.out.println("Configs:\n"+configFile.print());
	
		
	}
	
}
