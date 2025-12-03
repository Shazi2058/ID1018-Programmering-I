package synonymer;

//SynonymHandler

/****************************************************************

SynonymHandler handles information about synonyms for various
words.

The synonym data can be read from a file and handled in various
ways. These data consists of several lines, where each line begins
with a word, and this word is followed with a number of synonyms.

The synonym line for a given word can be obtained. It is possible
to add a synonym line, and to remove the synonym line for a given
word. Also a synonym for a particular word can be added, or
removed. The synonym data can be sorted. Lastly, the data can be
written to a given file.

Author: Fadil Galjic

****************************************************************/

import java.io.*;    // FileReader, BufferedReader, PrintWriter,
                  // IOException

class SynonymHandler
{
	// readSynonymData reads the synonym data from a given file
	// and returns the data as an array
 public static String[] readSynonymData (String synonymFile)
                                      throws IOException
 {
     BufferedReader reader = new BufferedReader(
	        new FileReader(synonymFile));
     int numberOfLines = 0;
     String synonymLine = reader.readLine();
     while (synonymLine != null)
     {
			numberOfLines++;
			synonymLine = reader.readLine();
		}
		reader.close();

		String[] synonymData = new String[numberOfLines];
     reader = new BufferedReader(new FileReader(synonymFile));
		for (int i = 0; i < numberOfLines; i++)
		    synonymData[i] = reader.readLine();
		reader.close();

		return synonymData;
 }

 // writeSynonymData writes a given synonym data to a given
 // file
 public static void writeSynonymData (String[] synonymData,
     String synonymFile) throws IOException
 {
     PrintWriter writer = new PrintWriter(synonymFile);
     for (String synonymLine : synonymData)
         writer.println(synonymLine);
     writer.close();

 }

 // synonymLineIndex accepts synonym data, and returns the
 // index of the synonym line corresponding to a given word.
 // If the given word is not present, an exception of
 // the type IllegalArgumentException is thrown.
	private static int synonymLineIndex (String[] synonymData,
     String word) throws IllegalArgumentException
 {
		int delimiterIndex = 0;
		String w = "";
		int i = 0;
		boolean wordFound = false;
		while (!wordFound  &&  i < synonymData.length)
		{
		    delimiterIndex = synonymData[i].indexOf('|');
		    w = synonymData[i].substring(0, delimiterIndex).trim();
		    if (w.equalsIgnoreCase(word))
				wordFound = true;
			else
				i++;
	    }

	    if (!wordFound)
	        throw new IllegalArgumentException(
		        word + " not present");

	    return i;
	}

 // getSynonymLine accepts synonym data, and returns
 // the synonym line corresponding to a given word.
 // If the given word is not present, an exception of
 // the type IllegalArgumentException is thrown.
 public static String getSynonymLine (String[] synonymData,
     String word) throws IllegalArgumentException
 {
		int index = synonymLineIndex(synonymData, word);

	    return synonymData[index];
	}

 // addSynonymLine accepts synonym data, and adds a given
 // synonym line to the data.
	public static String[] addSynonymLine (String[] synonymData,
	    String synonymLine)
	{
		String[] synData = new String[synonymData.length + 1];
		for (int i = 0; i < synonymData.length; i++)
		    synData[i] = synonymData[i];
		synData[synData.length - 1] = synonymLine;

	    return synData;
	}

 // removeSynonymLine accepts synonym data, and removes
 // the synonym line corresponding to a given word.
 // If the given word is not present, an exception of
 // the type IllegalArgumentException is thrown.
	public static String[] removeSynonymLine (String[] synonymData,
	    String word) throws IllegalArgumentException
	{
		// add code here
			int index = synonymLineIndex(synonymData, word); 
			String[] synData = new String[synonymData.length - 1  ]; 
			for (int i = 0; i < index; i++)
				synData[i] = synonymData[i];		 						
			for (int i = index + 1; i < synonymData.length; i++) 
				synData[i - 1] = synonymData[i];								
			return synData;	
		
	}

 // getSynonyms returns synonyms in a given synonym line.
	private static String[] getSynonyms (String synonymLine)
	{
     // add code here
		String[] synonyms = synonymLine.split("[|,]");  
		String[] synData = new String[synonyms.length - 1]; 
		for (int i = 1; i < synonyms.length; i++) 			 	
			synData[i - 1] = synonyms[i].trim();
		return synData;
	}

 // addSynonym accepts synonym data, and adds a given
 // synonym for a given word.
 // If the given word is not present, an exception of
 // the type IllegalArgumentException is thrown.
	public static void addSynonym (String[] synonymData,
	    String word, String synonym) throws IllegalArgumentException
	{
     // add code here
		int index = synonymLineIndex(synonymData, word); 
		String line = synonymData[index]; 
		String newLine = line + ", " + synonym ; 
		synonymData[index] = newLine;
	}

 // removeSynonym accepts synonym data, and removes a given
 // synonym for a given word.
 // If the given word or the given synonym is not present, an
 // exception of the type IllegalArgumentException is thrown.
 // If there is only one synonym for the given word, an
 // exception of the type IllegalStateException is thrown.
	public static void removeSynonym (String[] synonymData,
	    String word, String synonym)
	    throws IllegalArgumentException, IllegalStateException
	{
     // add code here
		int index = synonymLineIndex(synonymData, word);  
		String line = synonymData[index]; 				
		String[] synonyms = getSynonyms(line); 
		if (synonyms.length == 1) 
			throw new IllegalStateException(word + " has only one synonym"); 
		
		boolean Found = false;
		for (int i = 0; i < synonyms.length; i++) {       
			if (synonyms[i].equalsIgnoreCase(synonym))
				Found = true;

		}
		if (!Found)
			throw new IllegalArgumentException("Could not find the Synonym! " ); 
		
		int delimiterIndex = line.indexOf('|'); 
		String words = line.substring(0, delimiterIndex).trim(); 
		String newLine = words + " | " ; 
		for (int i = 0; i < synonyms.length; i++) { 
			if (!synonyms[i].equalsIgnoreCase(synonym))
			newLine += synonyms[i] + ", ";
		}
		newLine = newLine.substring(0, newLine.length() - 2); 
		
		synonymData[index] = newLine;
	}
 // sortIgnoreCase sorts an array of strings, using
 // the selection sort algorithm
 private static void sortIgnoreCase (String[] strings)
 {
     // add code here
	 for (int i = 0; i < strings.length - 1; i++) {
		 int min = i; //Assume that min is i
		 for (int j = i + 1; j < strings.length; j++) {   
				if (strings[j].compareToIgnoreCase(strings[min]) < 0) 
					min = j;
			}
			String sort = strings[i];
			strings[i] = strings[min]; 
			strings[min] = sort; 
		 }
		 
	 }
	 

 // sortSynonymLine accepts a synonym line, and sorts
 // the synonyms in this line
 private static String sortSynonymLine (String synonymLine)
 {
	    // add code here
		String[] synonym = getSynonyms(synonymLine); 
		sortIgnoreCase(synonym);  
		String line = synonymLine.substring(0, synonymLine.indexOf('|')).trim();  
		String newLine = line + " | "; 
		for (int i = 0; i < synonym.length; i++) {
			newLine += synonym[i] + ", " ; 
		}
		return newLine;
	}

 // sortSynonymData accepts synonym data, and sorts its
 // synonym lines and the synonyms in these lines
	public static void sortSynonymData (String[] synonymData)
	{
     // add code here
		for (int i = 0; i < synonymData.length; i++)
			synonymData[i] = sortSynonymLine(synonymData[i]);		 		
		sortIgnoreCase(synonymData);	 
	}
}