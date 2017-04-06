package com.khw.bakery;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BakeryController {

	@Autowired
	BakeryServiceImpl service;
	ModelAndView mav = new ModelAndView();
	List<BakeryVO> list;
	
	@Autowired
	OrderHistoryVO oh;

	
	// 상품 주문하기 ======================
	@RequestMapping(value = "order.bakery", method = RequestMethod.GET)
	public ModelAndView orderForm() {
		list = service.getBakery();
		mav.addObject("list", list);
		mav.setViewName("bakery/orderform");
		return mav;
	}

	@RequestMapping(value = "order.bakery", method = RequestMethod.POST)
	public ModelAndView orderSuccess(String item, String userid) {
		String items[] = item.split(",");
		list = service.order(items);
		for (String str : items) {
			String temp[] = str.split(":");
			int upint[] = { Integer.parseInt(temp[1]), Integer.parseInt(temp[0]) };

			for (BakeryVO vo : list) {
				if (vo.getBakeryid() == upint[1]) {
					vo.setBalance(upint[0]);
					oh.setUserid(userid);
					oh.setBakeryid(upint[1]);
					oh.setAmount(upint[0]);
					service.setOrderHistory(oh);
				}
			}
		}
		mav.addObject("list", list);
		mav.setViewName("bakery/ordersuccess");
		return mav;
	}

	// 상품 추가하기 =============================
	@RequestMapping(value = "insert.bakery", method = RequestMethod.GET)
	public String insertForm() {

		return "bakery/insertform";
	}

	@RequestMapping(value = "insert.bakery", method = RequestMethod.POST)
	public ModelAndView insertSuccess(BakeryVO vo) throws IOException {
		int msg = service.insertBakery(vo);
		if (msg == 1) {
			File file = new File("/Users/woong/git/Spring_/bakery/src/main/webapp/" + vo.image);
			vo.getFile().transferTo(file);
			mav.addObject("vo",vo);
		}
		mav.addObject("msg", msg);

		mav.setViewName("redirect:/order.bakery");
		return mav;
	}

	// AJAX를 이용한 수량가져오기   =====================
	@ResponseBody
	@RequestMapping(value = "balance.bakery", method = RequestMethod.POST)
	public int getBalance(int bakeryid) {
		int balance = service.getBalance(bakeryid);
		return balance;
	}
	
	
	// 상품  관리 =======================
	@RequestMapping(value = "store.bakery", method = RequestMethod.GET)
	public ModelAndView storeForm() {
		List<BakeryVO> list = service.getBakery();
		mav.addObject("list",list);
		mav.setViewName("bakery/storeform");
		return mav;
	}

	// 상품 업데이트 완료 ============
	@ResponseBody
	@RequestMapping(value = "store.bakery", method = RequestMethod.POST)
	public BakeryVO storeSuccess(BakeryVO vo){
		BakeryVO bvo = service.updateBakery(vo);
		return bvo;
	}
	
	// 아이템 검색용 =============
	@ResponseBody
	@RequestMapping(value = "itemSearch.bakery", method = RequestMethod.POST)
	public BakeryVO itemSearch(int bakeryid){
		BakeryVO bvo = service.getBakeryOne(bakeryid);
		return bvo;
	}
	// 아이템 삭제용 =============
	@RequestMapping(value = "delete.bakery", method = RequestMethod.GET)
	public String deleteBakery(int bakeryid){
		System.out.println(bakeryid);
		service.deleteBakery(bakeryid);
		return "redirect:/store.bakery";
	}
	
	// 구매히스토리 조회
	@RequestMapping("orderhistory.bakery")
	public ModelAndView getOrderHistory(String userid){
		List<OrderVO> ovo = service.getOrderHistory(userid);
		
		mav.addObject("ovo",ovo);
		mav.addObject("userid",userid);
		mav.setViewName("bakery/orderhistory");
		return mav;
	}

}
