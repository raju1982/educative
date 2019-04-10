package lambda;

public class Test {

    public static void main(String[] args) {
        //example 1
        testWalkable(() -> System.out.println("test walkable"));

        //example 2
        Walkable input2 = () -> {
            System.out.println("input2");
            System.out.println("input3");
        };
        testWalkable(input2);

        //example 3
        calculate sumVar = (a,b) -> a+b;
        System.out.println(sumVar.compute(3,3));

        //example 4
        calculate multi = (a,b) -> {
            if(a==0) {
                return 0;
            }
            else{
                return a*b;
            }
        };
        System.out.println(multi.compute(0,3));
        System.out.println(multi.compute(3,3));

        //example 5
        generic<Integer> genericImpl = (a,b) -> {
            if(a==0) {
                return 0;
            }
            else{
                return a*b;
            }
        };

        System.out.println(genericImpl.compute(3,3));
    }

    static void testWalkable(Walkable input) {
        input.walk();
    }

}

@FunctionalInterface
interface Walkable {
    public void walk();
}

@FunctionalInterface
interface calculate{
    public int compute(int a, int b);
}

@FunctionalInterface
interface generic<T>{
    public T compute(T a, T b);
}


