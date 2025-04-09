package com.shinhan.day07.lab3;

public class TV implements Volume {
	
	int VolLevel = 0;
	
	TV(){};

	@Override
	public void volumeUp(int level) {
		VolLevel += level;
		System.out.println("TV볼륨 올립니다."+VolLevel);

	}

	@Override
	public void volumeDown(int level) {
		VolLevel = Math.max(0, VolLevel - level);
		System.out.println("TV볼륨 내립니다."+VolLevel);

	}

}
