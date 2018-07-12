package com.api.rest.api.helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class matcher {
	
	
	public static void main(String[] args) {
		
		///ValidateResponseXMLFile(PatternFile, ResponseXML);
		
		
	}


	public static boolean ValidateResponseXMLFile(String PatternFile,
			String ResponseXML) throws Exception {

		String sout = null;

		// Get all elements with the requested element tag from the SOAP message
		// SOAPBody soapBody = soapMsg.getSOAPBody();

		int bFound = 0;
		BufferedReader pfileread = null;
		try {
			pfileread = new BufferedReader(new FileReader(PatternFile));

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block

			e1.printStackTrace();
		}
		String patline = null;
		try {
			while ((patline = pfileread.readLine()) != null) {
				sout = patline;
				Pattern p = Pattern.compile(patline);
				BufferedReader srcdr;
				String expectedLine = "";

				try {
					srcdr = new BufferedReader(new FileReader(ResponseXML));
					String srcline;

					bFound = 0;
					while ((srcline = srcdr.readLine()) != null)

					{

						// log.debug("teh src line is "+srcline);

						srcline = srcline.trim();

						Matcher m = p.matcher(srcline);

						if (m.matches() == true) {

							bFound = 1;
							expectedLine = expectedLine + srcline + "\n";
						}

					}

					//
					if (bFound == 0) {

						break;

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();

				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();

		}

		if (bFound == 1) {

			//log.debug("TC passed ");

			return true;

		}

		else {
			//log.debug("TC failed in Matching pattern");

			return false;
		}

	}
}

	