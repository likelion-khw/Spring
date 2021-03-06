package com.khw.bakery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BakeryServiceImpl implements BakeryService{

	@Autowired
	BakeryDAO dao;
	
	public List<BakeryVO> order(String[] items){
		return dao.selectBakery(items);
	}
	
	public BakeryVO getBakeryOne(int bakeryid)
	{
		return dao.getBakeryOne(bakeryid);
	}
	
	public void store(){
		dao.store();
	}
	
	public int insertBakery(BakeryVO vo){
		return dao.insertBakery(vo);
	}
	
	public List<BakeryVO> getBakery(){
		return dao.getBakery();
	}
	
	public int getBalance(int bakeryid){
		return dao.getBalance(bakeryid);
	}
	public BakeryVO updateBakery(BakeryVO vo){
		return dao.updateBakery(vo);
	}
	
	public void deleteBakery(int bakeryid){
		dao.deleteBakery(bakeryid);
	}
	
	public List<OrderVO> getOrderHistory(String userid){
		return dao.getOrderHistory(userid);
	}
	
	public void setOrderHistory(OrderHistoryVO oh){
		dao.setOrderHistory(oh);
	}
	
}
