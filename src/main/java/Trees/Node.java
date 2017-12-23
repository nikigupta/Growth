package Trees;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Node {
    public int data;
    public Node left;
    public Node right;

   public Node(int data) {
        this.data = data;
        left = right = null;
    }
   
}