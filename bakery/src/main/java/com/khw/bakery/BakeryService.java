package com.khw.bakery;

import java.util.List;

public interface BakeryService {
	List<BakeryVO> order(String[] items);
	List<BakeryVO> getBakery();
	BakeryVO getBakeryOne(int bakeryid);
	BakeryVO updateBakery(BakeryVO vo);
	String insertBakery(BakeryVO vo);
	int getBalance(int bakeryid);
	void store();
}
