package edu.bit.mymvc2;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {

	public ArrayList<MemberVO> memberlist() {
		ArrayList<MemberVO> amvo = new ArrayList<MemberVO>();
		amvo.add(new MemberVO("admin", "admin", "Admin", "admin", "Ad"));
		amvo.add(new MemberVO("test", "test", "test", "test", "te"));
		amvo.add(new MemberVO("asdf", "asdf", "asdf", "asdf", "asdf"));
		amvo.add(new MemberVO("user", "user", "user", "user", "user"));
		amvo.add(new MemberVO("study", "study", "su", "su", "su"));
		return amvo;
	}

	@ResponseBody 
	@RequestMapping("sample/doF")
	public MemberVO doF() {
		System.out.println("doF method");
		return memberlist().get(0);
	}

	@ResponseBody
	@RequestMapping("sample/memberlist")
	public ArrayList<MemberVO> doG() {
		System.out.println("doG method");

		return memberlist();
	}
}
