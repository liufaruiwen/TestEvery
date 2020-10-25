package study;

public class Study20201024 {


    static class B {
        public int Func() {
            System.out.print("B");
            return 0;
        }
    }
    static class D extends B {
        @Override
        public int Func() {
            System.out.print("D");
            return 0;
        }
    }
    public static class Test {
        public static void main(String[] args) {
            B a = new B();
            B b = new D();
            a.Func();
            b.Func();
        }
    }
}
