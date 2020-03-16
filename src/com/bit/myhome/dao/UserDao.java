package com.bit.myhome.dao;

import java.util.List;

import com.bit.myhome.vo.UserVO;

public interface UserDao {
	public List<UserVO> getLiST();
	public boolean insert(UserVO vo); //필수
	public boolean update(UserVO vo);
	public boolean delete(Long no);
	public UserVO getUserByIdAndPassword(String email, String password); //필수
}
