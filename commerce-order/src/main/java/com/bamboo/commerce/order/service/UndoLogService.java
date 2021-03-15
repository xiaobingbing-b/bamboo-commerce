package com.bamboo.commerce.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bamboo.common.utils.PageUtils;
import com.bamboo.commerce.order.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author tangbing
 * @email tangbing@gmail.com
 * @date 2021-03-15 17:18:55
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

