//{ Driver Code Starts
// driver

import java.io.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    static int getLen(Node head){
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }
    
    static int solver(Node num1, Node num2, int len1, int len2){
        if(len1 == 0) return 0;
        
        int carry;
        if(len1 == len2){
            carry = solver(num1.next, num2.next, len1 - 1, len2 - 1);
            num1.data += (num2.data + carry);
            carry = num1.data / 10;
            num1.data %= 10;
            return carry;
        }
        else{
            carry = solver(num1.next, num2, len1 - 1, len2);
            num1.data += carry;
            carry = num1.data / 10;
            num1.data %= 10;
        }
        return carry;
    }
    
    static Node addTwoLists(Node num1, Node num2) {
        Node dummy, temp;
        int len1 = getLen(num1);
        int len2 = getLen(num2);
        
        if(len1 < len2){
            temp = num1;
            num1 = num2;
            num2 = temp;
            
            int temp1 = len1;
            len1 = len2;
            len2 = temp1;
        }
        
        dummy = new Node(0);
        dummy.next = num1;
        
        solver(dummy, num2, len1 + 1, len2);
        
        while(dummy != null & dummy.data == 0) dummy = dummy.next;
        return dummy;
        
    }
}

//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        while (T-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            Node num1 = new Node(Integer.parseInt(str[0]));
            Node tail = num1;
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                tail.next = new Node(val);
                tail = tail.next;
            }

            String str2[] = read.readLine().trim().split(" ");
            int m = str2.length;

            Node num2 = new Node(Integer.parseInt(str2[0]));
            tail = num2;
            for (int i = 1; i < m; i++) {

                tail.next = new Node(Integer.parseInt(str2[i]));
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends