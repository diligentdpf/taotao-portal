package diao.taotao.portal.service;

import diao.taotao.pojo.TbUser;

public interface UserService {
	/** 调用sso系统的服务，根据token取用户信息 */
	public TbUser getUserByToken(String token);
}
