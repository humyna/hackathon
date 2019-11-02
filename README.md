# hackathon
this repository maintains the demo code of Hackathon.

## wealthradius
### 项目简介
工程基于springboot搭建。</br>
这个项目是我们参加公司内部黑客马拉松的后端代码，主要实现了拼团和参团的逻辑。</br>

该项目只是为了确保MVP产品流程跑通。

### 使用说明
该项目可以作为业余项目的脚手架工程，方便快速搭建工程框架。</br>

* 数据库：mysql
新建数据库，
初始化sql，sql在wealthradius/docs/sql/目录下</br>
然后修改application-dev.yml文件中数据库配置</br>

> 注意：新建表，将建表语句等加到wealthradius/docs/sql/目录

* dao代码生成
使用generator-config.xml自动生成dao层代码。

* 接口定义
统一格式/api/module-name/endpoint