
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // Custom input string
        String str = "12/25/1971";
        String[] arrOfStr = str.split("/", 3);
        
        int numMonth = Integer.parseInt(arrOfStr[0]);
        int numDay = Integer.parseInt(arrOfStr[1]);
        int numYear = Integer.parseInt(arrOfStr[2]);
  
        System.out.println(numMonth +"\n"+ numDay+"\n"+numYear);
//        for (String a : arrOfStr)
//            System.out.println(a);
    }

	

}
