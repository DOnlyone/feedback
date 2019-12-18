package edu.bnuz.fb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TestFunction {
	
	/**
	 * 根据字串中的数字进行排序：
	 * 排序规则：例如字符串 '第17号楼','第18号楼' ,'第14号楼'
	 * 排序后的顺序应为 '第14号楼' 》'第17号楼'》'第18号楼'
	 */
	private List<String> sortAddrSecListOrderByNum(List<String> cmAddrSecList ){

	    List<String> result = cmAddrSecList.stream().sorted(( obj1, obj2) -> {
	            int numbers1 = getNumbers(obj1);
	            int numbers2 = getNumbers(obj2);
	            return numbers1-numbers2;
	    }).collect(Collectors.toList());
	    return result;
	}
	
	public  Integer getNumbers(String content) {
    Pattern pattern = Pattern.compile("\\d+");
    Matcher matcher = pattern.matcher(content);
    while (matcher.find()) {
    	String digitText  = matcher.group(0);
        return Integer.valueOf(digitText);
    }
    return -1;
}

public static void main(String[] args) {
	List<String> cmAddrSecList = new ArrayList<>();
	Random random = new Random();

	for(int i=0;i<10;i++) {
		int nextInt = random.nextInt(20);
		
		String text = "第"+nextInt+"号楼";
		cmAddrSecList.add(text);
	}
	TestFunction t1 = new TestFunction();
	List<String> sortedList = t1.sortAddrSecListOrderByNum(cmAddrSecList);
	System.out.println(cmAddrSecList);
	System.out.println(sortedList);
	System.out.println(new Date().getTime());
	long currentTimeMillis = System.currentTimeMillis();
	System.out.println(currentTimeMillis);
	System.out.println(new Date().getTime());
	
	
	
}









}
