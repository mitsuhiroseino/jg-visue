/* */
package com.purejadeite.visue.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.purejadeite.visue.service.SampleService;

@RestController
@RequestMapping("item")
public class ItemController extends AbstractController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

	@Autowired
	private SampleService service;

	// 1件取得
	@RequestMapping(value = "{id}", method = GET)
	@ResponseStatus(OK)
	public @ResponseBody Map<String, Object> get(@PathVariable String id) {
		return null;
	}

	// 1件登録
	@RequestMapping(value = "{id}", method = POST)
	@ResponseStatus(OK)
	public @ResponseBody Map<String, Object> post(@PathVariable String id, @RequestBody Map<String, Object> request) {
		return null;
	}

	// 1件更新
	@RequestMapping(value = "{id}", method = PUT)
	@ResponseStatus(OK)
	public @ResponseBody Map<String, Object> put(@PathVariable String id, @RequestBody Map<String, Object> request) {
		return null;
	}

	// 1件削除
	@RequestMapping(value = "{id}", method = DELETE)
	@ResponseStatus(OK)
	public @ResponseBody Map<String, Object> delete(@PathVariable String id) {
		return null;
	}
	
}
