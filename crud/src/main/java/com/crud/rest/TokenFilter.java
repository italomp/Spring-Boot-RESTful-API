package com.crud.rest;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class TokenFilter extends GenericFilterBean{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String auth = req.getHeader("Authorization");
		if(auth == null || !auth.startsWith("Bearer ")) {
			throw new ServletException("Token inexistente ou mal formatado");
		}
		String token = auth.substring(7);
		try {
			Jwts.parser().setSigningKey("caneca").parseClaimsJws(token).getBody();
		}catch(SignatureException e) {
			throw new ServletException("Token inválido ou expirado");
		}
		chain.doFilter(request, response);
	}

}