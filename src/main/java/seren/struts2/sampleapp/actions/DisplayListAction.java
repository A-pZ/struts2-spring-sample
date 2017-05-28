package seren.struts2.sampleapp.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import seren.struts2.sampleapp.dto.SampleProduct;
import seren.struts2.sampleapp.service.ProductService;

@Namespace("/")
@ParentPackage("struts-thymeleaf")
@Results({@Result(name=ActionSupport.SUCCESS,type="thymeleaf-spring",location="list")})
@Log4j2
@Controller
@Scope("prototype")
public class DisplayListAction extends ActionSupport {

	@Action("list")
    public String execute() throws Exception {
		products = service.search();
		log.info("- search:{}" , products);

        return SUCCESS;
    }

	@Autowired
	ProductService service;

	@Getter @Setter
	List<SampleProduct> products;

}
