package edu.scau;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@ServletComponentScan注解后，Servlet Filter Listener可以直接通过@WebServlet @WebFilter @WebListener注解自动注册，无需任何代码
@SpringBootApplication
@ServletComponentScan
@MapperScan("edu.scau.common.mapper")
public class OccaptionsApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(OccaptionsApplication.class,args);
    }
}
