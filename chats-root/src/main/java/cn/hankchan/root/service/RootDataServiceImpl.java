package cn.hankchan.root.service;

import cn.hankchan.dao.mybatis.DataRepository;
import cn.hankchan.data.root.entity.Root;
import cn.hankchan.root.RootDataService;
import cn.hankchan.webchats.lang.Criteria;

public class RootDataServiceImpl implements RootDataService {

	DataRepository dataRepository;
	public void setDataRepository(DataRepository dataRepository) {
		this.dataRepository = dataRepository;
	}
	
	@Override
	public Root get(String root) {
		return dataRepository.get("get", Root.class, root);
	}

	@Override
	public Root count(String root, String password, String phone) {
		return dataRepository.get("count", Root.class, new Criteria().with("root", root).with("password", password).with("phone", phone));
	}

	@Override
	public Root update(Root root) {
		return dataRepository.update(root);
	}

	@Override
	public int delete(String root, String password) {
		return dataRepository.delete(Root.class, new Criteria().with("root", root).with("password", password));
	}

}
