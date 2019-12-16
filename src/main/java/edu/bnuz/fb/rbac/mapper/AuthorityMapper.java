package edu.bnuz.fb.rbac.mapper;

import edu.bnuz.fb.rbac.entity.Authority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface  AuthorityMapper {

    public void addAuthority(Authority authority);

    public void updateAuthority(Authority authority);

    public List<Authority> queryAuthList(Authority authority);
}
