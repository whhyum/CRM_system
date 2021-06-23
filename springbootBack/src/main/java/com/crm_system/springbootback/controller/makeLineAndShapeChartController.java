package com.crm_system.springbootback.controller;

import java.awt.Font;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.servlet.DisplayChart;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.DefaultCategoryDataset;

@Controller
public class makeLineAndShapeChartController {
	@Bean
	public ServletRegistrationBean MyServlet() {
		return new ServletRegistrationBean<>(new DisplayChart(),"/chart");
	}
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping("makeLineAndShapeChart")
	public String makeLineAndShapeChart(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
         // 定义图表对象数据，数据
		DefaultCategoryDataset  dataset  =createDataset();
		JFreeChart  chart = ChartFactory.createLineChart(
			"折线图", // chart title
             "时间", // domain axis label
             "销售额(百万)", // range axis label
             dataset, // data
			PlotOrientation.VERTICAL, // orientation
			true, // include legend
			true, // tooltips
			false // urls
				);
		CategoryPlot plot = chart.getCategoryPlot();
		// 设置图示字体 
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 22)); 
		//设置横轴的字体
		CategoryAxis categoryAxis = plot.getDomainAxis();
		 categoryAxis.setLabelFont(new Font("宋体", Font.BOLD, 22));//x轴标题字体 
		 categoryAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 18));//x轴刻度字体

		 //以下两行 设置图例的字体
		LegendTitle legend = chart.getLegend(0);
		 legend.setItemFont(new Font("宋体", Font.BOLD, 14));
		 //设置竖轴的字体
			NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		 rangeAxis.setLabelFont(new Font("宋体" , Font.BOLD , 22)); //设置数轴的字体
		 rangeAxis.setTickLabelFont(new Font("宋体" , Font.BOLD , 22));
		
			rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());//去掉竖轴字体显示不全
		 rangeAxis.setAutoRangeIncludesZero(true);
		 rangeAxis.setUpperMargin(0.20);
		 rangeAxis.setLabelAngle(Math.PI / 2.0);
		 
		// 6. 将图形转换为图片，传到前台
			String fileName = ServletUtilities.saveChartAsJPEG(chart, 700, 400, null, request.getSession());
			String chartURL = request.getContextPath() + "/chart?filename=" + fileName;
			model.addAttribute("makeLineAndShapeChart", chartURL);
			
		 return "makeLineAndShapeChart";
		}

		// 生成数据
		public static DefaultCategoryDataset createDataset() {
		  DefaultCategoryDataset linedataset = new DefaultCategoryDataset();

		 // 各曲线名称
		  String [] series= {"冰箱","彩电","洗衣机"};
		 // 横轴名称(列名称)
		  String [] month = {"1月","2月","3月","4月"};
		 //具体数据
		 double [] num = {4,5,6,10,10,15,20,16,10,18,25,19};
		 
		 int l1 = num.length/series.length; //4
		 int l2 = month.length;
		 int j=0;
		 for(int i=0;i<num.length;i++) {
			 linedataset.addValue(num[i], series[i/l1], month[j]);	
			 j++;
			 if(j==month.length)
				 j=0;
		 }			 
		 return linedataset;
		}		
}