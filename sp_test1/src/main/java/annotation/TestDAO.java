package annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class TestDAO {

	@Resource(name="vo1")
	private TestVO vo;

	public TestVO getVo() {
		return vo;
	}

	public TestVO test() {
		System.out.println("TestVO : test() ");
		return vo;
	}
}
