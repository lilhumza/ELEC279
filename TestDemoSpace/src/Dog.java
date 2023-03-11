public class Dog{
    public void PrintDogInfo() {
        String info = getInformation();
        System.out.println(info);
    }
    public String getInformation() {
        return "This is a dog.";
    }
}
public class Retriever extends Dog {
    public String getInformation() {
        return "This is a retriever.";
    }
}
public class Husky extends Dog{
    //Note that getInformation here is different
    //from that in the base class. It takes 
    //a parameter here.
    public String getInformation(int i) {
        return "This is a husky.";
    }
}
public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.PrintDogInfo();
        Retriever r = new Retriever();
        r.PrintDogInfo();
        Husky h = new Husky();
        h.PrintDogInfo();
    }
}