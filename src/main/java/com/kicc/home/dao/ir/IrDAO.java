package com.kicc.home.dao.ir;

import com.kicc.home.ir.vo.IrLetter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IrDAO {
    List<IrLetter> findPagedIrLetters(int offset, int limit, String searchType, String keyword);
    int insertIrLetter(IrLetter irLetter);
    int updateIrLetter(IrLetter irLetter);
    int deleteIrLetter(Long idx);
    int updateHits(Long idx);
    IrLetter findByIdx(Long idx);
}

