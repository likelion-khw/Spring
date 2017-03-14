package edu.bit.mymvc2;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserListController {
	
	// 5개 사용자 객체 list 리턴
	// id, pw
	@ModelAttribute("conditionlist")
	public ArrayList<String> getSearchConditionList() {
		ArrayList<String> conditionlist = new ArrayList<String>();

		conditionlist.add("ID검색");
		conditionlist.add("이름검색");
		conditionlist.add("이메일검색");
		conditionlist.add("연락처검색");

		return conditionlist;
	}

	@ModelAttribute("amvo")
	public ArrayList<MemberVO> getModel() {
		MemberVO vo1 = new MemberVO("java", "java", "자바", "010-234-2314", "java@java");
		MemberVO vo2 = new MemberVO("oracle", "oracle", "오라클", "010-115-2341", "oracle@oralce");
		MemberVO vo3 = new MemberVO("python", "python", "파이썬", "010-2341-2341", "python@python");
		MemberVO vo4 = new MemberVO("Mysql", "Mysql", "마이에뜌", "010-231-3234", "mysql@mysql");
		MemberVO vo5 = new MemberVO("JSP", "JSP", "제이에스피", "010-234-2342", "jsp@jsp");

		ArrayList<MemberVO> amvo = new ArrayList<MemberVO>();

		amvo.add(vo1);
		amvo.add(vo2);
		amvo.add(vo3);
		amvo.add(vo4);
		amvo.add(vo5);

		return amvo;
	}

	@RequestMapping("/list.member")
	public String getMemberlist() {
		return "memberlist";
	}


	@RequestMapping(value = "/get.member", method = RequestMethod.GET)
	public String detailMember(@ModelAttribute("id") String id) {
		return "getmember";
	}

	@RequestMapping(value = "/searchlist.member")
	public ModelAndView search(
			@RequestParam(value = "searchTitle", required = false, defaultValue = "none") String searchTitle,
			String searchValue) {
		ModelAndView mav = new ModelAndView();
		ArrayList<MemberVO> amvo = getModel();
		ArrayList<MemberVO> result = new ArrayList<MemberVO>();

		if (searchTitle.equals("none")) {
			mav.addObject("result", amvo);
		} else {
			for (MemberVO vo : amvo) {
				boolean searchType = false;

				if (searchTitle.equals("ID검색")) {
					searchType = vo.getId().contains(searchValue);
				} else if (searchTitle.equals("이름검색")) {
					searchType = vo.getName().contains(searchValue);
				} else if (searchTitle.equals("이메일검색")) {
					searchType = vo.getEmail().contains(searchValue);
				} else if (searchTitle.equals("연락처검색")) {
					searchType = vo.getPhone().contains(searchValue);
				}

				if (searchType == true) {
					result.add(vo);
				}
			}
			mav.addObject("result", result);
		}
		
		mav.setViewName("searchlist");

		return mav;
	}

}
