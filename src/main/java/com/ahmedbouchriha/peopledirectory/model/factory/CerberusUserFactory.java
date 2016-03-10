package com.ahmedbouchriha.peopledirectory.model.factory;

import org.springframework.security.core.authority.AuthorityUtils;

import com.ahmedbouchriha.peopledirectory.domain.User;
import com.ahmedbouchriha.peopledirectory.model.security.CerberusUser;

public class CerberusUserFactory {

  public static CerberusUser create(User user) {
    return new CerberusUser(
      user.getId(),
      user.getUsername(),
      user.getPassword(),
      user.getEmail(),
      user.getLastPasswordReset(),
      AuthorityUtils.commaSeparatedStringToAuthorityList(user.getAuthorities())
    );
  }

}
