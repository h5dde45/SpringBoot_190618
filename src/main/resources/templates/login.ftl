<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
Login page
<div>
    <@l.login "/login" />
</div>
<a href="/registration">Add new user</a>
</@c.page>