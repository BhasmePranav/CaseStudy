//package com.example.customer.filter;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Service;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.customerdetails.service.CustomUserDetailsService;
//import com.customerdetails.util.JwtUtil;
//
//@Service
//public class JwtFilter extends OncePerRequestFilter {
//
//	@Autowired
//	JwtUtil jwtUtil;
//
//	@Autowired
//	CustomUserDetailsService customUserDetailService;
//
//	String userNameForExternalUse = "";
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
//			FilterChain filterChain) throws ServletException, IOException {
//		final String authorizationHeader = httpServletRequest.getHeader("Authorization");
//		String username = null;
//		String token = null;
//
//		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//			token = authorizationHeader.substring(7);
//			username = jwtUtil.extractUsername(token);
//			userNameForExternalUse=username;
//		}
//
//		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//			UserDetails userDetails = this.customUserDetailService.loadUserByUsername(username);
//			if (jwtUtil.validateToken(token, userDetails)) {
//				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//						userDetails, null, userDetails.getAuthorities());
//				usernamePasswordAuthenticationToken
//						.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
//				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//			}
//		}
//		filterChain.doFilter(httpServletRequest, httpServletResponse);
//	}
//
//	public String getLoggedInUserName() {
//		return userNameForExternalUse;
//	}
//
//}
//
