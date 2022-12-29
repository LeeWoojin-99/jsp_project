package com.woojin.myapp.repository;

import java.util.List;

import com.woojin.myapp.domain.FileVO;

public interface FileDAO {

	int insert(FileVO fvo);

	List<FileVO> selectOne(int bno);

	int update(FileVO fvo);

	int delete(String uuid);


}
