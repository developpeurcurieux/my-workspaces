# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM openjdk:8
ADD target/docker-e-school.jar docker-e-school
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "docker-e-school"]
