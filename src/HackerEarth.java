class HackerEarth {

    public static void main(String args[])

    {

        StringBuilder b = new StringBuilder("hacker");
        b.append(4).deleteCharAt(3).delete(3, b.length() - 1);
        System.out.println(b);

    }

}