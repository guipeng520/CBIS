# CBIS INSTALL
## 一.安装准备
1. jdk 1.8 +;
2. mysql 5.36 +;
3. create database cbis;
4. Intellij idea 14 +。
# CBIS RUN
## 一.运行方式
方式一 : run Application.java;
方式二 :  mvn spring-boot:run。
# CBIS 目前已入注技术
## 一.maven
是基于项目对象模型(POM)，可以通过一小段描述信息来管理项目的构建，报告和文档的软件项目管理工具。
## 二.spring boot
是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring应用的初始搭建以及开发过程。该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。通过这种方式，Boot致力于在蓬勃发展的快速应用开发领域（rapid application development）成为领导者。
## 三.jooq
jOOQ（Java Object Oriented Querying，即面向Java对象查询）是一个高效地合并了复杂SQL、类型安全、源码生成、ActiveRecord、存储过程以及高级数据类型的Java API的类库。
## 四.thymeleaf
是一个XML/XHTML/HTML5模板引擎，可用于Web与非Web环境中的应用开发。它是一个开源的Java库，基于Apache License 2.0许可，由Daniel Fernández创建，该作者还是Java加密库Jasypt的作者。
## 五.spring security
是一个能够为基于Spring的企业应用系统提供声明式的安全访问控制解决方案的安全框架。它提供了一组可以在Spring应用上下文中配置的Bean，充分利用了Spring IoC，DI（控制反转Inversion of Control ,DI:Dependency Injection 依赖注入）和AOP（面向切面编程）功能，为应用系统提供声明式的安全访问控制功能，减少了为企业系统安全控制编写大量重复代码的工作。
## 六.flyway
- 自动升级（自动发现更新项）：Flyway 会将任意版本的数据库升级到最新版本。Flyway 可以脱离JVM 环境通过命令行执行，可以通过Ant 脚本执行，通过Maven 脚本执行（这样就可以在集成环境自动执行），并且可以在应用中执行（比如在应用启动时执行）。
- 规约优于配置：Flyway 有一套默认的规约，所以不需要修改任何配置就可以正常使用。
- 既支持SQL 脚本，又支持Java 代码：可以使用SQL 脚本执行数据库更新，也可以使用Java 代码来进行一些高级数据升级操作。
- 高可靠性：在集群环境下进行数据库升级是安全可靠的。
- 支持清除已存在的库表结构：Flyway 可以清除已存在的库表结构，可以从零开始搭建您的库表结构，并管理您的数据库版本升级工作。
- 支持失败修复。新的2.0 版本提供了repair 功能，用于解决数据库更新操作失败问题。
# CBIS 项目进度
2016-03-30    已完成系管理，专业管理，班级管理，用户管理
# CBIS TEAM
## 一.如何团队合作
1. 您可以点击项目右上方的fork,当然您也可以顺便给项目star;
2. 用自己的账号clone下cbis。

