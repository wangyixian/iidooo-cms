package com.iidooo.cms.dao.extend;

import java.util.List;

import com.iidooo.cms.dto.extend.CmsTemplateDto;

public interface CmsTemplateDao {
    
    /**
     * 得到所有的模板
     * @return 模板列表
     */
    List<CmsTemplateDto> selectAll();
}
