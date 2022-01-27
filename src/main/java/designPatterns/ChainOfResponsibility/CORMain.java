package designPatterns.ChainOfResponsibility;

/**
 * https://www.youtube.com/watch?v=dKzZcKcPXvM&list=PLJN9ydlFnJsi6-lev2fQ2f1X7YD-VPQVW&index=9
 */
public class CORMain {
    public static void main(String[] args) {
        ChainCreator chainCreator = new ChainCreator();
        Managers manager = chainCreator.createChain();
        manager.approveSalary(5000);
        manager.approveSalary(15000);
        manager.approveSalary(45000);
        manager.approveSalary(5000000);
    }
}
