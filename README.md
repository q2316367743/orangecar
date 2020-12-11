# 橘子汽车出租系统

> 参考视频：[基于SSM+layui的汽车出租项目](https://www.bilibili.com/video/BV1d4411r7vn)  
> 真正的大师永远保持着一颗学徒的心

本项目采用springboot

**注**：本项目只是参考视频想法后进行实现，故项目与视频除功能外差距过大

## 功能说明

- 普通用户
    - 公告查看
    - 客户管理
        - 新增客户
        - 客户查询
    - 车辆管理
        - 车辆查询
    - 业务管理
        - 车辆出租
        - 车辆入库
            - 出租单查询
            - 检查单新增
        - 出租单查询
    - 个人中心
        - 个人信息修改
        - 密码修改
- 管理员
    - 系统管理
        - 车辆管理
            - 新增车辆
            - 车辆查询
        - 客户管理
            - 新增客户
            - 修改客户信息
        - 出租单管理
            - 查询出租单
        - 检查管理
            - 检查单查询
        - 用户管理
            - 新增用户
            - 用户基础信息修改
            - 用户密码重置
        - 系统公告
            - 新增系统公告
            - 修改系统公告
    - 数据统计
        - 客户地区统计
        - 业务员销售统计
        - 公司营收统计

## 项目安装

1. 创建数据库，执行[数据库文件](carrent.sql)
2. 运行项目

```shell script
git clone https://gitee.com/qiaoshengda/orangecar
cd orangecar
mvn package
cd target
java -jar orangecar-1.0.jar
```

3. 访问网站<localhost:8080>
4. 账号admin, 密码123456

访问localhost:8080

## 相关技术栈

- Springboot
- mybatis-plus
- druid
- hutool
- spring security

## 数据库说明

> 数据库文件：[carrent.sql](carrent.sql)

==数据库版本建议**MySQL8.0**以上或**MariaDB10.0**以上==

### bus_car

|字段|类型|长度|说明|备注|
|:-----|:-----|:-----|:-----|:-----|
|number|varchar|10|车牌号||
|brand|varchar|255|车辆品牌||
|color|varchar|255|车辆颜色||
|buy_price|double|8,2|购买价格||
|rent_price|double|8,2|出租价格||
|deposit|double|8,2|押金||
|status|tinyint|1|车辆状态|0：未出租；1：已出租|
|description|varchar|255|车辆描述||
|image|varchar|255|图片路径||
|created|datetime|0|录入时间||
|operator|varchar|9|录入人|外键->用户|

### bus_check

|字段|类型|长度|说明|备注|
|:-----|:-----|:-----|:-----|:-----|
|id|varchar|32|检查单号||
|check_date|datetime|0|检查时间||
|description|varchar|255|问题描述||
|problem|varchar|255|存在的问题||
|compensate|double|8,2|赔偿金额||
|operator|varchar|9|操作人||
|rent_id|varchar|32|出租单号||

### bus_customer

|字段|类型|长度|说明|备注|
|:-----|:-----|:-----|:-----|:-----|
|identity|varchar|18|身份证号||
|name|varchar|255|姓名||
|gender|tinyint|1|性别|0：未知，1：男，2：女|
|address|varchar|255|地址||
|phone|varchar|11|电话||
|career|varchar|255|职位||
|created|datetime|0|创建时间||
|exist|tinyint|1|是否存在|1：存在；0:不存在'|
|operator|varchar|9|操作人||

### bus_rent

|字段|类型|长度|说明|备注|
|:-----|:-----|:-----|:-----|:-----|
|id|varchar|64|出租单号||
|price|double|8,2|实际出租价格||
|begin_time|date|0|起租时间||
|return_time|date|0|预计还车时间||
|real_time|datetime|0|实际还车时间||
|rent_status|tinyint|1|出租状态|0：出租中；1：已归还|
|customer_identity|varchar|255|客户身份证号||
|car_number|varchar|10|车辆车牌||
|operator|varchar|9|操作人||
|created|datetime|0|创建时间||

### sys_announcement

|字段|类型|长度|说明|备注|
|:-----|:-----|:-----|:-----|:-----|
|id|int|9|ID||
|title|varchar|255|标题||
|content|longtext||内容||
|created|datetime|0|创建时间||
|operator|varchar|9|操作人||

### sys_user

|字段|类型|长度|说明|备注|
|:-----|:-----|:-----|:-----|:-----|
|username|varchar|9|用户名||
|password|varchar|64|密码||
|identity|varchar|18|身份证号||
|name|varchar|32|姓名||
|gender|tinyint|1|性别|0：未知，1：男，2：女|
|address|varchar|255|家庭地址||
|phone|varchar|11|电话||
|position|varchar|255|职位||
|type|tinyint|1|帐户类型|0：普通用户；1：管理员|

