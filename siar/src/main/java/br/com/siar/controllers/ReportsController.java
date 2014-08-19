/**
 * 
 */
package br.com.siar.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.siar.models.UsuarioSiar.TipoUsuario;
import br.com.siar.services.DownloadService;
import br.com.siar.utils.Const;

/**
 * @author Leo
 *
 */
@Controller
public class ReportsController extends BasicController implements ApplicationContextAware {

	@RequestMapping(value = RELATORIOS, method = RequestMethod.GET)
	public String formRelatorios(HttpServletRequest request, ModelMap model) {
		
		if (!autorizado(request, model, TipoUsuario.COORDENADOR))
			return Const.REDIRECT_UNAUTHORIZED;
		
		Calendar c = Calendar.getInstance(Locale.getDefault());
		int year = c.get(Calendar.YEAR);
		int yearStart = 2010; // Ano de início do funcionamento do SiAR
		List<Integer> anos = new ArrayList<Integer>();
		while (year >= yearStart) {
			anos.add(year);
			year--;
		}
		model.addAttribute("anosList", anos);

		model.addAttribute(Const.ATTR_TITLE, "Gerar relatório");
		model.addAttribute(Const.ATTR_LINK_ACTIVE, LINK_RELATORIOS.getPath());
		return "relatoriosiar";
	}
	
	@RequestMapping(value = RELATORIOS, method = RequestMethod.POST)
	public void gerarRelatorio(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws IOException {

		if (!autorizado(request, model, TipoUsuario.COORDENADOR))
			return;
		
		String filename = "C:\\Users\\Leo\\Documents\\workbook.xls";
		DownloadService ds = appContext.getBean(DownloadService.class);
		
		ServletOutputStream out = response.getOutputStream();
		FileInputStream in = new FileInputStream(filename);
		
		int mes = Integer.parseInt(request.getParameter("mes"));
		int ano = Integer.parseInt(request.getParameter("ano"));
		
		Calendar c = Calendar.getInstance(Locale.getDefault());
		
		response.setContentType("application/vnd.ms-excel");
		response.addHeader("content-disposition", "attachment; filename=" + filename);
		// Writing to the OutputStream the workbook
		try {
			c.set(ano, mes, 1);
			Date start = c.getTime();
			if (mes == 11) {
				ano++;
				mes = 0;
			}
			else {
				mes++;
			}
			c.set(ano, mes, 1);
			Date end = c.getTime();
			ds.reportMissoes(start, end).write(out);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Writing over the existing file
		int octet;
		while((octet = in.read()) != -1)
		    out.write(octet);
		
		in.close();
		out.close();
	}
	
	private ApplicationContext appContext;

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		appContext = arg0;
	}
}
