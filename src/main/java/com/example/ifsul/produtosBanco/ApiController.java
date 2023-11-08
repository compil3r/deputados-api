package com.example.ifsul.produtosBanco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
public class ApiController {
	
	@Autowired
	private ApiService apiService;
	@Autowired
	private DeputadoService depService;
	
	@GetMapping(value = "/data",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getData()  {
		String data = apiService.getData();
		return ResponseEntity.ok(data);
	}
	
	@GetMapping("/clone")
	public List<Deputado> clone() {
		String data = apiService.getData();
		
        JSONObject jsnobject = new JSONObject(data);  
        JSONArray jsonArray = jsnobject.getJSONArray("dados");  
        ArrayList<Object> listdata = new ArrayList<Object>();  
        
        for(int i = 0; i<10; i++) {
	        Deputado dep = new Gson().fromJson(jsonArray.get(i).toString(), Deputado.class);
	        depService.criar(dep);
        }
		return depService.listar();
	}
	
}
