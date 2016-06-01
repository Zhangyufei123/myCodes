package myCodesTest;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class Application {

	static Logger logger = Logger.getLogger(Application.class.getName());
    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
            	logger.info("this log4j Hello world");
            	return "Hello World!";
            }
        };
    }

  public static void main(String[] args) {
      ApplicationContext context = 
          new AnnotationConfigApplicationContext(Application.class);
      MessagePrinter printer = context.getBean(MessagePrinter.class);
      printer.printMessage();
  }
}