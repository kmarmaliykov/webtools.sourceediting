<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<TITLE>pmr.jsp</TITLE>

<%!String testJspString = "testJspString"; %>
<script> 

var test = <%= testJspString %>;

</script>



</HEAD>
<BODY>
<%  %>
<P>Place jspInJavascript2.jsp's content here.</P>
   <script type="text/javascript">                      
        <%
        if( request.getAttribute("SoapURL") != null )
        {
        %>
        var soapURL = "<%= (String)request.getAttribute("SoapURL")%>";
        <%
        }
        else
        { 
        %>
        var soapURL = document.location.href;
   </script>
<% } %>
</BODY>
</HTML>
