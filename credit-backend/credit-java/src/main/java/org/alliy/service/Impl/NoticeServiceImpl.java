package org.alliy.service.Impl;

import org.alliy.mapper.NoticeMapper;
import org.alliy.pojo.Notice;
import org.alliy.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper mapper;

    @Override
    public List<Notice> selectAll() {
        return mapper.selectList(null);
    }
}
