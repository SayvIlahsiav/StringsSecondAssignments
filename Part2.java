
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public int howMany(String stringa, String stringb)
    {
        int count = 0;
        int currIndex = 0;
        while(true)
        {
            currIndex = stringb.indexOf(stringa, currIndex);
            if(currIndex == -1)
            {
                break;
            }
            count++;
            currIndex += stringa.length();
        }
        return count;
    }
    
    public void testHowMany()
    {
        String sa = "GAA";
        String sb = "ATGAACGAATTGAATC";
        System.out.println(howMany(sa, sb));
        sa = "AA";
        sb = "ATAAAA";
        System.out.println(howMany(sa, sb));
    }
    
    public static void main(String args[])
    {
        Part2 p2 = new Part2();
        p2.testHowMany();
    }

}
