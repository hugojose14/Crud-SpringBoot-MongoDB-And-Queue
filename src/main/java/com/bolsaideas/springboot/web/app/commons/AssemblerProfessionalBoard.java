package com.bolsaideas.springboot.web.app.commons;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.bolsaideas.springboot.web.app.domain.dto.ProfessionalBoardDTO;
import com.bolsaideas.springboot.web.app.domain.model.ProfessionalBoard;

public class AssemblerProfessionalBoard {

	public static ProfessionalBoard convertToEntity(ProfessionalBoardDTO ProfessionalBoardDto) {

		ProfessionalBoard ProfessionalBoard = new ProfessionalBoard();
		BeanUtils.copyProperties(ProfessionalBoardDto, ProfessionalBoard);
		return ProfessionalBoard;

	}

	public static List<ProfessionalBoard> convertAllEntity(List<ProfessionalBoardDTO> ProfessionalBoardDTOList) {
		if (ProfessionalBoardDTOList.isEmpty()) {
			throw new RuntimeException("La Lista no puede estar vacia");
		}

		List<ProfessionalBoard> ProfessionalBoardList = new ArrayList<ProfessionalBoard>();
		ProfessionalBoardDTOList.forEach(input -> {
			ProfessionalBoardList.add(convertToEntity(input));
		});

		return ProfessionalBoardList;

	}

	public static ProfessionalBoardDTO converDto(ProfessionalBoard ProfessionalBoard) {
		ProfessionalBoardDTO ProfessionalBoardDto = new ProfessionalBoardDTO();
		BeanUtils.copyProperties(ProfessionalBoard, ProfessionalBoardDto);
		return ProfessionalBoardDto;
	}

	public static List<ProfessionalBoardDTO> convertAllToDto(List<ProfessionalBoard> ProfessionalBoardList) {
		if (ProfessionalBoardList.isEmpty()) {
			throw new RuntimeException("La Lista no puede estar vacia");
		}
		List<ProfessionalBoardDTO> ProfessionalBoardDtoList = new ArrayList<ProfessionalBoardDTO>();
		ProfessionalBoardList.forEach(input -> {
			ProfessionalBoardDtoList.add(converDto(input));
		});

		return ProfessionalBoardDtoList;

	}

}
