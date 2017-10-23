DROP DATABASE IF EXISTS test;
CREATE DATABASE test;
USE test;

CREATE TABLE book
(
  id int(8) NOT NULL AUTO_INCREMENT,
  title varchar(100) NOT NULL,
  description varchar(255) NOT NULL,
  author varchar(100) NOT NULL,
  isbn varchar(20) NOT NULL,
  printYear INT,
  readAlready BIT DEFAULT FALSE,
  PRIMARY KEY (id)
);

INSERT INTO book (title, description, author, isbn, printYear) VALUES
  ("Java: The Complete Reference", "Fully updated for Java SE 8", "Herbert Schildt", "978-9339212094", 2017),
  ("Head First Java", "Computer programming language Java is not easy to understand", "Kathy Sierra", "978-8173666025", 2005),
  ("Java: A Beginner's Guide", "Fully updated for Java Platform, Standard Edition 9 (Java SE 9)", "Herbert Schildt", "978-1259589317", 2017),
  ("Swing: A Beginner's Guide", "Learn to program with Swing", "Herbert Schildt", "978-0070636484", 2006),
  ("Herb Schildt's Java Programming Cookbook", "Herb Schildt shares some of his favorite programming techniques", "Herbert Schildt", "978-0072263152", 2007),
  ("The Art of Java", "Herb Schildt brings his crystal clear prose", "Herbert Schildt", "978-0070582705", 2003),
  ("Programming with Java", "It is well suited for a first-level programming course in Java", "E Balagurusamy", "978-9351343202", 2017),
  ("Effective Java Second Edition", "This highly anticipated new edition of the classic", "Joshua Bloch", "978-9332576537", 2016),
  ("Java 8 in Action", "Every new version of Java is important, but Java 8 is a game changer", "Raoul-Gabriel Urma", "978-9351197430", 2014),
  ("Head First Design Patterns", "10th Anniversary Edition (Covers Java 8)", "Eric Freeman", "978-9352132775", 2014),
  ("Cracking the Coding Interview", "Learn how to uncover the hints and hidden details in a question", "Gayle Laakmann McDowell", "978-0984782864", 2015),
  ("Java Programming Interviews Exposed", "These real-world questions come from real employer interviews", "Noel Markham", "978-8126548569", 2014),
  ("Software Architecture: Interview Questions", "If you are looking for an architecture job role then this is the book.", "Shivprasad Koirala", "978-8183332804", 2008),
  ("Professional Java for Web Applications", "This book is a title that developers can read when building a Java application", "Nicholas S. Williams", "978-8126548781", 2014),
  ("Spring and Hibernate", "Learn Spring and Hibernate", " K. Santosh Kumar", "978-1259063725", 2017),
  ("Spring in Action", "It covers Spring core, Spring MVC, Security, Web Flow and more", "Craig Walls", "978-9351197997", 2015),
  ("Professional Hibernate", "This book is for Java developers who already understand how to build server-side Java applications", " Joseph D. Gradecki Eric Pugh", "978-8126505579", 2004),
  ("Mastering Hibernate", "This Book Is For Mastering Hibernate", "Ramin Rad", "978-1782175339", 2016),
  ("Java Persistence with Hibernate", "This book covers Hibernate 3.2 in detail along with the EJB 3.0 and Java Persistence 1.0 standards", "Christian Bauer", "978-8177227192", 2006),
  ("JDBC, Servlets and JSP Black Book", "This is a unique book for self learning ", " Kogent Solutions Inc. Santosh Kumar K.", "978-8177228373", 2008),
  ("Apache Maven Cookbook", "Apache Maven Cookbook is for those who want to learn how Apache Maven can be used for build automation", "Raghuram Bharathan", "978-1785286124", 2015),
  ("Instant Apache Maven Starter", "The book follows a starter approach for using Maven to create and build a new Java application", "Maurizio Turatti", "978-1782167600", 2013),
  ("Mastering Apache Maven 3", "For developers who want to take full advantage of Maven in designing, executing and more ", "Prabath Siriwardena", "978-1783983865", 2014),
  ("Maven The Definitive Guide", "Written by Maven creator Jason Van Zyl and his team at Sonatype, Maven", "Sonatype", "978-8184045987", 2008),
  ("Maven Build Customization", "This book is for developers and delivery managers who have some experience with Maven and Java", "Lorenzo Anardu", "978-1783987221", 2014);
  