package com.lagou.biz;

import java.util.List;

import com.lagou.domain.Admins;
import com.lagou.domain.Funs;
import com.lagou.exception.NameMissException;
import com.lagou.exception.PassErrorException;

public interface AdminsBIZ {
	/**杨四龙
	 * 查找所有的管理员
	 * @return
	 */
	public List<Admins> findAll();
	
	/**杨四龙
	 * 保存管理员
	 * @param admins
	 */
	public void saveAdmins(Admins admins);
	
	/**杨四龙
	 * 按照编号删除管理员
	 * @param adminId
	 */
	public void delete(int  adminId);
	
	/**杨四龙
	 * 按照名字查找管理员
	 * @param AdminsName
	 * @return
	 */
	public Admins findByName(String AdminsName);
	
	/**杨四龙
	 * 通id查询一级列表同时加载二级列表
	 * @param id
	 * @return
	 */
	
	
	public List<Funs> findByRolesId(java.lang.Integer id);
	
	/**杨四龙
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 * @throws NameMissException
	 * @throws PassErrorException
	 */
	
	public List<Funs> findByLevel(Integer level);
	
	public Admins isLogin(String username, String password)throws NameMissException,PassErrorException;
}
