package com.back.domain.member.member.entity;

import com.back.domain.post.post.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Entity
@Setter
@ToString
@NoArgsConstructor
public class Member extends BaseEntity {
	@Column(nullable = true)
	private String usename;
	private String password;
	private String nickname;

	public Member(String usename, String password, String nickname) {
		this.usename = usename;
		this.password = password;
		this.nickname = nickname;
	}

}
