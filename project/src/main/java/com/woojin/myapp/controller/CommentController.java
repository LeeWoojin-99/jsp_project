package com.woojin.myapp.controller;


import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woojin.myapp.domain.CommentVO;
import com.woojin.myapp.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/comment/*")
@Controller
public class CommentController {
	@Inject
	private CommentService csv;
	
	private int isOK;
	
	@PostMapping(value = "/", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> postPost(@RequestBody CommentVO cvo){
		isOK = csv.insert(cvo);
		log.info("isOK : "+(isOK>0?"성공":"실패"));
		return isOK>0? new ResponseEntity<String>("1", HttpStatus.OK): new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value="{bno}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<CommentVO>> listGet(@PathVariable("bno")int bno) {
		List<CommentVO> list = csv.list(bno);
		return isOK>0? new ResponseEntity<List<CommentVO>>(list, HttpStatus.OK): new ResponseEntity<List<CommentVO>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping(value = "/", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modifyPut(@RequestBody CommentVO cvo){
		isOK = csv.update(cvo);
		log.info("isOK : "+(isOK>0?"성공":"실패"));
		return isOK>0? new ResponseEntity<String>("1", HttpStatus.OK): new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping(value = "{cno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> removeDelete(@PathVariable("cno")int cno){
		isOK = csv.delete(cno);
		log.info("isOK : "+(isOK>0?"성공":"실패"));
		return isOK>0? new ResponseEntity<String>("1", HttpStatus.OK): new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
