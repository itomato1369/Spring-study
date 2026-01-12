package com.yedam.app.xml;

public class SamsungTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("Samsung ON");

	}

	@Override
	public void volumeUp() {
		System.out.println("Samsung 주식 상승");

	}

	@Override
	public void powerOff() {
		System.out.println("Samsung OFF");

	}

}
