# 2019-SummerCodding

정보
----
- OS version: ubuntu 18.04
- JAVA version: 1.8.0_201
- MySQL version: 5.7
- Eclipse version: ide 4.10.0
- Tool version: Spring Tool Suite 4.3.5

시작하기
----
모든 소스코드는 Eclipse + Window10 + JAVA 8 환경에서 작성되었습니다.
이 프로젝트에서는 아래 같은 MAVEN 의존성 프로젝트가 포함되어있습니다.
````
<dependencies>
      <!-- SPRING -->
      <dependency>
         <groupId>org.springframework</groupId>
         <artifactId>spring-context</artifactId>
         <version>4.3.5.RELEASE</version>
      </dependency>
      <dependency>
         <groupId>org.springframework</groupId>
         <artifactId>spring-jdbc</artifactId>
         <version>4.3.5.RELEASE</version>
      </dependency>
      <dependency>
         <groupId>org.springframework</groupId>
         <artifactId>spring-webmvc</artifactId>
         <version>4.3.5.RELEASE</version>
      </dependency>
      <dependency>
         <groupId>org.springframework</groupId>
         <artifactId>spring-tx</artifactId>
         <version>4.3.5.RELEASE</version>
      </dependency>

      <!-- MYSQL -->
      <dependency>
         <groupId>mysql</groupId>
         <artifactId>mysql-connector-java</artifactId>
         <version>5.1.45</version>
      </dependency>

      <!-- DATASOURCE -->
      <dependency>
         <groupId>org.apache.commons</groupId>
         <artifactId>commons-dbcp2</artifactId>
         <version>2.0</version>
      </dependency>

      <!-- Servlet JSP JSTL -->
      <dependency>
         <groupId>javax.servlet</groupId>
         <artifactId>javax.servlet-api</artifactId>
         <version>3.1.0</version>
         <scope>provided</scope>
      </dependency>
      <dependency>
         <groupId>javax.servlet.jsp</groupId>
         <artifactId>javax.servlet.jsp-api</artifactId>
         <version>2.3.1</version>
         <scope>provided</scope>
      </dependency>
      <dependency>
         <groupId>jstl</groupId>
         <artifactId>jstl</artifactId>
         <version>1.2</version>
      </dependency>

      <!-- Jackson Module -->
      <dependency>
         <groupId>com.fasterxml.jackson.core</groupId>
         <artifactId>jackson-databind</artifactId>
         <version>2.8.6</version>
      </dependency>
      <dependency>
         <groupId>com.fasterxml.jackson.datatype</groupId>
         <artifactId>jackson-datatype-jdk8</artifactId>
         <version>2.8.6</version>
      </dependency>

      <dependency>
         <groupId>junit</groupId>
         <artifactId>junit</artifactId>
         <version>3.8.1</version>
         <scope>test</scope>
      </dependency>
   </dependencies>
````

Ubuntu에서 실행하기
----
* Open Project in Local

1. Install dependencies
 ````
 apt-get update
 apt-get install openjdk-8-jdk
 apt-get install openjdk-8-jre(optional)
 apt-get install tomcat9
 apt-get install mysql-server-5.7
 apt-get install git-core
 apt-get install maven
 
 // install chrome
 wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
 sudo dpkg -i ./google-chrome*.deb
 sudo apt-get install -f
 ````
 
2. Download repository from github
 ````
 git clone https://github.com/hzoou/2019-SummerCodding.git
 ````
 
3. Build project
 ````
 cd <Download_file_path>/2019-SummerCodding
 mvn package
 ````
 
4. Copy war file to tomcat9
 ````
 cp /<Download file path>/target/todolist.war /<tomcat file path>/webapps/
  (e.g. /home/hzoou/2019-SummerCodding/target/todolist.war /var/lib/tomcat9/webapps/)
 ````
 
5. Create DB
 ````
 mysql> CREATE DATABASE connectdb;
 mysql> use connectdb;
 mysql> CREATE TABLE `todo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `content` varchar(255) NOT NULL,
  `type` varchar(20) DEFAULT 'TODO',
  `sequence` int(11) NOT NULL,
  `deadline` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;
 mysql> CREATE USER 'connectuser'@localhost IDENTIFIED BY 'connect123!@#';
 mysql> GRANT ALL PRIVILEGES ON connectdb.* to 'connectuser'@localhost IDENTIFIED BY 'connect123!@#';
 mysql> FLUSH PRIVILEGES;
 ````
 
6. Open browser
 ````
 google-chrome 127.0.0.1:8080/todolist
 ````
 
* Open Project in deployed
 1. Open browser
  ````
  google-chrome http://15.164.26.231:8080/todolist
  ````
 
사용된 도구
----
* Spring Tool Suite - Spring 프레임워크
* Maven - 의존성 관리
* Tomcat - 웹 애플리케이션 서버
* Eclipse - JAVA 개발 tool
* MySQL - DataBase
* AWS EC2 - 클라우드 환경 컴퓨팅 시스템

저자
----
* 우혜주 - hzoou
 
