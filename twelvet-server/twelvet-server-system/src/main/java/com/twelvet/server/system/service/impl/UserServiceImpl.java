package com.twelvet.server.system.service.impl;

import java.util.List;

import com.twelvet.api.system.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.twelvet.framework.security.utils.SecurityUtils;
import org.springframework.stereotype.Service;
import com.twelvet.server.system.mapper.UserMapper;
import com.twelvet.server.system.service.IUserService;

/**
 * 客户Service业务层处理
 *
 * @author TwelveT
 * @WebSite twelvet.cn
 * @date 2023-07-19
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User selectUserByUsername(String username) {
		return userMapper.selectUserByUsername(username);
	}

	/**
	 * 查询客户
	 * @param id 客户主键
	 * @return 客户
	 */
	@Override
	public User selectUserById(Long id) {
		return userMapper.selectUserById(id);
	}

	/**
	 * 查询客户列表
	 * @param user 客户
	 * @return 客户
	 */
	@Override
	public List<User> selectUserList(User user) {
		return userMapper.selectUserList(user);
	}

	/**
	 * 新增客户
	 * @param user 客户
	 * @return 结果
	 */
	@Override
	public int insertUser(User user) {
		return userMapper.insertUser(user);
	}

	/**
	 * 修改客户
	 * @param user 客户
	 * @return 结果
	 */
	@Override
	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}

	/**
	 * 批量删除客户
	 * @param ids 需要删除的客户主键
	 * @return 结果
	 */
	@Override
	public int deleteUserByIds(Long[] ids) {
		return userMapper.deleteUserByIds(ids);
	}

	/**
	 * 删除客户信息
	 * @param id 客户主键
	 * @return 结果
	 */
	@Override
	public int deleteUserById(Long id) {
		return userMapper.deleteUserById(id);
	}

}
