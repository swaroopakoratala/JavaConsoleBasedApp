package com.childdaycarecenter.performancereport;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import com.childdaycarecenter.configuration.Connectionmanager;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;

public class Performancereport {
	
	Connection con = null;
	{
		con = Connectionmanager.getConnection();
		
			JasperReportBuilder report = DynamicReports.report();//a new report
		report
		  .columns(
			
		      Columns.column("COMMENTS", "FEEDBACK", DataTypes.stringType()), 
		      Columns.column("CHILD ID", "CHILDID", DataTypes.integerType())
		      .setFixedColumns(15)
		     
		      
				  )
		  .title(//title of the report
		      Components.text("FEEDBACK CHILD")
			  .setHorizontalAlignment(HorizontalAlignment.CENTER))
			  .pageFooter(Components.pageXofY())//show page number on the page footer
			  .setDataSource("SELECT  FEEDBACK,CHILDID FROM CHILDPERFORMANCE",
	                                  con);

		try {
	                //show the report
			report.show();

	                //export the report to a pdf file
			report.toPdf(new FileOutputStream("D:/report.pdf"));
		} catch (DRException e) {
			System.out.println("Exception Occure due to" + e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("Exception Occure due to" + e.getMessage());
		}
	  }
	

}
