package com.anzhi.jwt;

import org.apache.shiro.authc.AuthenticationToken;

import lombok.Data;


/**
 * 自定义一个对象来包装token
 * @author admin
 *
 */

@Data
public class JWTToken implements AuthenticationToken {
	
	private String token;
	
	
	/**
	 * 过期时间
	 */
	private String expireAt;
	
	public JWTToken(String token) {
		super();
		this.token = token;
	}

	public JWTToken(String token, String exitpreAt) {
		this.token = token;
		this.expireAt = exitpreAt;
	}

	@Override
	public Object getPrincipal() {		
		return token;
	}

	@Override
	public Object getCredentials() {		
		return token;
	}

}
