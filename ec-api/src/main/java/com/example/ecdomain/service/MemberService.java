package com.example.ecdomain.service;

import com.example.ecapi.member.MemberResource;
import com.example.ecdomain.dao.MemberDao;
import com.example.ecdomain.dto.Member;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    MemberDao memberDao;

    @Transactional
    public void register(MemberResource resource){
        Member member = modelMapper.map(resource,Member.class);
        memberDao.insert(member);
        resource.setMemNo(memberDao.getLatestMemNo());
    }
    @Transactional
    public void modify(MemberResource resource){
        Member member = modelMapper.map(resource,Member.class);
        memberDao.update(member);
    }

    @Transactional
    public void delete(MemberResource resource){
        int memNo = resource.getMemNo();
        memberDao.delete(memNo);
    }
}
