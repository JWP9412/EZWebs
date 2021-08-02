[JDBC Driver]

Oracle Database 12.2.0.1 JDBC Driver & UCP Downloads
Path:
https://www.oracle.com/database/technologies/jdbc-ucp-122-downloads.html

Filename : ojdbc8.jar
Install Path : Tomcat/lib/ojdbc8.jar

--------------------------------------------------------------------------------
커넥션풀(Connection Pool)

DBCP : http://www.java2s.com/Code/Jar/t/Downloadtomcatdbcp7030jar.htm
Download : tomcat-dbcp-7.0.30.jar
Install Path : Tomcat/lib/tomcat-dbcp-7.0.30.jar

 Edit -> context.xml (Tomcat:/conf/context.xml)
 <Context>
 	<Resource
	    	name="jdbc/oracle"
	    	auth="Container"
	    	type="javax.sql.DataSource"
	    	driverClassName="oracle.jdbc.OracleDriver"
	    	url="jdbc:oracle:thin:@localhost:1521:xe"
	    	username="SHYUSER"
	    	password="SHYUSER"
	    	maxActive="50"
	    	maxWait="-1"
    />
</Context>    
    