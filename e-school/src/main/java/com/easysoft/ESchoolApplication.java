package com.easysoft;



import com.easysoft.dao.repository.EtudiantRepository;
import com.easysoft.entites.Etudiant;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class ESchoolApplication {

	public static void main(String[] args) throws ParseException{
            ApplicationContext ctx = SpringApplication.run(ESchoolApplication.class, args);
            EtudiantRepository etudiantRepository = ctx.getBean(EtudiantRepository.class);
            
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            
            etudiantRepository.save(new Etudiant(null, "Ahmed", df.parse("1988-11-10"), "ahmed@gmail.com", "ahmed.jpg"));
            etudiantRepository.save(new Etudiant(null, "Tesla", df.parse("1988-11-10"), "tesla@gmail.com", "ahmed.jpg"));
            etudiantRepository.save(new Etudiant(null, "Leslie", df.parse("1988-11-10"), "leslie@gmail.com", "ahmed.jpg"));
            etudiantRepository.save(new Etudiant(null, "Ahmed", df.parse("1988-11-10"), "ahmed@gmail.com", "ahmed.jpg"));
            etudiantRepository.save(new Etudiant(null, "Tesla", df.parse("1988-11-10"), "tesla@gmail.com", "ahmed.jpg"));
            etudiantRepository.save(new Etudiant(null, "Leslie", df.parse("1988-11-10"), "leslie@gmail.com", "ahmed.jpg"));
          
            
            
            Page<Etudiant> etds = etudiantRepository.findAll(new PageRequest(0, 5));
            
            etds.forEach(e -> System.out.println(e.getNom()));
        }
}
