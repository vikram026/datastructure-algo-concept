package advance.datastructure;

import java.util.HashMap;
import java.util.Map;
//leetcode challenge;
class LRUCache {
     class Node{
        int key;
        int val;
        Node next,pre;
        Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    Node node=null,front,rear;;
    
    
    int capacity;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        node=null;
        map=new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
        Node given=map.get(key);
            if(capacity!=1 && given!=front){
                if(given!=rear){
                    given.pre.next=given.next;
                    given.next.pre=given.pre;
                    given.next=front;
                    front.pre=given;
                    front=given;
                }else{
                    Node tempr=rear.pre;
                    rear.pre=null;
                    tempr.next=null;
                    rear=tempr;
                    
                }
                
            }
            return map.get(key).val;
        }
        return -1;
        
        
    }
    
    public void put(int key, int val) {
        Node temp;
        if(node==null){
            node=new Node(key,val);
            front=node;
            rear=node;
            map.put(key,node);
            return;
        }
        if(!map.containsKey(key)){
            if(capacity>map.size()){
                
                temp=new Node(key,val);
                temp.next=front;
                front.pre=temp;
                front=temp;
                map.put(key,temp);
            }
            else{
                if(front!=rear){
                    //remove
                    Node rTemp=rear.pre;
                    rear.pre=null;
                    map.remove(rear.key);
                    rear=rTemp;
                    rear.next=null;
                    
                    temp=new Node(key,val);
                    temp.next=front;
                    front.pre=temp;
                    front=temp;
                    map.put(key,temp);
                    
                    
                    
                }else{
                    map.remove(front.key);
                    front.key=key;
                    front.val=val;
                    map.put(key,front);
                    
                }
            }
        }
        else{
            Node given=map.get(key);
            if(capacity!=1 && given!=front){
                if(given!=rear){
                    given.pre.next=given.next;
                    given.next.pre=given.pre;
                    given.next=front;
                    front.pre=given;
                    front=given;
                }else{
                    Node tempr=rear.pre;
                    rear.pre=null;
                    tempr.next=null;
                    rear=tempr;
                    
                }
                
            }
        }
        
        
    }
}