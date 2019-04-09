package com.organOld.dao.repository.visual;

import com.organOld.dao.entity.visual.Visual;
import com.organOld.dao.util.Page;

public interface VisualViewDao {
    Long  getVisualSizeByView(Visual visual);

    Long getSizeByPage(Page page);

}
