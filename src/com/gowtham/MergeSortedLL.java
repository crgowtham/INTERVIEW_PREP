package com.gowtham;

public class MergeSortedLL {
	public class LL {
		int value;
		LL next;
		
		LL(int val) {
			this.value = val;
		}
	}
	
	public static void main(String args[]) {
		MergeSortedLL testL = new MergeSortedLL();
		testL.test();
		
	}
	
	public void test() {
       LL l1 = new LL(1);
       LL l2 = new LL(3);
       l1.next = l2;
       LL l3 = new LL(7);
       l2.next = l3;
       
       LL l4 = new LL(4);
       LL l5 = new LL(5);
       l4.next = l5;
       
       LL finallist = mergelist(l1, l4);
       
       while(finallist != null) {
    	   System.out.println("value: " + finallist.value);
    	   finallist = finallist.next;
       }
       
	}
	
	public LL mergelist(LL fl, LL sl) {
		if(fl == null) return sl;
		if(sl == null) return fl;
		
		if(fl.value < sl.value) {
			fl.next = mergelist(fl.next, sl);
			return fl;
		} else {
			sl.next = mergelist(sl.next, fl);
			return sl;
		}
	}

}
