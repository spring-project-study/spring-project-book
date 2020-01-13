package org.zerock.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.domain.SampleVO;
import org.zerock.domain.Ticket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {

    @GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
    public String getText() {
        return "Hi";
    }

    @GetMapping(value = "/getSample",
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public SampleVO getSample() {
        return new SampleVO(123, "sample", "return");
    }

    @GetMapping(value = "/getSample2")
    public SampleVO getSample2() {
        return new SampleVO(123, "sample", "return");
    }

    @GetMapping(value = "/getList")
    public List<SampleVO> getList() {
        return IntStream.range(1, 10).mapToObj(i -> new SampleVO(i, i + " First", i + "last")).collect(Collectors.toList());
    }

    @GetMapping(value = "/getMap")
    public Map<String, SampleVO> getMap() {
        Map<String, SampleVO> map = new HashMap<>();
        map.put("First", new SampleVO(1, "first", "last"));
        return map;
    }

    @GetMapping(value = "/check", params = {"height", "weight"})
    public ResponseEntity<SampleVO> check(Double height, Double weight) {
        SampleVO vo = new SampleVO(0, String.valueOf(height), "" + weight);
        ResponseEntity<SampleVO> result = null;
        if (height < 150) {
            result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
        } else {
            result = ResponseEntity.status(HttpStatus.OK).body(vo);
        }

        return result;
    }

    @GetMapping(value = "/product/{cat}/{pid}")
    public String[] getPath(@PathVariable("cat") String cat,
                            @PathVariable("pid") String pid) {
        return new String[]{"category: "+cat, "productId: "+ pid};
    }

    @PostMapping("/ticket")
    public Ticket convert(@RequestBody Ticket ticket) {
        System.out.println(ticket);
        return ticket;
    }
}
