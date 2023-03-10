package com.kh.di.pet;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Dog extends Pet {

	public Dog(String name) {
		super(name);
	}

	@Override
	public String bark() {
		return "멍멍~";
	}

}
