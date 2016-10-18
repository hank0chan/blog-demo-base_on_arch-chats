package cn.hankchan.data.article.entity;

/**
 * 文章实体类 
 * @author hankChan
 * @Email hankchan101@gmail.com
 * @time 17 Oct 2016-09:17:24
 * @detail
 */
public class Article {
	
	/** id */
	public String articleId;
	/** 文章名 */
	public String name;
	/** 文章内容 */
	public String content;
	/** 创建时间 */
	public String createTime;
	/** 最后更新时间 */
	public String updateTime;
	/** 其他备注 */
	public String tips;
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", name=" + name + ", content=" + content + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", tips=" + tips + "]";
	}
	
}
