package cn.hankchan.dao.mybatis;

import cn.hankchan.data.article.entity.Article;
import cn.hankchan.data.root.entity.Root;
import cn.hankchan.data.user.entity.User;

public class DataRepository extends MybatisRepository {

	@Override
	public void init() {
		init(User.class, Article.class, Root.class);
	}

}
