import java.util.Scanner;
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public int findStopCodon(String dna, int startIndex, String stopCodon)
    {
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1)
        {
            int diff = currIndex - startIndex;
            if(diff % 3 == 0)
            {
                return currIndex; 
            }
            else
            {
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
            }
        }
        return -1;   
    }
    
    public String findGene(String dna, int where)
    {
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1)
        {
            return "No start codon found.";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int[] stopIndices = {taaIndex, tagIndex, tgaIndex}; // Array containing all indices
        int minIndex = -1;  // Initialize to -1 for "not found"
        for (int index : stopIndices) {
            // If this index is found and (minIndex is not set or this index is smaller)
            if (index != -1 && (minIndex == -1 || index < minIndex)) {
                minIndex = index;
            }
        }
        if (minIndex == -1)
        {
            return "No valid stop codon found.";
        }
        return dna.substring(startIndex, minIndex + 3);
    }
    
    public void printAllGenes(String dna)
    {
        int startIndex = 0;
        int count = 0;
        while(true)
        {
            String gene = findGene(dna, startIndex);
            if (gene.isEmpty() || "No start codon found.".equals(gene) || "No valid stop codon found.".equals(gene))
            {
                break;
            }
            count++;
            System.out.println("Gene" + count + ": " + gene);
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
    }
    
    public int countGenes(String dna)
    {
        int count = 0;
        int startIndex = 0;
        while(true)
        {
            String gene = findGene(dna, startIndex);
            if (gene.isEmpty() || "No start codon found.".equals(gene) || "No valid stop codon found.".equals(gene))
            {
                break;
            }
            count++;
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
        System.out.println(count);
        return count;
    }
    
    public static void main(String args[])
    {
        //String dna = "CCCATGAGCTAAAGCTAGATGGTCTAGATGGCTGAACCATGAGCTAATTTAA";
        Part3 p3 = new Part3();
        Scanner scn = new Scanner(System.in);
        
        while(true)
        {
            System.out.print("Enter DNA (type 'x' to exit): ");
            String dna = scn.nextLine();
            if ("x".equalsIgnoreCase(dna)) {  // Exit condition
                break;
            }
            System.out.println("Finding Genes...");
            System.out.print("Genes Found: ");
            p3.countGenes(dna);
            System.out.println("");
            p3.printAllGenes(dna);
            System.out.println("");
            //System.out.println("_._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._");
            System.out.println("___________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
            System.out.println("\n");
        }
        
        scn.close();        
    }
}
