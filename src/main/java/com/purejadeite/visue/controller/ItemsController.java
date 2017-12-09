/* */
package com.purejadeite.visue.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.purejadeite.visue.service.SampleService;

@RestController
@RequestMapping("items")
public class ItemsController extends AbstractController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ItemsController.class);

	@Autowired
	private SampleService service;

	// 複数件取得
	@RequestMapping(method = GET)
	@ResponseStatus(OK)
	public @ResponseBody
	List<Map<String, Object>> get(@RequestParam Map<String, Object> request) {
		return null;
	}

	// 複数件登録
	@RequestMapping(method = POST)
	@ResponseStatus(OK)
	public @ResponseBody
	List<Map<String, Object>> post(@RequestBody List<Map<String, Object>> request) {
		return null;
	}

	// 複数件更新
	@RequestMapping(method = PUT)
	@ResponseStatus(OK)
	public @ResponseBody
	List<Map<String, Object>> put(@RequestBody List<Map<String, Object>> request) {
		return null;
	}

	// 複数件削除
	@RequestMapping(method = PUT)
	@ResponseStatus(OK)
	public @ResponseBody
	List<Map<String, Object>> delete(@RequestBody List<Map<String, Object>> request) {
		return null;
	}
	
}
