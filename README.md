# 橘子汽车出租系统

> 本项目采用springboot

学习视频：[基于SSM+layui的汽车出租项目](https://www.bilibili.com/video/BV1d4411r7vn)  
真正的大师永远保持着一颗学徒的心

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
        - 公司年度月份销售额曲线
        - 业务员年度销售额柱状图
    
        

## 相关技术栈

- Springboot
- mybatis-plus
- druid
- hutool
- spring security

## 数据库说明

> 数据库文件：[carrent.sql](carrent.sql)

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
