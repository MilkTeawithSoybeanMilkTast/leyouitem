package com.leyou.goods.cotroller;

import com.leyou.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Create By FANZHIBO on 2021/5/11.
 */

@Controller
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 跳转到商品详情页
     * @param model
     * @param id
     * @return
     */
    @GetMapping("item/{id}.html")
    public String toItemPage(Model model, @PathVariable("id")Long id){
        // 加载所需的数据
        Map<String, Object> map = this.goodsService.loadData(id);
        // 放入模型
        model.addAllAttributes(map);
        return "item";
    }
}
