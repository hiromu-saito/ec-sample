package com.example.ecdomain.dao;

import com.example.ecdomain.dto.Member;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface MemberDao {

    @Select
    Member selectByMemNo(int memNo);

    @Select
    int getLatestMemNo();

    @Insert(sqlFile = true, exclude = {"deleteFlg"})
    int insert(Member member);
}
