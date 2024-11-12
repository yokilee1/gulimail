package com.atguigu.gulimall.product.service;

import com.atguigu.gulimall.product.vo.ItemSaleAttrVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.SkuSaleAttrValueEntity;

import java.util.List;
import java.util.Map;

/**
 * sku销售属性&值
 *
 * @author hh
 * @email 55333@qq.com
 * @date 2020-06-23 20:09:14
 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<ItemSaleAttrVo> getSaleAttrsBuSpuId(Long spuId);

    List<String> getSkuSaleAttrValuesAsStringList(Long skuId);
}

