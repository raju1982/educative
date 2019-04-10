package linklist;

public class findMidElement {

    /*
        static int findMidElement(LinkListPlay list){

        if(list.getHead() == null){
            throw new RuntimeException("invalid link list");
        }

        Node jumpOne = list.getHead();
        Node jumpTwo = list.getHead().getNextNode().getNextNode();

        if(jumpTwo ==  null){
            return jumpOne.getData();
        }

        while(jumpTwo!=null){
            jumpOne = jumpOne.getNextNode();
            if(jumpTwo.getNextNode() == null){
                break;
            }
            jumpTwo = jumpTwo.getNextNode().getNextNode();
        }
        return jumpOne.getData();
    }
     */
}
