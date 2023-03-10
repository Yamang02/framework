package com.kh.di.owner;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kh.di.pet.Cat;
import com.kh.di.pet.Dog;

class OwnerTest {

	@Test
	@Disabled
	void nothing() {
	}

	@Test
	void create() {
		// 생성자를 통한 의존성 주입
		//		Owner owner = new Owner("문인수", 20, new Dog("보리"));
		//		Owner owner = new Owner("문인수", 20, new Cat("콜리"));
		Owner owner = new Owner();

		//		owner.setName("문인수");
		//		owner.setAge(20);
		//메소드를 통한 의존성 주입
		owner.setPet(new Dog("보리"));
		owner.setPet(new Cat("콜리"));

		System.out.println(owner);
		System.out.println(owner.getPet());
		System.out.println(owner.getPet().getName());

	}

	@Test
	void contextTest() {
		ApplicationContext context = new GenericXmlApplicationContext("spring/root-context.xml");

		//		Owner owner = (Owner) context.getBean("moon");
//		Owner owner = context.getBean("hong", Owner.class);
		Owner owner = context.getBean("moon", Owner.class);
		Owner owner2 = context.getBean("hong", Owner.class);

		System.out.println(owner);
		System.out.println(owner2);

		assertThat(context).isNotNull();
		assertThat(owner).isNotNull();
		assertThat(owner2).isNotNull();
	}

}
