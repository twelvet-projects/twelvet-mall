[中文](https://github.com/twelvet-s/twelvet/blob/master/README.md) | [English](https://github.com/twelvet-s/twelvet/blob/master/README_EN.md)

# 🚀twelvet

# JDK >= 17

[![AUR](https://img.shields.io/github/license/twelvet-s/twelvet)](https://github.com/twelvet-s/twelvet/blob/master/LICENSE)
[![](https://img.shields.io/badge/Author-TwelveT-orange.svg)](https://twelvet.cn)
[![](https://img.shields.io/badge/version-2.7.5-success)](https://github.com/twelvet-s/twelvet)
[![GitHub stars](https://img.shields.io/github/stars/twelvet-s/twelvet.svg?style=social&label=Stars)](https://github.com/twelvet-s/twelvet/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/twelvet-s/twelvet.svg?style=social&label=Fork)](https://github.com/twelvet-s/twelvet/network/members)
[![star](https://gitee.com/twelvet/twelvet/badge/star.svg?theme=white)](https://gitee.com/twelvet/twelvet/stargazers)
[![fork](https://gitee.com/twelvet/twelvet/badge/fork.svg?theme=white)](https://gitee.com/twelvet/twelvet/members)

## 直播启动
```ssh
docker run --name srs -d  ossrs/srs:5

docker cp srs:/usr/local/srs/conf /home/data/docker/srs \
        && docker cp srs:/usr/local/srs/objs /home/data/docker/srs

docker run -d --rm \
        --name srs \
        --env CANDIDATE=外网ip地址 \
        -p 1935:1935 \
        -p 8888:8080 \
        -p 1985:1985 \
        -p 8000:8000/udp \
        -v /home/data/docker/srs/conf:/usr/local/srs/conf/ \
        -v /home/data/docker/srs/objs:/usr/local/srs/objs/ \
        ossrs/srs:5 \
        objs/srs -c conf/rtc2rtmp.conf
```

## 这是基于[twelvet](https://github.com/twelvet-s/twelvet)微服务脚手架的秒杀商城系统，仅针对核心高并发技术，与实际商城无关。

# 总结的高并发要诀，欢迎进行改善(按实际情况设计，切勿过度设计)

## 缓存（多级缓存：本地缓存，前端缓存）、使用文件缓存系统进行降低缓存成本

## 分库分表

## 限流

## ES + Hbase

## 集群(多副本沉余)

## 冷热分离

## 就近读取

一款基于Spring Cloud Alibaba的权限管理系统，集成市面上流行库，可以作用为快速开发的一个框架使用

一套以微服务架构的脚手架,使用Spring Cloud Alibaba系列进行架构,学习并了解它将能快速掌握微服务核心基础。
此项目是为了减少业务代码的重复轮子,它具有一个系统该有的通用性核心业务代码,无论是微服务还是单体,都是通用的业务
但更多的,是为了学习微服务的理念以及开发 您可以使用它进行网站管理后台，网站会员中心，CMS，CRM，OA等待系统的开发,
当然,不仅仅是一些小系统,我们可以生产更多的服务模块,不断完善项目。

系统初心是为了能够更快地完成业务的需求，带来更好的体验、更多的时间。它将会用于孵化一些实用的功能点。
我们希望它们是轻量级，可移植性高的功能插件。

同时，我们更希望广大开发者能在其中更快地获得更好的解决方案、尽量降低我们的学习成本。
由此，我们应当把更多的时间投入到其它更有意义的事情当中，我们深知知识的重要性，但，并不希望仅拥有单一”知识“。
去感受/关爱更多光彩，无论人、事、物，它们也将成为你最好的灵感。

后端源码：https://github.com/twelvet-s/twelvet-mall

前端源码：https://github.com/twelvet-s/twelvet-mall-ui

技术文档：https://twelvet.cn/docs/

官方博客：https://twelvet.cn

## 🍎 分支说明

| 分支                   | 说明                                                                 |
|----------------------|--------------------------------------------------------------------|
| master               | java8 + springboot 2.7.x + springcloud 2021 + spring cloud alibaba |
| master-boot-3        | java17 + springboot 3.x + springcloud 2022 + spring cloud alibaba  |
| spring-cloud-tencent | java17 + springboot 3.x + springcloud 2022 + spring cloud tencent  |

## 项目结构

~~~
com.twelvet     
├── twelvet-ui              // 前端框架 [80]
├── twelvet-gateway         // 网关模块 [88]
├── twelvet-nacos           // nacos [8848]
├── twelvet-auth            // 认证中心 [8888]
├── twelvet-api             // 接口模块
│       └── twelvet-api-system                             // 系统接口
│       └── twelvet-api-dfs                                // DFS接口
│       └── twelvet-api-job                                // 定时任务接口
├── twelvet-framework       // 核心模块
│       └── twelvet-framework-core                         // 核心模块
│       └── twelvet-framework-log                          // 日志记录
│       └── twelvet-framework-datascope                    // 数据权限
│       └── twelvet-framework-jdbc                         // jdbc
│       └── twelvet-framework-swagger                      // swagger文档
│       └── twelvet-framework-redis                        // 缓存服务
│       └── twelvet-framework-security                     // 安全模块
│       └── twelvet-framework-utils                        // 工具模块
├── twelvet-server         // 业务模块
│       └── twelvet-server-system                          // 系统模块 [8081]
│       └── twelvet-server-job                             // 定时任务 [8082]
│       └── twelvet-server-dfs                             // DFS服务 [8083]
│       └── twelvet-server-gen                             // 代码生成 [8084]
│       └── twelvet-server-im                              // IM     [8085]
│       └── twelvet-server-goods                           // 商品服务 [8086]
├── twelvet-visual        // 图形化管理模块
|       └── twelvet-visual-sentinel                        // sentinel [8101]
│       └── twelvet-visual-monitor                         // 监控中心 [8102]
├──pom.xml                // 公共依赖
~~~

## 内置功能

1. 用户管理：用户是系统操作者，该功能主要完成系统用户配置。
2. 部门管理：配置系统组织机构（公司、部门、小组），树结构展现支持数据权限。
3. 岗位管理：配置系统用户所属担任职务。
4. 菜单管理：配置系统菜单，操作权限，按钮权限标识等。
5. 角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
6. 字典管理：对系统中经常使用的一些较为固定的数据进行维护。
7. 参数管理：对系统动态配置常用参数。
8. 异步：登录日志/系统操作日志/系统登录日志记记录和查询。
9. 定时任务：在线（添加、修改、删除）任务调度包含执行结果日志。
10. 代码生成：一键生成CRUD前后端代码，为业务开发提供更快的速度。
11. 服务监控：监视当前系统CPU、内存、磁盘、堆栈等相关信息。
12. 连接池监视：监视当前系统数据库连接池状态，可进行分析SQL找出系统性能瓶颈。
13. 分布式文件储存。
14. Swagger网关聚合文档。
15. Sentinel限流中心。
16. Nacos注册 + 配置中心。

## 演示图

<table>
    <tr>
        <td><img src="https://twelvet.cn/assets/images/twelvet/1.png"/></td>
        <td><img src="https://twelvet.cn/assets/images/twelvet/2.png"/></td>
    </tr>
    <tr>
        <td><img src="https://twelvet.cn/assets/images/twelvet/3.png"/></td>
        <td><img src="https://twelvet.cn/assets/images/twelvet/4.png"/></td>
    </tr>
    <tr>
        <td><img src="https://twelvet.cn/assets/images/twelvet/5.png"/></td>
        <td><img src="https://twelvet.cn/assets/images/twelvet/6.png"/></td>
    </tr>
</table>

## 在线体验

- admin/123456

演示地址：[https://cloud.twelvet.cn](https://cloud.twelvet.cn)

## 架构图

<img src="https://twelvet.cn/assets/images/twelvet/map.png"/>

## ✈️✈️✈️快速启动微服务

内存 > 16
需要自行安装maven、docker、docker-compose、node、yarn

```shell
# mvn
mvn clean && mvn install
# 进入脚本目录
cd ./docker
# 可执行权限
chmod 751 deploy.sh
# 执行启动（按需执行参数，[init|port|base|server|stop|rm]）
# 初始化
./deploy.sh init
# 基础服务
./deploy.sh base
# 启动twelvet
./deploy.sh server
# 启动UI
./deploy.sh nginx
```

## TwelveT微服务交流群

QQ群： [![加入QQ群](https://img.shields.io/badge/985830229-blue.svg)](https://jq.qq.com/?_wv=1027&k=cznM6Q00) 点击按钮入群。

## 🤝鸣谢

感谢jetbrains提供的许可证[![jetbrains](https://cloud.twelvet.cn/jetbrains.png)](https://www.jetbrains.com?from=https://github.com/twelvet-s/twelvet)
