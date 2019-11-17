package top.neng.service.serviceImpl;

import top.neng.dao.Xx1dao;
import top.neng.entity.Xxx;
import top.neng.service.XxService;

import java.util.List;

public class XxServiceImpl implements XxService {
    private Xx1dao xx1dao;

    public void setXx1dao(Xx1dao xx1dao) {
        this.xx1dao = xx1dao;
    }

    @Override
    public int insert(Xxx xxx) { return xx1dao.insert(xxx); }

    @Override
    public int deleteById(String id) { return xx1dao.deleteById(id); }

    @Override
    public int update(Xxx xxx) { return xx1dao.update(xxx); }
    @Override
    public Xxx findById(String id) { return xx1dao.findById(id); }

    @Override
    public List<Xxx> findAll() { return xx1dao.findAll(); }
}
