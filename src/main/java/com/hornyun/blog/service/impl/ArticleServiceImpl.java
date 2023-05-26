package com.hornyun.blog.service.impl;

import com.hornyun.blog.entity.Article;
import com.hornyun.blog.mapper.ArticleMapper;
import com.hornyun.blog.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客文章表 服务实现类
 * </p>
 *
 * @author HornYun
 * @since 2023-05-24
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
