package com.kicc.home.ir.Service;

import com.kicc.home.ir.vo.IrLetter;

import java.util.List;

public interface IrService {

    public List<IrLetter> getPagedIrLetters(int page, int size, String searchType, String keyword);
    public IrLetter insert(IrLetter irLetter);
    public IrLetter update(IrLetter irLetter);
    public IrLetter findByIdx(Long idx);
    public int updateHits(Long idx);
    public boolean delete(Long idx);
}
