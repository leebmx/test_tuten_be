package com.empleado.empleado.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponse {
	
	private String serviceData;
	private String userAvailability;
	private String sessionTokenBck;
	private String firstName;
	private String lastName;
	private String email;
	private String active;
	private String passwordHash;
	private String sessionTokenWeb;
	private String phoneNumber;
	private String agreedToTermsOfUse;
	private String whereKnownUs;
	private String lastLogin;
	private String sessionTokenCli;
	private String sessionTokenPro;
	private String funds;
	private String tokenFacebook;
	private String tokenGoogle;
	private String tokensIonic;
	private String photoPath;
	private String photoExt;
	private String sync;
	private String usedCodeList;
	private String referrer;
	private String rut;
	private String domain;
	private String typeProfessional;
	private String tutenSubRole;
	private String userId;
	private String appVersion;
	private String estatus;

}
