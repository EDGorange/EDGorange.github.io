---
title: maven纠错篇
layout: post
categories: maven
tags: maven
excerpt: maven
---
##### maven无法下载springboot-parent的依赖
遇到这个错误好久了，一直没有找到真正的原因，今天决定一探究竟，终于找到了最终原因以及解决方案。   
首先先告诉大家如何去解决这个问题，然后再普及一些知识点。   
解决方案：   
1. Maven->Runner->->Importing->VM Options for importer:-Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true   
2. 删除本地仓库中下载失败的依赖也就是有last....，可以选择删掉org.springframework.boot下的所有文件。    
3. 点击clean或者执行maven的clean命令。   
4. 执行完第三部基本已经搞定了，如果发现还有红色波浪线，请点击菜单栏file选择Invalidate and Restart。 搞定！！！         

 


```

-Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true

```   

##### seeting.xml到底如何配置？网上为何众说纷纭？到底如何选择？   
我们碰到的maven相关的问题一般都会百度，然而发现百度的解决方法就是一盘大杂烩，选了这种方式不行，那种也不行，浪费时间，其实我们应该多锻炼自己解决问题的能力，既可以提高个人能力，也可以使得我们在众多答案中如何慧眼识珠，一锤定音。   
首先分享几个maven相关的知识点，这是我本次纠错过程中学习到的。   
1. 阿里云提供的maven的仓库有哪些？   
[阿里云云效提供的公共代理仓库](https://maven.aliyun.com/mvn/guide)

2. seeting.xml正确的配置？   
网上有很多配置形式，总结起来是因为以下几点原因所导致的：   
1. 旧版网址。那如何查看最新的网址呢？请直接点击上面提供的官方链接查看即可！   
2. 多个mirror组合。 其实是因为我们不理解  <mirrorOf>*</mirrorOf>这里的*的含义。我通过查看官方文档以及作了一些测试发现，其实这里的*基本以及可以覆盖我们常用的阿里云云效所提供的的仓库了，给出官方文档链接：[seeting.xml文档解析](https://maven.apache.org/guides/mini/guide-mirror-settings.html)
总结： 正确的配置方式只有一种:      
  

   
```
<mirror>
  <id>aliyunmaven</id>
  <mirrorOf>*</mirrorOf>
  <name>阿里云公共仓库</name>
  <url>https://maven.aliyun.com/repository/public</url>
</mirror>

```   

3. 关于使用阿里云镜像的问题，为什么有的是镜像是http？有的是https？到底在改为https后如何正确配置idea的vm参数才可以正常下载依赖呢？   
之前的镜像配置一直是http协议，再后来阿里使用了https，所以我们现在应该使用的是https的镜像才可以正常访问maven仓库，但是在 一些idea中配置完maven的仓库后还是不能正常下载依赖，这是因为https是需要配置ssl证书的，然而之前有配置过ssl证书但最终发现是无效的，具体的原因没有细究，因为我们也可以换一种思路就是通过配置一些vm的参数来避开ssl，我们可以在idea中通过设置：      

![maven配置忽略SSL证书](/assets/maven配置忽略SSl证书.png)   

   






		
			
 







   










 




   

