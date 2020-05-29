package corejava.exception;

public class FinallyPlay {
    public static void main(String[] args) {
        int x=m2();
        System.out.println(" returning "+x);
    }


    private static int m2(){
        try{
            System.out.print("hi body");
            int i=10/0;
            System.out.print("hi body");

            return  10;

        }catch (Exception e){

            System.out.println("gogg");
            e.printStackTrace();

        }
        return 1;
    }

    private static int m() {
        try{
            return 1;
        }
        finally{
            try {
                throw new RuntimeException();
            }
            catch(Exception e) {
                System.out.println("hi baby");

                return 2;
            }

        }
    }
}
