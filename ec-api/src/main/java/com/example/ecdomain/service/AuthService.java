package com.example.ecdomain.service;

import com.example.ecapi.auth.LoginForm;
import com.example.ecapi.member.MemberResource;
import com.example.eccommon.exception.AuthException;
import com.example.ecdomain.dao.MemberDao;
import com.example.ecdomain.dto.Member;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService {

    @Autowired
    MemberDao memberDao;

    @Autowired
    ModelMapper modelMapper;

    public MemberResource authCheck(LoginForm loginForm) throws Exception {
        int memNo = Integer.parseInt(loginForm.getMemNo());
        Member selectedMember = memberDao.selectByMemNo(memNo);

        if (Objects.isNull(selectedMember) || !selectedMember.getPassword().equals(loginForm.getPass())) {
            throw new AuthException("login failure");
        }
        return modelMapper.map(selectedMember,MemberResource.class);
    }
}
