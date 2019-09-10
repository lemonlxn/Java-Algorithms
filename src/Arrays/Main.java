package Arrays;

public class Main {

    public static void main(String[] args) {
	    ArrayE<Integer> array = new ArrayE<>(10);

	    for (int i = 0 ; i < 9 ; i ++){
            array.addLast(i);
        }
        System.out.println(array);

	    array.addLast(9);
        System.out.println(array);

        array.addLast(10);
        System.out.println(array);

        array.add(0,2);
        System.out.println(array);

        array.remove(7);
        System.out.println(array);

        array.remove(7);
        System.out.println(array);

        array.removeElement(2);
        System.out.println(array);

        array.removeElement(9);
        System.out.println(array);

        array.removeLast();
        System.out.println(array);

        array.removeLast();
        System.out.println(array);

        array.removeLast();
        System.out.println(array);





    }
}
