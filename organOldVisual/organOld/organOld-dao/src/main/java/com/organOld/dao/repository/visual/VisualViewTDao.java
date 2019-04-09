package com.organOld.dao.repository.visual;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.visual.Visual;
import com.organOld.dao.util.Page;

import java.util.List;

public interface VisualViewTDao {
    Long  getVisualSizeByView(Visual visual);

    List<Oldman> getByPage(Page page);

    Long getSizeByPage(Page page);
}
