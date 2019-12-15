package org.ggyool.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.ggyool.domain.SampleVO;
import org.ggyool.domain.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {
	
	@GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
	public String getText() {
		log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);
		// jsp 파일 이름이 아닌 순수한 문자열
		return "ㅇㄶㅅㅇ";
	}
	
	@GetMapping(value = "/getSample", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.APPLICATION_XML_VALUE,})
	public SampleVO getSample() {
		return new SampleVO(112, "스tar", "lo드");
	}
	
	@GetMapping(value = "/getSample2")
	public SampleVO getSample2() {
		return new SampleVO(113, "로켓", "라쿤");
	}
	
	@GetMapping(value = "/getList")
	public List<SampleVO> getList(){
		return IntStream.range(1,10).mapToObj(i -> new SampleVO(i, i + "First", i + "Last"))
				.collect(Collectors.toList());
	}
	
	@GetMapping(value = "/getMap")
	public Map<String, SampleVO> getMap(){
		Map<String, SampleVO> map = new HashMap<>();
		map.put("First", new SampleVO(111, "그룻", "주니"));
		return map;
	}
	
	@GetMapping(value = "/check", params = {"height", "weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		SampleVO vo = new SampleVO(0, ""+height, ""+weight);
		ResponseEntity<SampleVO> result = null;
		if(height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		return result;
	}
	
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, 
			@PathVariable("pid") Integer pid) {
		return new String[] {"category: " + cat, "productid: " + pid};
	}
			
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		// Ticket class
		//log.info(ticket.getClass()); 
		log.info("convert ticket: " + ticket);
		return ticket;
	}
}


