package leecode;

public class Demo149 {
    public static void main(String[] args) {
        new Demo149().insertionSortList(DemoUtils.makeListNode(new int[]{4,2,1,3}));
    }
    public ListNode Merge(ListNode list1,ListNode list2){
        ListNode dummyHead=new ListNode(-1);//保存链表地址的指针
        ListNode cur=dummyHead;//当前指针
        ListNode temp1=list1;
        ListNode temp2=list2;//保存节点list1,list2
        //135
        //24678
        //123456
        while(temp1!=null &&temp2!=null){//两个链表都没结束
            if(temp1.val<temp2.val){
                cur.next=temp1;
                temp1=temp1.next;//循环下一个
                cur=cur.next;

            }else{
                cur.next=temp2;
                temp2=temp2.next;//循环下一个
                cur=cur.next;
            }


        }
        if(temp1!=null){
            cur.next=temp1;//temp2结束，temp1没结束，链接到cur
        }
        if(temp2!=null){
            cur.next=temp2;//temp1结束，temp2没结束，链接到cur
        }


        return dummyHead.next;//返回节点
    }
    // 4->2->1->3
    //42
    //24
    //13
    //1234
    //时空效率 nlog2N
    public ListNode  MergeSortList(ListNode head,ListNode tail){
        //链表分段
        //中间节点
        //快慢指针
        if (head==null){
            return null;
        }
        if(head.next==tail){ //循环条件
            head.next=null;
            return head;
        }
        ListNode slow=head;//循环，1步
        ListNode fast=head;//走两步
        while(fast!=tail){
            fast=fast.next; //快慢指针
            slow=slow.next;
            if(fast!=tail){
                fast=fast.next;
            }
        }
        ListNode mid=slow;//中间点
        ListNode list1=MergeSortList(head,mid);
        ListNode list2=MergeSortList(mid,tail);
        return Merge(list1,list2);//归并排序



    }


    public ListNode insertionSortList(ListNode head) {
        return MergeSortList(head,null);//递归调用
    }

}