package com.woojin.myapp.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woojin.myapp.repository.FileDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/file/*")
@Controller
public class FileController {
	
	@Inject
	private FileDAO fdao;
	
	int isOK;
	@DeleteMapping(value = "{uuid}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> removeDelete(@PathVariable("uuid")String uuid){
		log.info("uuid : "+uuid);
		isOK = fdao.delete(uuid);
		return isOK>0? new ResponseEntity<String>("1", HttpStatus.OK): new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
