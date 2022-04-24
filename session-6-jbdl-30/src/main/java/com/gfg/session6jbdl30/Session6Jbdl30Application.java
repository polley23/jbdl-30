package com.gfg.session6jbdl30;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Session6Jbdl30Application {
	@Autowired//field based di
	Printer printer;// dependency inj
	@Autowired
	ClassB classB;
//	//consturctor based DI
//	Session6Jbdl30Application(Printer printer,ClassB classB){
//		this.printer=printer;
//		this.classB=classB;
//	}


//	public Session6Jbdl30Application() {
//	}
//
//	public void setPrinter(Printer printer) {
//		this.printer = printer;
//	}
//
//	public void setClassB(ClassB classB) {
//		this.classB = classB;
//	}

	public static void main(String[] args) {

		ApplicationContext applicationContext =
				SpringApplication.run(Session6Jbdl30Application.class, args);

		Session6Jbdl30Application session6Jbdl30Application
				=applicationContext.getBean(Session6Jbdl30Application.class);

//		Printer printer = applicationContext.getBean(Printer.class);
//		ClassB classB = applicationContext.getBean(ClassB.class);
//
//		session6Jbdl30Application.setClassB(classB);
//		session6Jbdl30Application.setPrinter(printer);

		session6Jbdl30Application.printer.print();
		session6Jbdl30Application.classB.print();
	}
}
