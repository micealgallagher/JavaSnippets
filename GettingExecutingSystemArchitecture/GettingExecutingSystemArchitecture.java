/**
* Getting Executing System Architecture
* https://github.com/micealgallagher/JavaSnippets
*
* @copyright
* Copyright (C) 2014 Miceal Gallagher
*
* @license
* Licensed under the MIT licenses.
*/ 

import java.io.InputStreamReader;
import java.io.BufferedReader;

class main {
	public static void main (String[] args) {

		String systemArch = getClientArchitecture();
		System.out.println("You are currently running a " + systemArch + " system.");

	}

	private static String getClientArchitecture() {
        String returnValue = "";
        
        String osName = System.getProperty("os.name");
        if ( osName.contains("Window") ) {
                returnValue = getWindowsArchitecture();
        } else {
                returnValue = getLinuxArchitecture();
        }
        
        return returnValue;
    }
    
    private static String getWindowsArchitecture() {
        String returnValue = "";
        
        boolean is64BitOS = System.getenv("ProgramW6432") != null;
        returnValue = is64BitOS ? "x64" : "x86";
        
        return returnValue;
    }
    
    private static String getLinuxArchitecture() {
        String returnValue = "";
        
        String[] commands = { "uname", "-i"};
        
        Runtime runTime = Runtime.getRuntime();
        Process process = null;
        
        try {
        
            process = runTime.exec(commands);
            
            InputStreamReader streamReader = new InputStreamReader(process.getInputStream());
            BufferedReader buffRead = new BufferedReader(streamReader);
            
            String processOutput = buffRead.readLine();
            buffRead.close();
            
            process.waitFor();
            
            returnValue = processOutput;
        
        } catch (Exception e) {
            returnValue = "UNKNOWN";
        }
        
        return returnValue;
    }
}