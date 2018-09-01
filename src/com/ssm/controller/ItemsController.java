package com.ssm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.domain.Items;
import com.ssm.service.ItemsService;

@Controller
@RequestMapping("/items")
public class ItemsController {
	@Resource
	private ItemsService itemsService;

	// 查询所有商品
	@RequestMapping("list")
	public String list(Model model) {
		List<Items> list = itemsService.findAll();
		model.addAttribute("itemsList", list);
		return "itemsList";
	}

	//跳转到修改页面
	@RequestMapping("edit")
	public String edit(Integer id, Model model) {
		
		//根据id查询商品
		Items items = itemsService.findByID(id);
		//页面回显
		model.addAttribute("item", items);
		return "editItem";  //注意大小写，和jsp的一致
	}
	
	@RequestMapping("saveOrUpdate")
	public String saveOrUpdate(Items items){
		
		itemsService.saveOrUpdate(items);
		
		return "redirect:list.do";
	}
	
	//根据Id进行删除
	@RequestMapping("deleteByID")
	public String deleteByID(Integer id)
	{
		itemsService.deleteByID(id);
		
		return "redirect: list.do";
	}
	
	//批量删除
	@RequestMapping("deleteByIds")
	public String deleteByIds(Integer[] id){
		
		for(Integer ids : id){
			
			itemsService.deleteByID(ids);
		}
		
		
		return "redirect: list.do";
	}
	

}

