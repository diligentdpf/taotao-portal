package diao.taotao.portal.service;

import diao.taotao.portal.pojo.SearchResult;

public interface SearchService {
	public SearchResult search(String queryString, int page);
}
