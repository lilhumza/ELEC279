import java.util.ArrayList;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // Custom input string
		ArrayList<String> v = new ArrayList<String>(10);
	       
        for (int i = 0; i < 5; i++)
            v.add(i, "st" + 4 * i);
 
        int n = 0;
        boolean bFlag = false;
       
        for (String s:v) {
            if (bFlag)
                v.set(v.indexOf(s), "uv" + --n);
            bFlag = !bFlag;
        }
        System.out.println(v.get(1) + v.get(2));
    }

	

}
