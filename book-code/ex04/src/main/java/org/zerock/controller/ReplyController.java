package org.zerock.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import javax.xml.ws.Response;
import java.util.List;

@RequestMapping("/reply")
@RestController
@Log4j
@AllArgsConstructor
public class ReplyController {

    private ReplyService service;

    @PostMapping(value = "/new")
    public ResponseEntity<String> create(@RequestBody ReplyVO vo) {
        log.debug("reply...." + vo);
        int insertCount = service.register(vo);
        return insertCount == 1 ?
                new ResponseEntity<>("success", HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "/pages/{bno}/{page}")
    public ResponseEntity<List<BoardVO>> getList(@PathVariable("bno") Long bno,
                                                 @PathVariable("page") int page) {
        log.debug("getList........");
        Criteria cri = new Criteria(page, 10);
        return new ResponseEntity(service.getList(cri, bno), HttpStatus.OK);
    }

    @GetMapping(value = "/{rno}",
            produces = {MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno) {
        log.info("rno....." + rno);
        return new ResponseEntity<>(service.get(rno), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{rno}",
            produces = {MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<String> delete(@PathVariable("rno") Long rno) {
        return service.remove(rno) == 1 ?
                new ResponseEntity<>("success", HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @PutMapping(value = "/{rno}")
//    @PatchMapping(value = "/{rno}")
    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
            value = "/{rno}",
            consumes = "application/json",
            produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> modify(@PathVariable("rno") Long rno, @RequestBody ReplyVO vo) {
        vo.setRno(rno);
        return service.modify(vo) == 1 ?
                new ResponseEntity<>("success", HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
