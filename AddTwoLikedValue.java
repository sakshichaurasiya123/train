import java.util.*;
public class AddTwoLikedValue {
    static class  Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next = null;
        }
    }
    static class LinkedList{
        Node head;
        public LinkedList(){
            this.head = null;
        }
    } 
//  *********** Add data at last *************
    static Node addLast(Node head,int data){
        Node node = new Node(data);
        Node temp = head;
        if(head == null)
            head = node;
        else{
            while(temp.next!=null)
                temp = temp.next;
            temp.next =  node;
        }
        return head;
    }  
    // ************ Add at Begining ***************
    static Node addBegning(Node head,int data){
        Node node = new Node(data);
        node.next = head;
        head = node;
        return head;
    }
    // *********** Reverse List ******************
    static Node reverse(Node head){
        Node temp=head,pre=null,nx;
        while(temp!=null){
            nx = temp.next;
            temp.next = pre;
            pre = temp;
            temp = nx;
        }
        return pre;
    } 
    // ******* List size *********
    static int size(Node head){
        int size=0;
        while(head!=null){
            size++;
            head = head.next;
        }
        return size;
    }
    // ******** Add two list data *************
    static LinkedList addTwoList(Node head1,Node head2){
        LinkedList list = new LinkedList();
        int carry=0,sum;
        Node ll;
        while(head1!=null){
            sum = (head1.data+head2.data+carry);
            if(sum < 10){
                ll = addLast(list.head,sum);
                list.head=ll;
                carry =0;
            }else{
                carry = sum/10;
                sum = sum%10;
                ll = addLast(list.head,sum);
                list.head = ll;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        if(carry >0){
            ll = addLast(list.head,carry);
            list.head = ll;
        }
        ll = reverse(list.head);
        list.head = ll;
        return list;
        
    }
    // ********** Display ******************
    static void display(Node head){
        if(head == null)
            System.out.println("List is Empty");
        else{
            while(head!=null){
                System.out.print(head.data+" ");
                head = head.next;
            }
            System.out.println(" ");
        }
    }
    // ******** Make list *************
    static LinkedList input(int n){
        LinkedList list = new LinkedList();
         int data; 
         Node  ll1 ;
        while(n-- > 0){
            data = scan.nextInt();
            ll1 =  addLast(list.head, data);
            list.head = ll1;
        }
        return list;
    }
    static Scanner scan = new Scanner(System.in);

    //  ******** Code Driver ***********
    public static void main(String args[]){
        LinkedList list1,list3;
        Node ll1,ll2;
        LinkedList list2; 

        int n ;
        System.out.print("Enter the First List size = ");
        n = scan.nextInt();
        list1 = input(n);
        System.out.print("Enter the Second List size = ");
        n = scan.nextInt();
        list2 = input(n);
        
         display(list1.head);
        display(list2.head);
        int size1 ,size2,diff;
        size1 = size(list1.head);
        size2 = size(list2.head);
        if(size1>=size2){
            diff = size1-size2;
            while( diff -- > 0){
                ll2 =  addBegning(list2.head,0);
                list2.head = ll2;
            }
        }else{
            diff = size2-size1;
            while( diff -- > 0){
                ll1 =  addBegning(list1.head,0);
                list1.head = ll1;
            }
        }
        ll1 = reverse(list1.head);
        list1.head = ll1;
        ll2 = reverse(list2.head);
        list2.head = ll2;
         System.out.println("After revesing ");
         display(list1.head);
         display(list2.head);
        list3 = addTwoList(list1.head,list2.head);
        System.out.println("After adding new list ");
        display(list3.head);
    }
}