import java.util.Scanner;

public class InsertAndDeleteNodeOfBST {
    static class Node{
       int data;
       Node right, left;

       public Node(int data){
           this.data = data;
           right = left = null;
       }
    }

    public static Node insert(Node root, int data){
        if(root == null){

            return new Node(data);
        }

        if(data < root.data){
            root.left = insert(root.left, data);
        }
        else{
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static Node createTree(Node root){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the data: ");
        int d = scanner.nextInt();

         root = insert(root, d);

         return root;

    }

    public static Node delete(Node root, int key){
        if(key < root.data){
            root.left = delete(root.left, key);
        }else if(key > root.data){
            root.right = delete(root.right, key);
        }
        else{
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            root.data = minVal(root.right);


            root.right = delete(root.right, root.data);

        }

        return root;

    }

    public static int minVal(Node root){
        int mini = root.data;

        while(root.left != null){
            mini = root.left.data;
            root = root.left;
        }
        return mini;
    }

    public static void printTree(Node root){
        if(root == null) return;

        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);

    }



    public static void main(String[] args) {
        Node root = null;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i = 0; i < n; i++){
            root  = createTree(root);
        }

        printTree(root);
        System.out.println();

        System.out.println("Enter the value you want to delete");
        int key = scanner.nextInt();

        root = delete(root, key);

        printTree(root);

    }
}
