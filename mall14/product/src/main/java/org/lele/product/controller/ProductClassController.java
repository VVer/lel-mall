package org.lele.product.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.lele.product.entity.ProductClass;
import org.lele.product.service.ProductClassService;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 商品类别(ProductClass)表控制层
 *
 * @author lele
 * @since 2020-05-25 20:43:28
 */
@RestController
@RequestMapping("productClass")
public class ProductClassController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ProductClassService productClassService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param productClass 查询实体
     * @return 所有数据
     */
    @ApiOperation("查看所有分类")
    @GetMapping
    public R selectAll(@ApiIgnore Page<ProductClass> page, ProductClass productClass) {
        return success(this.productClassService.page(page, new QueryWrapper<>(productClass)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.productClassService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param productClass 实体对象
     * @return 新增结果
     */
    @ApiOperation("新增商品分类")
    @PostMapping
    public R insert(@RequestBody ProductClass productClass) {
        return success(this.productClassService.save(productClass));
    }

    /**
     * 修改数据
     *
     * @param productClass 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ProductClass productClass) {
        return success(this.productClassService.updateById(productClass));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.productClassService.removeByIds(idList));
    }
}