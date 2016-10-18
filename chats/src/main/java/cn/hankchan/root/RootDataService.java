package cn.hankchan.root;

import cn.hankchan.data.root.entity.Root;

public interface RootDataService {

	public Root get(String root);
	public Root count(String root, String password, String phone);
	public Root update(Root root);
	public int delete(String root, String password);
}
