# Student-Information-Management-System
学生信息管理系统

Student为作业，要求如下：

设计一个学生类 Student：
* 私有变量
  * 学号 String id;
  * 姓名 String name;
  * 高数成绩 double grade;
  * 是否退学 boolean isOff;
* 方法

  * 上述变量对应的 **get 和 set 方法**，以及一个**重写的 toString() **方法来输出该学生的所有信息 (输出格式自己定)
  * 一个有学号、姓名、成绩的**构造方法**
  * 一个**静态(static)方法** update(Student 学生, double 成绩) ，老师算错了成绩，修改你的成绩

    tips:

    * 加的成绩必须是整数，学生不能已经退学了，总成绩不能超过100分
    * 如果出现以上情况，都视为修改失败，学生信息不应改变
    * 不论是否修改成功，都应该有信息提示
  * 一个实例方法 isPassed() ，判断该学生是否挂科
  * 一个静态方法 unpassedList() ，输出挂科和退学的同学信息(并有一定区分)

    tips: 使用自己重写的 toString() 方法
    

Student2为Student的优化升级版

有以下功能：

1. 录入学生信息（学号，姓名，高数成绩，是否退学）
2. 查看所有学生的信息
3. 查看指定学生的信息
4. 删除指定学生的信息
5. 修改学生信息
6. 查看高数挂科和退学的学生名单
7. 退出系统
