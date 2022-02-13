package com.manhpv.api;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manhpv.api.output.WorkOutput;
import com.manhpv.dto.WorkDto;
import com.manhpv.service.IWorkService;
import com.manhpv.util.CommonUtil;

@RestController
public class workApi {
	@Autowired
	private IWorkService workService;
	
	@GetMapping("/api/test") 
	public JSONObject testApi(){
		
		return new JSONObject("{'Manh':'11123'}");
	}
	
	
	
	
	/*
	 * @PostMapping(value = "/work") public WorkDto createUser(@RequestBody WorkDto
	 * model) { return workService.save(model); }
	 */
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(value = "/work")
	public String createWork(@RequestBody String json) {
		
		JSONObject joResult = CommonUtil.createJsonDeFault();
		JSONObject joData;
		try {
			joData = new JSONObject(json);
		} catch (Exception e) {
			joResult.put("error", 1);
			joResult.put("message", "Du lieu khong dung ding dang json");
			return joResult.toString();
		}
		
		if(CommonUtil.validateWork(joData)) {
			WorkDto workDto = new WorkDto();
			workDto.setWorkName(joData.getString("workName"));
			workDto.setStartDate(CommonUtil.stringToDate(joData.getString("startDate")));
			workDto.setEndDate(CommonUtil.stringToDate(joData.getString("endDate")));
			workDto.setStatus(joData.getInt("status"));
			
			workDto = workService.save(workDto);
			if(workDto.getId() == 0) {
				joResult.put("error", 3);
				joResult.put("message", "Them du lieu khong thanh cong");
				return joResult.toString();
			}
			joResult.put("id", workDto.getId());
			return joResult.toString();
			
		}else {
			joResult.put("error", 2);
			joResult.put("message", "Du lieu chu day du hoac dung");
			return joResult.toString();
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping(value = "/work/{id}")
	public String updateWork(@RequestBody String json, @PathVariable("id") long id) {
		
		JSONObject joResult = CommonUtil.createJsonDeFault();
		JSONObject joData;
		try {
			joData = new JSONObject(json);
		} catch (Exception e) {
			joResult.put("error", 1);
			joResult.put("message", "Du lieu khong dung ding dang json");
			return joResult.toString();
		}
		System.out.println("json:  "+ json.toString());
		if(CommonUtil.validateWork(joData)) {
			WorkDto workDto = new WorkDto();
			workDto.setWorkName(joData.getString("workName"));
			workDto.setStartDate(CommonUtil.stringToDate(joData.getString("startDate")));
			workDto.setEndDate(CommonUtil.stringToDate(joData.getString("endDate")));
			workDto.setStatus(joData.getInt("status"));
			workDto.setId(id);
			
			workDto = workService.save(workDto);
			if(workDto.getId() == 0) {
				joResult.put("error", 3);
				joResult.put("message", "Them du lieu khong thanh cong");
				return joResult.toString();
			}
			joResult.put("id", workDto.getId());
			return joResult.toString();
			
		}else {
			joResult.put("error", 2);
			joResult.put("message", "Du lieu chu day du hoac dung");
			return joResult.toString();
		}
		
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping(value = "/work/{id}")
	public String deleteWork(@PathVariable("id") long id) {
		JSONObject joResult = CommonUtil.createJsonDeFault();
		if(workService.delete(id) == 0)	{
			joResult.put("error", 3);
			joResult.put("message", "Xoa khong thanh cong");
		}
		return joResult.toString();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value = "/work")
	public WorkOutput getUser(@RequestParam(value = "page", required = false) Integer page, 
			@RequestParam(value="limit", required = false) Integer limit, 
			@RequestParam(value = "sort", required = false) String sort) {
		if(page == null || limit ==  null) {
			page = 1;
			limit = workService.totalItem();
		}
		if(sort == null)
			sort = "name";
		else if(sort.equals(""))
			sort = "name";
		WorkOutput output = new WorkOutput();
		output.setPage(page);
		Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(sort));
		output.setList(workService.findAll(pageable));
		output.setTotalPage((int) Math.ceil((double)(workService.totalItem())/limit));
		return output;
	}
	
}
