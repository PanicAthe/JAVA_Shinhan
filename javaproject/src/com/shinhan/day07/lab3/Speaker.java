package com.shinhan.day07.lab3;

public class Speaker implements Volume {

	int VolLevel = 0;

	Speaker() {
	};

	@Override
	public void volumeUp(int level) {
		VolLevel = Math.min(100, VolLevel + level);
		System.out.println("Speaker볼륨 올립니다."+VolLevel);

	}

	@Override
	public void volumeDown(int level) {
		VolLevel = Math.max(0, VolLevel - level);
		System.out.println("Speaker볼륨 내립니다."+VolLevel);

	}

}
