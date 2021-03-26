package com.example.ecdomain.dao;

import com.example.ecdomain.dto.Member;
import org.seasar.doma.*;
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

    @Update(sqlFile = true)
    int update(Member member);

    @Update(sqlFile = true)
    int logicalDelete(int memNo);

}
