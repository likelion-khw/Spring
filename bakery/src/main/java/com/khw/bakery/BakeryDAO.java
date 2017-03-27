package com.khw.bakery;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BakeryDAO {
	
	@Autowired
	SqlSession session;
	
	public void store(){
		
	}
	
	public List<BakeryVO> selectBakery(String[] items)
	{
		List<BakeryVO> list = new ArrayList<BakeryVO>();
		for(String str: items)
		{
			String temp[] = str.split(":");
			int upint[] = {Integer.parseInt(temp[1]),Integer.parseInt(temp[0])};
			session.update("bakery.buy",upint);
			list.add(session.selectOne("bakery.one", Integer.parseInt(temp[0])));
		}
		
		return list;
	}
	
	public int insertBakery(BakeryVO vo)
	{
		int check = session.selectOne("check",vo.getBakeryname());
		if(check > 0 )
		{
			return 0;
		}else{
			
			session.insert("sell",vo);
			return 1;
		}
		
	}
	
	public BakeryVO getBakeryOne(int bakeryid)
	{
		return session.selectOne("bakery.one",bakeryid);
	}
	
	public BakeryVO updateBakery(BakeryVO vo)
	{
		session.update("update",vo);
		BakeryVO bvo = session.selectOne("bakery.one",vo.getBakeryid());
		return bvo;
	}
	
	public List<BakeryVO> getBakery(){
		return session.selectList("bakery.all");
	}
	
	public int getBalance(int bakeryid){
		return session.selectOne("bakery.balance", bakeryid);
	}
	
	public void deleteBakery(int bakeryid){
		session.delete("bakery.delete",bakeryid);
	}
	
	public List<OrderVO> getOrderHistory(String userid){
		return session.selectList("bakery.selectOrderHistory",userid);
	}
	
	public void setOrderHistory(OrderHistoryVO oh){
		session.insert("bakery.insertOrderHistory",oh);
	}
	
	
}
