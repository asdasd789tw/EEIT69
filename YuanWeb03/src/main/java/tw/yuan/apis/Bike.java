package tw.yuan.apis;

import java.io.Serializable;

public class Bike implements Serializable{
	// 物件擁有: 屬性(has-a)、方法
	protected double speed;// 稱作物件變數、物件成員(member)
	// public宣告後所有class(類別)都能夠存取
	// protected宣告後提供給子類別用
	// 沒寫的話只有該package能夠存取
	// private宣告後只有該class(類別)能夠存取

	public String owner;

	
	public Bike() {
		System.out.println("Bike()");
	}// 建構式/子/方法
	
	public Bike(String name) {
		System.out.println("Bike(String)");
		owner = name;
	}// 只有一開始被執行一次 new Bike()
		// 所有類別都有建構式，若無定義建構式編譯器會幫忙從object父類別拿出無傳參數建構式object()繼承
	
	public Bike(int spd) {
		System.out.println("Bike(int)");
		speed = spd ;
	}
	
	public void setspeed(int sped) {
		speed =sped;
	}

	public void upSpeed() {
		speed = speed < 1 ? 1 : speed * 1.2;
	}

	public void downSpeed() {
		speed = speed < 1 ? 0 : speed * 0.5;
	}

	public double getSpeed() {
		return speed;
	}
	
	public String toString() {
		return "My speed is " + speed;
	}
}
