//package com.crm_system.springbootback.controller;
//
//import io.swagger.annotations.Api;
//import lombok.extern.slf4j.Slf4j;
//import net.sf.jasperreports.engine.*;
//import net.sf.jasperreports.engine.util.JRLoader;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.sql.DataSource;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.Map;
//
//@Slf4j
//@Api(tags="报表url管理")
//
//@RestController
//@RequestMapping("/jasperReport")
//public class JasperReportController {
//    @Resource
//    private DataSource dataSource;
//
//    /**
//     * 转换为pdf展示，也就是在线预览
//     *
//     * @param reportName
//     * @param parameters
//     * @param response
//     * @throws SQLException
//     * @throws ClassNotFoundException
//     * @throws JRException
//     * @throws IOException
//     */
//    @GetMapping("/{reportName}")
//    public void getReportByParam(
//            @PathVariable("reportName") final String reportName,
//            @RequestParam(required = false) Map<String, Object> parameters, HttpServletRequest request,
//            HttpServletResponse response) throws SQLException, ClassNotFoundException, JRException, IOException {
//        parameters = parameters == null ? new HashMap<>() : parameters;
//        if (reportName.equals("query2")){
//            parameters.put("wave_code",parameters.get("waveCode"));
//        }else if (reportName.equals("queryByWaveCode")){
//            parameters.put("wave_code",parameters.get("waveCode"));
//        }
//        Connection connection = dataSource.getConnection();
//        //获取文件流
//        ClassPathResource resource = new ClassPathResource(reportName + ".jasper");
//        InputStream in = resource.getInputStream();
//        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(in);
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,connection );
//        // JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JREmptyDataSource());
//        response.setContentType("application/pdf");
//        /*response.setContentType("text/html;charset=utf-8");*/
//        response.setHeader("Content-Disposition", "inline;");
//        final OutputStream outputStream = response.getOutputStream();
//        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
//        try {
//            connection.close();
//            in.close();
//            outputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    @GetMapping("/printReport/{reportName}")
//    public void printReport(
//            @PathVariable("reportName") final String reportName,
//            @RequestParam(required = false) Map<String, Object> parameters, HttpServletRequest request,
//            HttpServletResponse response) throws SQLException, ClassNotFoundException, JRException, IOException {
//        parameters = parameters == null ? new HashMap<>() : parameters;
//        if (reportName.equals("query2")){
//            parameters.put("wave_code",parameters.get("waveCode"));
//        }else if (reportName.equals("queryByWaveCode")){
//            parameters.put("wave_code",parameters.get("waveCode"));
//        }
//        //获取文件流
//        ClassPathResource resource = new ClassPathResource(reportName + ".jasper");
//        InputStream in = resource.getInputStream();
//        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(in);
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource.getConnection());
//        //打印
//        JasperPrintManager.printReport(jasperPrint,true);
//    }
//}