# ThoughtWork —— todolist
## 任务拆解
* 编写测试——耿佃昆
* 编写一个读取和写入文件，以及存储数据的辅助类——曹静博
* 编写添加、删除和修改事务的类——肖铮
* 组合各个功能，编写一个命令行程序——王雪
## 任务细节
### 类的功能
* FileIO 
    * 负责文件的读取和写入
    * 读写文件为.xml格式，示例：
    ~~~
        <?xml version="1.0" encoding="UTF-8"?>    
            <events>    
                <event id="0">  
                    <title>demo</title>  
                    <ddl>demo</ddl>  
                    <status>demo</status>  
                </event>    
            </events>    
    ~~~
* Item 用于存储单个todoList表项
* List 是一个todoList的类


