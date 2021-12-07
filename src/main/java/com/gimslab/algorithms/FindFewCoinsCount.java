package com.gimslab.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindFewCoinsCount {
	/*
	r = count(amt, coin)
	r.remain
	r.cnt

	R count(amt, coin)
	  cnt = amt % coin
	  rmn = amt mod coin
	  if(rmn==0)
	    return (0, cnt)
	  for c in cnt..0 // decrese
	    rmAmt = amt - c * coin
	    if(rmAmt==0)
	      return (rmAmt, c)
	    rr = c + count(rmAmt, nextCoin))
	    if(rr.rmn == 0)
	      return c+ rr.cnt
	 */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(1);
		list.add(5);
		list.stream().sorted().collect(Collectors.toList());
	}
}
