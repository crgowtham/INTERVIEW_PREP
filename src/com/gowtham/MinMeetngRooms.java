package com.gowtham;

import java.util.Arrays;

public class MinMeetngRooms {

	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	};
	
	public static void main(String[] args){
		Interval int1 = new Interval(0,30);
		Interval int2 = new Interval(5,10);
		Interval int3 = new Interval(15,20);
		
		Interval[] test = {int1, int2, int3};
		
		System.out.println("Meeting Rooms: " + minMeetingRooms(test));
	}

	public static int minMeetingRooms(Interval[] intervals) {

		int[] starts = new int[intervals.length];
		int[] ends = new int[intervals.length];

		for (int i = 0; i < intervals.length; i++) {

			starts[i] = intervals[i].start;
			ends[i] = intervals[i].end;

		}

		Arrays.sort(starts);
		Arrays.sort(ends);
		int rooms = 0;
		int endsItr = 0;

		for (int i = 0; i < starts.length; i++) {

			if (starts[i] < ends[endsItr])
				rooms++;
			else
				endsItr++;

		}

		return rooms;

	}

}
