<#import "/spring.ftl" as spring />
<#assign base = "${rc.contextPath}">
<@layout.extends name="/index.layout.ftl">
  <@layout.put block="app-content" type="replace">
  welcome
  </@layout.put>
</@layout.extends>
