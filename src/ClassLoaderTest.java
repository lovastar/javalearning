public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Class aa = ClassLoader.getSystemClassLoader().loadClass("java.lang.Object");

        Class clazz = Class.forName("java.lang.Object");
        System.out.println(clazz);
    }
}
