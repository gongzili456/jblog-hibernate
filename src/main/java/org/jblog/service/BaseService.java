package org.jblog.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {
	/**
	 * 保存对象到数据库,base method
	 * 
	 * @param t
	 *            被保存的对象
	 * @return 返回已保存的对象的ID
	 */
	Serializable save(T t);

	/**
	 * 更新对象到数据库,base method
	 * 
	 * @param t
	 *            要更新的对象
	 * @return 返回是否更新成功
	 */
	boolean update(T t);

	/**
	 * 获取对象从数据库,base method
	 * 
	 * @param id
	 *            要查询对象的ID
	 * @return 返回对象的实例
	 */
	T get(Serializable id);

	/**
	 * 获取对象从hibernate缓存,base method
	 * 
	 * @param id
	 *            要查询对象的ID
	 * @return 返回对象的实例
	 */
	T load(Serializable id);

	/**
	 * 获取数据的总条数,base method
	 */
	long count();

	/**
	 * 获取对象实例的列表，分页,base method
	 * 
	 * @param page
	 *            起始页，应该大于等于1
	 * @param size
	 *            每页的条数，应该大于等于1
	 * @return
	 */
	List<T> list(int page, int size);

	/**
	 * 获取对象实例的列表，分页,base method
	 * 
	 * @return
	 */
	List<T> list();

	/**
	 * 删除对象数据从数据库,base method
	 * 
	 * @param id
	 *            要删除数据对象的ID
	 * @return 返回删除是否成功
	 */
	boolean delete(Serializable id);

}
