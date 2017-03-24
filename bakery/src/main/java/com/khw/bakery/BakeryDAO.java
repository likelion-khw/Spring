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
	
	public String insertBakery(BakeryVO vo)
	{
		int check = session.selectOne("check",vo.getBakeryname());
		if(check > 0 )
		{
			return "해당 상품이 존재합니다.";
		}else{
			
			session.insert("sell",vo);
			return "상품 등록 완료";
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
		return session.selectOne("balance", bakeryid);
	}
	
	
}
