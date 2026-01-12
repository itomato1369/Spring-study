package com.yedam.app.common;

public class TVExample {

	public static void main(String[] args) {
		// 일반적인 java방식
		// new 연산자로 호출
		// Interface 명  변수명 = new 객체
		TV tv = new SamsungTV();
        tv.powerOn();
        tv.volumeUp();
        tv.powerOff();
        
        
        TV televeison = new LuckyGoldstarTV();
        televeison.powerOn();
        televeison.volumeUp();
        televeison.powerOff();
		
		
		
	}

}
