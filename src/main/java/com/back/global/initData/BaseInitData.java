package com.back.global.initData;

import com.back.domain.post.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//전체적으로 영향역을 미치는 곳 global 파트로 넣는다
@Configuration
public class BaseInitData {
	@Autowired
	private PostRepository postRepository;

	@Bean
	ApplicationRunner baseInitDataApplicationRunner() {
		return args -> {
			System.out.println("기본 데이터가 초기화되었습니다.");
			//TODO db 접속할 로직을 넣을 예정
			postRepository.count();
		};
	}
}

/*
 @Configuration : 빈의 일종, 내부에 @Bean 메서드를 가질 수 있다
 @Bean : 메서드는 스프링 부트가 시작할 때 자동으로 실행된다.
 ApplicationRunner : 빈에 등록되면 자동으로 실행되는 성질을 가지고 있다.
* */