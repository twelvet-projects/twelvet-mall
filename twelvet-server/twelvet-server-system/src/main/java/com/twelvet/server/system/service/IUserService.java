package com.twelvet.server.system.service;

import com.twelvet.api.system.domain.User;

import java.util.List;

/**
 * 客户Service接口
 *
 * @author TwelveT
 * @WebSite twelvet.cn
 * @date 2023-07-19
 */
public interface IUserService {

	/**
	 * 查询客户
	 * @param username 客户账号
	 * @return 客户
	 */
	public User selectUserByUsername(String username);

	/**
	 * 查询客户
	 * @param id 客户主键
	 * @return 客户
	 */
	public User selectUserById(Long id);

	/**
	 * 查询客户列表
	 * @param user 客户
	 * @return 客户集合
	 */
	public List<User> selectUserList(User user);

	/**
	 * 新增客户
	 * @param user 客户
	 * @return 结果
	 */
	public int insertUser(User user);

	/**
	 * 修改客户
	 * @param user 客户
	 * @return 结果
	 */
	public int updateUser(User user);

	/**
	 * 批量删除客户
	 * @param ids 需要删除的客户主键集合
	 * @return 结果
	 */
	public int deleteUserByIds(Long[] ids);

	/**
	 * 删除客户信息
	 * @param id 客户主键
	 * @return 结果
	 */
	public int deleteUserById(Long id);

}
