public class App {
    public static void main(String[] args) throws Exception {
        //test code, can be removed
        Database.open();
        Order order1 = new Order(1);
        System.out.println(order1);
        Database.close();
    }
}
