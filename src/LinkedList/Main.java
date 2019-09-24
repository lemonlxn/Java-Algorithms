package LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkListDummy<Integer> linkListDummy = new LinkListDummy<>();

        for (int i = 0 ; i < 10 ; i ++){
            linkListDummy.addFirst(i);
            System.out.println(linkListDummy);
        }


        linkListDummy.add(1,200);
        System.out.println(linkListDummy);

        linkListDummy.remove(1);
        System.out.println(linkListDummy);

        System.out.println("-----------------------------------");

        LinkListStack<Integer> stack = new LinkListStack<>();

        for (int i = 0 ; i < 10; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);




    }
}
