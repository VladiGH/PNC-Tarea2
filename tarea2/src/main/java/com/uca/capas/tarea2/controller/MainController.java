package com.uca.capas.tarea2.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@RequestMapping("/alumno")
	public @ResponseBody String ejemplo() {
		String me = "André Vladimir González Hernández, 00103017. Ingeniería Informática, Cuarto Año.";
		return me;
	}
	
	@RequestMapping("/parametro")
	public @ResponseBody String parametro(HttpServletRequest request) {
		Integer dia = Integer.parseInt(request.getParameter("dia"));
		Integer mes = Integer.parseInt(request.getParameter("mes"));
		Integer annio = Integer.parseInt(request.getParameter("annio"));
		String result = dia +"/"+ mes+"/"+ annio;
		String day;
		try {
			Date dateCompare = new SimpleDateFormat("dd/MM/yyyy").parse(result);
			SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
			day ="El día de la semana según la fecha es: " + simpleDateformat.format(dateCompare);
		} catch (ParseException e) {
			return result = "Ingresa solo numeros en los parámetros";
		}
		return day;

	}
}
