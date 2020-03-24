import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author ericfouh
 */
public interface IDocumentsProcessor
{
    /**
     * @param directoryPath - the path to the directory
     * @param n - the size of the sequence of words
     * @return collection of files with sequences of words
     */
    Map<String, List<String>> processDocuments(String directoryPath, int n);


    /**
     * We write nword sequences sequentially in the file. they are separated by
     * a space
     * 
     * @param docs - map of string with list of all nword sequences
     * @param nwordFilePath of the file to store the nword sequences
     * @return a list of file and size (in byte) of character written in file
     *         path
     */
    List<Tuple<String, Integer>> storeNWordSequences(
        Map<String, List<String>> docs,
        String nwordFilePath);


    /**
     * The method takes the path to the document folder, the path to the N-word 
     * sequences files (output), and the number of words in the sequence as input.
     * The method will not create a Map associating each file to its n-word sequences. 
     * It will store the sequences directly in the sequence file.
     * The method will return the List of tuples of files and their size in sequenceFile.
     * @param directoryPath
     * @param sequenceFile
     * @param n
     * @return the List of tuples of files and their size in sequenceFile
     */
    List<Tuple<String, Integer>> processAndStore (String
    		directoryPath, String sequenceFile, int n);
    
    /**
     * @param nwordFilePath  of the file to store the nword sequences
     * @param fileindex - a list of tuples representing each file and its size
     *                  in nwordFile
     * @return a TreeSet of file similarities. Each Similarities instance
     *         encapsulates the files (two) and the number of nword sequences
     *         they have in common
     */

    public TreeSet<Similarities> computeSimilarities(
        String nwordFilePath,
        List<Tuple<String, Integer>> fileindex);


    /**
     * @param sims      - the TreeSet of Similarities
     * @param threshold - only Similarities with a count greater than threshold
     *                  are printed
     */
    public void printSimilarities(TreeSet<Similarities> sims, int threshold);
}