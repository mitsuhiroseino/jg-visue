/* */
package com.purejadeite.visue.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class AbstractController {

	private Logger logger = LoggerFactory.getLogger(AbstractController.class);

	/**
	 * 入力チェックエラーの場合の例外ハンドラ
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody
	Map<String, Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletResponse httpServletResponse) {
		Map<String, Object> response = new HashMap<>();
		// 例外から処理結果を取得
		BindingResult result = e.getBindingResult();
		// 入力データ
		response.put("data", result.getTarget());
		// エラー情報
		List<Map<String, Object>> errors = new ArrayList<>();
		for (FieldError fieldError : result.getFieldErrors()) {
			Map<String, Object> error = new HashMap<>();
			error.put("msg", fieldError.getDefaultMessage());
			error.put("args", fieldError.getArguments());
			errors.add(error);
		}
		response.put("errors", errors);
		logger.info("入力チェックエラーが発生しました。");
		return response;
	}

	/**
	 * リソースがなかった場合の例外ハンドラ
	 */
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public Map<String, Object> handleResourceNotFoundException(NotFoundException e,
			HttpServletResponse httpServletResponse) {
		logger.info("対象のリソースがありませんでした。");
		Map<String, Object> response = new HashMap<>();
		response.put("success", Boolean.FALSE);
		return response;
	}

	/**
	 * その他の例外ハンドラ
	 * @throws Exception
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "for other exceptions.")
	public void handleException(Exception e,
			HttpServletResponse response) throws Exception {
		logger.error("例外が発生しました。", e);
		throw e;
	}

	/**
	 * リソースがなかった場合の例外
	 */
	protected static class NotFoundException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1952891518630364681L;
	}

	// リクエストから削除するパラメーター
	private static final String[] SENCHA_PARAMS = {"_dc", "limit", "page", "start"};

	// リクエストから削除するパラメーターを削除
	protected Map<String, Object> cleanRequest(Map<String, Object> request) {
		if (request != null) {
			for (String param : SENCHA_PARAMS) {
				request.remove(param);
			}
		} else {
			request = new HashMap<>();
		}
		return request;
	}

	protected Map<String, Object> mergeMultipartFiles(Map<String, Object> request, HttpServletRequest httpServletRequest) {
		if (httpServletRequest instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) httpServletRequest;
			MultiValueMap<String, MultipartFile> multiValueMap = multipartHttpServletRequest.getMultiFileMap();
			if (multiValueMap != null) {
				for (String key : multiValueMap.keySet()) {
					List<MultipartFile> multipartFiles = multiValueMap.get(key);
					if (multipartFiles.size() == 1 && !key.endsWith("]")) {
						request.put(key, multipartFiles.get(0));
					} else if (1 < multipartFiles.size()) {
						request.put(key, multipartFiles);
					}
				}
			}
		}
		return request;
	}

}
