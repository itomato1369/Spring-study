package com.yedam.app.xml;

public class LuckyGoldstarTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("LuckyGoldstar ON");

	}

	@Override
	public void volumeUp() {
		System.out.println("LuckyGoldstar 주식 상승");

	}

	@Override
	public void powerOff() {
		System.out.println("LuckyGoldstar OFF");

	}

}
