package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.entites.Dept;

@RestController
@EnableEurekaClient
public class DeptControllerConsumer {
	
	//private static final String REST_URL_PREFIX="http://localhost:8001/";
	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT/";
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/consumer/get/{id}")
	public Dept get(@PathVariable int id) {
		return restTemplate.getForObject(REST_URL_PREFIX+"dept/get/"+id, Dept.class);
	}
	
	@RequestMapping(value="/consumer/add")
	public Boolean add(Dept dept) {
		return restTemplate.postForObject(REST_URL_PREFIX+"dept/add",dept, Boolean.class);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/consumer/list")
	public List<Dept> list(){
		return restTemplate.getForObject(REST_URL_PREFIX+"dept/list", List.class);
	}
	
	
	@RequestMapping(value="/consumer/dept/discovery")
	public Object discovery(){
		return restTemplate.getForObject(REST_URL_PREFIX+"dept/discovery", Object.class);
	}
}
