package com.bolsaideas.springboot.web.app.commons;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import com.bolsaideas.springboot.web.app.domain.dto.HugoDto;
import com.bolsaideas.springboot.web.app.domain.model.Hugo;

public class AssemblerHugo {
	
	public static Hugo convertToEntity(HugoDto hugoDto) {
		
		Hugo hugo = new Hugo();
		BeanUtils.copyProperties(hugoDto, hugo);
		return hugo;
		
	}
	
	public static List<Hugo> convertAllEntity(List<HugoDto> hugoDTOList){
		if(hugoDTOList.isEmpty()) {
			throw new RuntimeException("La Lista no puede estar vacia");
		}
		
		List<Hugo> hugoList = new ArrayList<Hugo>();
		hugoDTOList.forEach(input -> {
			hugoList.add(convertToEntity(input));
		});
		
		return hugoList;
		
	}
	
	public static HugoDto converDto (Hugo hugo) {
		HugoDto hugoDto = new HugoDto();
		BeanUtils.copyProperties(hugo, hugoDto);
		return hugoDto;
	}
	
	public static List<HugoDto> convertAllToDto(List<Hugo> hugoList){
		if(hugoList.isEmpty()) {
			throw new RuntimeException("La Lista no puede estar vacia");
		}
		List<HugoDto> hugoDtoList = new ArrayList<HugoDto>();
		hugoList.forEach(input -> {
			hugoDtoList.add(converDto(input));
		});
		
		return hugoDtoList;
		
	}

	
	
	
	
}
