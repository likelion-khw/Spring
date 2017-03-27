package com.khw.bakery;

import java.util.List;

public interface BakeryService {
	List<BakeryVO> order(String[] items);
	List<BakeryVO> getBakery();
	List<OrderVO> getOrderHistory(String userid);
	void setOrderHistory(OrderHistoryVO oh);
	BakeryVO getBakeryOne(int bakeryid);
	BakeryVO updateBakery(BakeryVO vo);
	int insertBakery(BakeryVO vo);
	int getBalance(int bakeryid);
	void deleteBakery(int bakeryid);
	void store();
}
