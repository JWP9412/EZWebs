
[Tomcat]
Tomcat:/conf/sevrver.xml

    <Connector port="8090" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" />
    <!-- A "Connector" using the shared thread pool-->
    <!--
    <Connector executor="tomcatThreadPool"
               port="8090" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" />


------------------------------------------------------------------------------
[JDBC Driver]
https://www.oracle.com/kr/database/technologies/appdev/jdbc-downloads.html

Oracle Database 12.2.0.1 JDBC Driver & UCP Downloads
https://www.oracle.com/database/technologies/jdbc-ucp-122-downloads.html

Filename: ojdbc8.jar
Install Path: Tomcat/lib/ojdbc8.jar

------------------------------------------------------------------------------
[컨넥션풀(Connection Pool)]
(DBCP)
http://www.java2s.com/Code/Jar/t/Downloadtomcatdbcp7030jar.htm

(Tomcat:/lib)
tomcat-dbcp-7.0.30.jar

(Tompcat:/conf/context.xml)
<Context>
	<Resource
		name="jdbc/oracle"
		auth="Container"
		type="javax.sql.DataSource"
		driverClassName="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521:xe"
		username="SOLUSER"
		password="SOLUSER"
		maxActive="50"
		maxWait="-1"
	/>
</Context>	
	