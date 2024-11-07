public class Employee implements Cloneable {

    private static Employee emp = null;

    private Employee() {}

    public static Employee getInstance() {

        if (emp == null) {
            synchronized (emp) {
                if (emp == null) {
                    emp = new Employee();
                }
            }
        }


        return emp;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("");
    }
}
