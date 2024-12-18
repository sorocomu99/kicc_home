package com.kicc.home.ir.Service;

import com.kicc.home.dao.ir.IrDAO;
import com.kicc.home.ir.vo.IrLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IrServiceImpl implements IrService {

    @Autowired
    private IrDAO irDAO;

    @Override
    public List<IrLetter> getPagedIrLetters(int page, int size, String searchType, String keyword) {
        int offset = (page - 1) * size;
        return irDAO.findPagedIrLetters(offset, size, searchType, keyword);
    }

    public IrLetter insert(IrLetter irLetter) {
        irDAO.insertIrLetter(irLetter);
        return irLetter;
    }

    public IrLetter update(IrLetter irLetter) {
        irDAO.updateIrLetter(irLetter);
        return irLetter;
    }

    @Override
    public IrLetter findByIdx(Long idx) {
        return irDAO.findByIdx(idx);
    }

    @Override
    public int updateHits(Long idx) {
        return irDAO.updateHits(idx);
    }

    @Override
    public boolean delete(Long idx) {
        return irDAO.deleteIrLetter(idx) > 0;
    }
}
