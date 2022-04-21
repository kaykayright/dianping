package com.kaykay.dianping.service.impl;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 9:36 下午 2022/1/4.
 * @Modified By:
 */

import com.kaykay.dianping.common.BusinessException;
import com.kaykay.dianping.common.EmBussinessError;
import com.kaykay.dianping.dal.ShopModelMapper;
import com.kaykay.dianping.model.CategoryModel;
import com.kaykay.dianping.model.SellerModel;
import com.kaykay.dianping.model.ShopModel;
import com.kaykay.dianping.service.CategoryService;
import com.kaykay.dianping.service.SellerService;
import com.kaykay.dianping.service.ShopService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * todo
 *
 * @author hk
 * @version Id: ShopServiceImpl.java, v 0.1 2022/1/4 9:36 下午 Exp $$
 */
@Service
public class ShopServiceImpl  implements ShopService {

    @Autowired
    private ShopModelMapper shopModelMapper;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Override
    @Transactional
    public ShopModel create(ShopModel shopModel) throws BusinessException {

        shopModel.setCreatedAt(new Date());
        shopModel.setUpdatedAt(new Date());

        //校验商家是否存在正确
        SellerModel sellerModel = sellerService.get(shopModel.getSellerId());
        if(sellerModel == null){
            throw new BusinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR,"商户不存在");
        }
        if(sellerModel.getDisabledFlag() ==1 ){
            throw new BusinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR,"商户已禁用");
        }

        //校验类目
        CategoryModel categoryModel = categoryService.get(shopModel.getCategoryId());
        if(categoryModel == null){
            throw new BusinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR,"商品类目不存在");
        }


        shopModelMapper.insertSelective(shopModel);

        return get(shopModel.getId());
    }

    @Override
    public ShopModel get(Integer id) {

        ShopModel shopModel = shopModelMapper.selectByPrimaryKey(id);
        if(shopModel ==  null){
            return null;
        }
        shopModel.setSellerModel(sellerService.get(shopModel.getSellerId()));
        shopModel.setCategoryModel(categoryService.get(shopModel.getCategoryId()));

        return shopModel;

    }

    @Override
    public List<ShopModel> selectAll() {
        List<ShopModel> shopModelList = shopModelMapper.selectAll();
        shopModelList.forEach(shopModel -> {
            shopModel.setSellerModel(sellerService.get(shopModel.getSellerId()));
            shopModel.setCategoryModel(categoryService.get(shopModel.getCategoryId()));
        });

        return shopModelList;
    }

    @Override
    public Integer countAllShop() {
        return shopModelMapper.countAllShop();
    }

    @Override
    public List<ShopModel> recommend(BigDecimal longtitude, BigDecimal latitude) {
        List<ShopModel> shopModelList = shopModelMapper.recommend(longtitude,latitude);
        shopModelList.forEach(shopModel -> {
            shopModel.setSellerModel(sellerService.get(shopModel.getSellerId()));
            shopModel.setCategoryModel(categoryService.get(shopModel.getCategoryId()));
        });

        return shopModelList;
    }

    @Override
    public List<ShopModel> search(BigDecimal longtitude, BigDecimal latitude, String keyword,Integer orderby,
                                  Integer categoryId,String tags) {

        List<ShopModel> shopModelList = shopModelMapper.search(longtitude,latitude,keyword,orderby,categoryId,tags);
        shopModelList.forEach(shopModel -> {
            shopModel.setSellerModel(sellerService.get(shopModel.getSellerId()));
            shopModel.setCategoryModel(categoryService.get(shopModel.getCategoryId()));
        });

        return shopModelList;
    }

    @Override
    public List<Map<String, Object>> searchGroupByTags(String keyword, Integer categoryId, String tags) {
        return shopModelMapper.searchGroupByTags(keyword,categoryId,tags);
    }

    @Override
    public Map<String, Object> searchES(BigDecimal longtitude, BigDecimal latitude, String keyword, Integer orderby, Integer categoryId, String tags) throws IOException {

        Map<String,Object> result = new HashMap<>();

        SearchRequest  searchRequest = new SearchRequest("shop");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        List<Integer> shopIdList = new ArrayList<>();
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] hits = searchResponse.getHits().getHits();
        for(SearchHit hit : hits){

            shopIdList.add(new Integer((hit.getSourceAsMap().get("id").toString())));

        }

        List<ShopModel> shopModelList = shopIdList.stream().map(id->{return get(id);}).collect(Collectors.toList());

        result.put("shop",shopIdList);

        return result;
    }
}